package edu.hackathon.business;

import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.springframework.stereotype.Component;

import edu.hackathon.repository.model.Booking;
import edu.hackathon.rest.domain.Airline;
import edu.hackathon.rest.domain.Analytics;
import edu.hackathon.rest.domain.AncillaryProduct;

@Component
public class AirlineBasedBusiness extends AbstractAnalyticsBusiness {

	public void calculateAnalytics(List<Booking> bookings, Airline airline, boolean doesRandomise) {
		setBookingCostAndCount(bookings, airline, doesRandomise);
		// setAncillaryCostAndCount(bookings, airline, doesRandomise);
		Map<String, List<Booking>> an = splitByMonth(bookings);
		for (String monthNumber : an.keySet()) {
			String[] monthYearSplit = StringUtils.split(monthNumber, "_");
			Analytics analytics = new Analytics();
			analytics.setMonth(new DateFormatSymbols().getMonths()[Integer.valueOf(monthYearSplit[0]) - 1]);
			setBookingCostAndCount(bookings, analytics, doesRandomise);
			setAncillaryCostAndCount(bookings, analytics, doesRandomise);
			airline.addAnalytic(analytics);
		}
	}

	private Map<String, List<Booking>> splitByMonth(List<Booking> bookings) {
		Map<String, List<Booking>> an = new LinkedHashMap<>();
		for (Booking booking : bookings) {
			DateTime dt = new DateTime(booking.getOrderedTime());
			String monthYear = dt.getMonthOfYear() + "_" + dt.getYear();
			List<Booking> tempBookings = an.get(monthYear);
			if (tempBookings != null) {
				tempBookings.add(booking);
			} else {
				List<Booking> intialBookings = new ArrayList<>();
				intialBookings.add(booking);
				an.put(monthYear, intialBookings);
			}
		}
		return an;
	}

	public void calculateAnalytics(List<Booking> bookings, AncillaryProduct anciProd, boolean doesRandomise) {
		setBookingCostAndCount(bookings, anciProd, doesRandomise);
		// setAncillaryCostAndCount(bookings, airline, doesRandomise);
		Map<String, List<Booking>> an = splitByMonth(bookings);
		for (String monthNumber : an.keySet()) {
			String[] monthYearSplit = StringUtils.split(monthNumber, "_");
			Analytics analytics = new Analytics();
			analytics.setMonth(new DateFormatSymbols().getMonths()[Integer.valueOf(monthYearSplit[0]) - 1]);
			setBookingCostAndCount(bookings, analytics, doesRandomise);
			setAncillaryCostAndCount(bookings, analytics, doesRandomise);
			anciProd.addAnalytics(analytics);
		}
	}

}
