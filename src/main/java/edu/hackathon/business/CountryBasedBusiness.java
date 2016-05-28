package edu.hackathon.business;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import edu.hackathon.repository.model.Booking;
import edu.hackathon.repository.model.Passenger;
import edu.hackathon.repository.model.PassengerSegment;
import edu.hackathon.repository.model.Product;
import edu.hackathon.repository.model.Segment;
import edu.hackathon.rest.domain.Airline;
import edu.hackathon.rest.domain.Airport;
import edu.hackathon.rest.domain.AncillaryProduct;
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
			country.addLocation(loc);
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
			filterbyDepartureAirport(tempBooking, department);
			loc.addDepartments(department);

		}
	}

	private void filterbyDepartureAirport(List<Booking> bookings, Department department) {
		Map<String, List<Booking>> filteredBooking = splitByDepartureAirport(bookings);
		for (String departureAirport : filteredBooking.keySet()) {
			Airport airport = new Airport();
			airport.setName(departureAirport);
			airport.setCode(departureAirport);
			List<Booking> tempBooking = filteredBooking.get(departureAirport);
			setBookingCostAndCount(tempBooking, airport);
			setAncillaryCostAndCount(tempBooking, airport);
			filterbyAirline(tempBooking, airport);
			department.addAirport(airport);
		}
	}

	private void filterbyAirline(List<Booking> bookings, Airport airport) {
		Map<String, List<Booking>> filteredBooking = splitByAirline(bookings);
		for (String airline : filteredBooking.keySet()) {
			Airline flightCompany = new Airline();
			flightCompany.setName(airline);
			flightCompany.setCode(airline);
			List<Booking> tempBooking = filteredBooking.get(airline);
			setBookingCostAndCount(tempBooking, flightCompany);
			setAncillaryCostAndCount(tempBooking, flightCompany);
			filterByAncillary(tempBooking, flightCompany);
			airport.addAirline(flightCompany);
		}
	}

	private void filterByAncillary(List<Booking> bookings, Airline flightCompany) {
		Map<String, List<Booking>> filteredBooking = splitByAncillary(bookings);
		for (String airline : filteredBooking.keySet()) {
			AncillaryProduct ancillaryPro = new AncillaryProduct();
			flightCompany.setName(airline);
			flightCompany.setCode(airline);
			List<Booking> tempBooking = filteredBooking.get(airline);
			setBookingCostAndCount(tempBooking, ancillaryPro);
			setAncillaryCostAndCount(tempBooking, ancillaryPro);
			flightCompany.addAncillaryProducts(ancillaryPro);
		}

	}

	private Map<String, List<Booking>> splitByAncillary(List<Booking> bookings) {
		Map<String, List<Booking>> filteredBooking = new HashMap<>();
		if (bookings != null) {
			for (Booking booking : bookings) {
				for (Passenger pax : booking.getPassengers()) {
					for (PassengerSegment paxSeg : pax.getPassengerSegments()) {
						for (Product product : paxSeg.getProducts()) {
							List<Booking> tempBookings = filteredBooking.get(product.getProductName());
							if (tempBookings != null) {
								tempBookings.add(booking);
							} else {
								List<Booking> b = new ArrayList<Booking>();
								b.add(booking);
								filteredBooking.put(product.getProductName(), b);
							}
						}
					}
				}
			}
		}
		return filteredBooking;
	}

	private Map<String, List<Booking>> splitByAirline(List<Booking> bookings) {
		Map<String, List<Booking>> filteredBooking = new HashMap<>();
		if (bookings != null) {
			for (Booking booking : bookings) {
				for (Segment seg : booking.getItinerary().getSegments()) {
					List<Booking> tempBookings = filteredBooking.get(seg.getOperatingCarrier().getAirlineCode());
					if (tempBookings != null) {
						tempBookings.add(booking);
					} else {
						List<Booking> b = new ArrayList<Booking>();
						b.add(booking);
						filteredBooking.put(seg.getOperatingCarrier().getAirlineCode(), b);
					}
				}
			}
		}
		return filteredBooking;
	}

	private Map<String, List<Booking>> splitByDepartureAirport(List<Booking> bookings) {
		Map<String, List<Booking>> filteredBooking = new HashMap<>();
		if (bookings != null) {
			for (Booking booking : bookings) {
				for (Segment seg : booking.getItinerary().getSegments()) {
					List<Booking> tempBookings = filteredBooking.get(seg.getDeparture().getAirportCode());
					if (tempBookings != null) {
						tempBookings.add(booking);
					} else {
						List<Booking> b = new ArrayList<Booking>();
						b.add(booking);
						filteredBooking.put(seg.getDeparture().getAirportCode(), b);
					}
				}
			}
		}
		return filteredBooking;
	}

	private Map<String, List<Booking>> splitByDepartment(List<Booking> bookings) {
		Map<String, List<Booking>> filteredBooking = new HashMap<>();
		if (bookings != null) {
			for (Booking booking : bookings) {
				for (Passenger pax : booking.getPassengers()) {
					List<Booking> tempBookings = filteredBooking.get(pax.getDepartment());
					if (tempBookings != null) {
						tempBookings.add(booking);
					} else {
						List<Booking> b = new ArrayList<Booking>();
						b.add(booking);
						filteredBooking.put(pax.getDepartment(), b);
					}
				}
			}
		}
		return filteredBooking;
	}

	private Map<String, List<Booking>> splitByLocation(List<Booking> bookings) {
		Map<String, List<Booking>> filteredBooking = new HashMap<>();
		if (bookings != null) {
			for (Booking booking : bookings) {
				for (Passenger passenger : booking.getPassengers()) {
					List<Booking> tempBookings = filteredBooking.get(passenger.getWorkingLocation());
					if (tempBookings != null) {
						tempBookings.add(booking);
					} else {
						List<Booking> b = new ArrayList<Booking>();
						b.add(booking);
						filteredBooking.put(passenger.getWorkingLocation(), b);
					}

				}
			}
		}
		return filteredBooking;
	}

	private Map<String, List<Booking>> splitByCountry(BookingAnalytics analyticsRes, List<Booking> bookings) {
		Map<String, List<Booking>> filteredBooking = new HashMap<>();
		if (bookings != null) {
			for (Booking booking : bookings) {
				for (Passenger passenger : booking.getPassengers()) {
					List<Booking> tempBooking = filteredBooking.get(passenger.getCountry());
					if (tempBooking != null) {
						tempBooking.add(booking);
					} else {
						List<Booking> b = new ArrayList<Booking>();
						b.add(booking);
						filteredBooking.put(passenger.getCountry(), b);
					}

				}
			}
		}
		return filteredBooking;
	}

}
