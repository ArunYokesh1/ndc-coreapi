package edu.hackathon.business;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import edu.hackathon.repository.model.Booking;
import edu.hackathon.repository.model.Passenger;
import edu.hackathon.rest.domain.BookingAnalytics;
import edu.hackathon.rest.domain.Country;
import edu.hackathon.rest.domain.Department;
import edu.hackathon.rest.domain.Location;

@Component
public class CountryBasedBusiness extends AbstractAnalyticsBusiness {

	public void fillterPerCountry(List<Booking> bookings, BookingAnalytics analyticsRes) {
		Map<String, List<Booking>> countryFilteredBookings = splitByCountry(analyticsRes, bookings);
		for (String countryCode : countryFilteredBookings.keySet()) {
			setBookingCostAndCount(countryCode, countryFilteredBookings, analyticsRes);
		}

	}

	private void setBookingCostAndCount(String countryCode, Map<String, List<Booking>> countryFilteredBookings,
			BookingAnalytics analyticsRes) {
		for (String cc : countryFilteredBookings.keySet()) {
			Country country = new Country();
			country.setCode(cc);
			List<Booking> bookings = countryFilteredBookings.get(cc);
			country.setName(bookings.get(0).getPassengers().get(0).getCountry());
			setBookingCostAndCount(bookings, country);
			setAncillaryCostAndCount(bookings, country);
			filterByLocation(bookings, country);
			analyticsRes.addCountry(country);
		}
	}

	private void filterByLocation(List<Booking> bookings, Country country) {
		Map<String, List<Booking>> filteredBooking = splitByLocation(bookings);
		for (String location : filteredBooking.keySet()) {
			Location loc = new Location();
			loc.setName(location);
			List<Booking> tempBooking = filteredBooking.get(loc);
			setBookingCostAndCount(tempBooking, loc);
			setAncillaryCostAndCount(tempBooking, loc);
			filterByDepartment(tempBooking, loc);
		}

	}

	private void filterByDepartment(List<Booking> bookings, Location loc) {
		Map<String, List<Booking>> filteredBooking = splitByDepartment(bookings);
		for (String dept : filteredBooking.keySet()) {
			Department department = new Department();
			department.setName(dept);
			List<Booking> tempBooking = filteredBooking.get(dept);
			setBookingCostAndCount(tempBooking, department);
			setAncillaryCostAndCount(tempBooking, department);
			loc.addDepartments(department);
		}
	}

	private Map<String, List<Booking>> splitByDepartment(List<Booking> bookings) {
		Map<String, List<Booking>> filteredBooking = new HashMap<>();
		for (Booking booking : bookings) {
			for (Passenger pax : booking.getPassengers()) {
				List<Booking> tempBookings = filteredBooking.get(pax.getDepartment());
				if (tempBookings != null) {
					tempBookings.add(booking);
				} else {
					filteredBooking.put(pax.getDepartment(), Arrays.asList(booking));
				}
			}
		}
		return filteredBooking;
	}

	private Map<String, List<Booking>> splitByLocation(List<Booking> bookings) {
		Map<String, List<Booking>> filteredBooking = new HashMap<>();
		for (Booking booking : bookings) {
			for (Passenger passenger : booking.getPassengers()) {
				List<Booking> tempBookings = filteredBooking.get(passenger.getWorkingLocation());
				if (tempBookings != null) {
					tempBookings.add(booking);
				} else {
					filteredBooking.put(passenger.getWorkingLocation(), Arrays.asList(booking));
				}

			}
		}
		return filteredBooking;
	}

	private Map<String, List<Booking>> splitByCountry(BookingAnalytics analyticsRes, List<Booking> bookings) {
		Map<String, List<Booking>> filteredBooking = new HashMap<>();
		for (Booking booking : bookings) {
			for (Passenger passenger : booking.getPassengers()) {
				List<Booking> tempBooking = filteredBooking.get(passenger.getCountry());
				if (tempBooking != null) {
					tempBooking.add(booking);
				} else {
					filteredBooking.put(passenger.getCountry(), Arrays.asList(booking));
				}

			}
		}
		return filteredBooking;
	}

}
