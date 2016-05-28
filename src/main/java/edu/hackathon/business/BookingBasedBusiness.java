package edu.hackathon.business;

import java.util.List;

import edu.hackathon.repository.model.Booking;
import edu.hackathon.rest.domain.BookingAnalytics;

public class BookingBasedBusiness extends AbstractAnalyticsBusiness {

	public void calculateCostAndCount(List<Booking> bookings, BookingAnalytics analyticsRes) {
		setBookingCostAndCount(bookings, analyticsRes);
		setAncillaryCostAndCount(bookings, analyticsRes);
	}
}
