package edu.hackathon.business;

import java.util.List;

import org.springframework.stereotype.Component;

import edu.hackathon.repository.model.Booking;
import edu.hackathon.rest.domain.BookingAnalytics;

@Component
public class BookingBasedBusiness extends AbstractAnalyticsBusiness {

	public void calculateCostAndCount(List<Booking> bookings, BookingAnalytics analyticsRes) {
		setBookingCostAndCount(bookings, analyticsRes);
		setAncillaryCostAndCount(bookings, analyticsRes);
	}
}
