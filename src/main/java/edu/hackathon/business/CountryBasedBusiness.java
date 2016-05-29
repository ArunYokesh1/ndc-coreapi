package edu.hackathon.business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.ListUtils;
import org.apache.commons.lang3.StringUtils;
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

	public void fillterPerCountry(List<Booking> bookings, BookingAnalytics analyticsRes, boolean randomaise) {
		Map<String, List<Booking>> countryFilteredBookings = splitByCountry(bookings);
		for (String countryCode : countryFilteredBookings.keySet()) {
			setBookingCostAndCount(countryCode, countryFilteredBookings, analyticsRes, randomaise);
		}

	}

	private void setBookingCostAndCount(String countryCode, Map<String, List<Booking>> countryFilteredBookings,
			BookingAnalytics analyticsRes, boolean randomaise) {
		String[] countryCodeSplit = StringUtils.split(countryCode, "-");
		Country country = new Country();
		country.setCode(countryCodeSplit[0]);
		country.setName(countryCodeSplit[1]);
		List<Booking> bookings = countryFilteredBookings.get(countryCode);
		setBookingCostAndCount(bookings, country, randomaise);
		setAncillaryCostAndCount(bookings, country, randomaise);
		filterByLocation(bookings, country, randomaise);
		analyticsRes.addCountry(country);
	}

	private void filterByLocation(List<Booking> bookings, Country country, boolean randomaise) {
		Map<String, List<Booking>> filteredBooking = splitByLocation(bookings);
		for (String location : filteredBooking.keySet()) {
			Location loc = new Location();
			loc.setName(location);
			List<Booking> tempBooking = filteredBooking.get(location);
			setBookingCostAndCount(tempBooking, loc, randomaise);
			setAncillaryCostAndCount(tempBooking, loc, randomaise);
			filterByDepartment(tempBooking, loc, randomaise);
			country.addLocation(loc);
		}

	}

	private void filterByDepartment(List<Booking> bookings, Location loc, boolean randomaise) {
		Map<String, List<Booking>> filteredBooking = splitByDepartment(bookings);
		for (String dept : filteredBooking.keySet()) {
			Department department = new Department();
			department.setName(dept);
			List<Booking> tempBooking = filteredBooking.get(dept);
			setBookingCostAndCount(tempBooking, department, randomaise);
			setAncillaryCostAndCount(tempBooking, department, randomaise);
			filterbyDepartureAirport(tempBooking, department, randomaise);
			loc.addDepartments(department);

		}
	}

	private void filterbyDepartureAirport(List<Booking> bookings, Department department, boolean randomaise) {
		Map<String, List<Booking>> filteredBooking = splitByDepartureAirport(bookings);
		for (String departureAirport : filteredBooking.keySet()) {
			Airport airport = new Airport();
			airport.setName(departureAirport);
			airport.setCode(departureAirport);
			List<Booking> tempBooking = filteredBooking.get(departureAirport);
			setBookingCostAndCount(tempBooking, airport, randomaise);
			setAncillaryCostAndCount(tempBooking, airport, randomaise);
			airport.setAirlines(filterbyAirline(tempBooking, randomaise));
			department.addAirport(airport);
		}
	}

	public List<Airline> filterbyAirline(List<Booking> bookings, boolean randomaise) {
		List<Airline> airlineList = new ArrayList<>();
		Map<String, List<Booking>> filteredBooking = splitByAirline(bookings);
		for (String airline : filteredBooking.keySet()) {
			Airline flightCompany = new Airline();
			String[] airlineCodeSplit = StringUtils.split(airline, "-");
			flightCompany.setName(airlineCodeSplit[1]);
			flightCompany.setCode(airlineCodeSplit[0]);
			List<Booking> tempBooking = filteredBooking.get(airline);
			setBookingCostAndCount(tempBooking, flightCompany, randomaise);
			setAncillaryCostAndCount(tempBooking, flightCompany, randomaise);
			flightCompany.setAncillaryProducts(filterByAncillary(tempBooking, randomaise));
			airlineList.add(flightCompany);
		}
		return airlineList;
	}

	public List<AncillaryProduct> filterByAncillary(List<Booking> bookings, boolean randomaise) {
		List<AncillaryProduct> ancillaryProds = new ArrayList<>();
		Map<String, List<Booking>> filteredBooking = splitByAncillary(bookings);
		for (String prodName : filteredBooking.keySet()) {
			AncillaryProduct ancillaryPro = new AncillaryProduct();
			ancillaryPro.setName(prodName);
			List<Booking> tempBooking = filteredBooking.get(prodName);
			setAncillaryCostAndCount(tempBooking, ancillaryPro, randomaise);
			// flightCompany.addAncillaryProducts(ancillaryPro);
			ancillaryProds.add(ancillaryPro);
		}
		return ancillaryProds;

	}

	private Map<String, List<Booking>> splitByAncillary(List<Booking> bookings) {
		Map<String, List<Booking>> filteredBooking = new HashMap<>();
		for (Booking booking : ListUtils.emptyIfNull(bookings)) {
			for (Passenger pax : ListUtils.emptyIfNull(booking.getPassengers())) {
				for (PassengerSegment paxSeg : ListUtils.emptyIfNull(pax.getPassengerSegments())) {
					for (Product product : ListUtils.emptyIfNull(paxSeg.getProducts())) {
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
		return filteredBooking;
	}

	private Map<String, List<Booking>> splitByAirline(List<Booking> bookings) {
		Map<String, List<Booking>> filteredBooking = new HashMap<>();
		if (bookings != null) {
			for (Booking booking : bookings) {
				for (Segment seg : booking.getItinerary().getSegments()) {
					List<Booking> tempBookings = filteredBooking.get(seg.getOperatingCarrier().getAirlineCode() + "-"
							+ seg.getOperatingCarrier().getAirlineName());
					if (tempBookings != null) {
						tempBookings.add(booking);
					} else {
						List<Booking> b = new ArrayList<Booking>();
						b.add(booking);
						filteredBooking.put(seg.getOperatingCarrier().getAirlineCode() + "-"
								+ seg.getOperatingCarrier().getAirlineName(), b);
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

	private Map<String, List<Booking>> splitByCountry(List<Booking> bookings) {
		Map<String, List<Booking>> filteredBooking = new HashMap<>();
		if (bookings != null) {
			for (Booking booking : bookings) {
				for (Passenger passenger : booking.getPassengers()) {
					List<Booking> tempBooking = filteredBooking
							.get(passenger.getCountryCode() + "-" + passenger.getCountry());
					if (tempBooking != null) {
						tempBooking.add(booking);
					} else {
						List<Booking> b = new ArrayList<Booking>();
						b.add(booking);
						filteredBooking.put(passenger.getCountryCode() + "-" + passenger.getCountry(), b);
					}

				}
			}
		}
		return filteredBooking;
	}

}
