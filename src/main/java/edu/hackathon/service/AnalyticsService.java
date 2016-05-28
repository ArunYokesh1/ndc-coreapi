/**
 * 
 */
package edu.hackathon.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.hackathon.repository.BookingRepository;
import edu.hackathon.repository.model.Booking;
import edu.hackathon.rest.domain.BookingAnalytics;

/**
 * @author x096284
 *
 */
@Service
public class AnalyticsService {

	@Autowired
	private BookingRepository bookingRepository;

	public BookingAnalytics forecastBookingCost(Date from, Date to) {
		// List<Booking> bookings =
		// bookingRepository.findBookingOrderedTimeWithinTime(from, to);

		List<Booking> bookings = new ArrayList<>();

		BookingAnalytics analyticsRes = new BookingAnalytics();

		return analyticsRes;
	}

}
