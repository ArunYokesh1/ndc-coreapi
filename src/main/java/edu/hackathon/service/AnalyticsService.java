/**
 * 
 */
package edu.hackathon.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.hackathon.business.BookingBasedBusiness;
import edu.hackathon.business.CountryBasedBusiness;
import edu.hackathon.repository.BookingRepository;
import edu.hackathon.repository.model.Booking;
import edu.hackathon.repository.model.Order;
import edu.hackathon.repository.model.Passenger;
import edu.hackathon.repository.model.PassengerSegment;
import edu.hackathon.repository.model.Product;
import edu.hackathon.repository.model.Segment;
import edu.hackathon.rest.domain.BookingAnalytics;
import edu.hackathon.rest.domain.DataRange;
import edu.hackathon.rest.domain.Price;
import edu.hackathon.util.DateUtil;

/**
 * @author x096284
 *
 */
@Service
public class AnalyticsService {

	@Autowired
	private BookingRepository bookingRepository;

	@Autowired
	private BookingBasedBusiness bookingBasedBusinessRules;

	@Autowired
	private CountryBasedBusiness countryBasedBusinessRules;

	public BookingAnalytics forecastBookingCost(Date from, Date to) {

		DateTime fromDateTime = new DateTime(from).minusYears(1);
		DateTime toDateTime = new DateTime(to).minusYears(1);
		// Get the past year bookings at the same time
		List<Booking> bookings = bookingRepository.findAll();

		identifyPastYearData(bookings, fromDateTime, toDateTime);

		BookingAnalytics analyticsRes = new BookingAnalytics();
		analyticsRes.setBookingCount(BigInteger.valueOf(bookings.size()));
		DataRange dataRange = new DataRange();
		dataRange.setFrom(from);
		dataRange.setTo(to);
		analyticsRes.setDataRange(dataRange);
		analyticsRes.setDataType("actual");

		bookingBasedBusinessRules.calculateCostAndCount(bookings, analyticsRes);

		countryBasedBusinessRules.fillterPerCountry(bookings, analyticsRes);
		return analyticsRes;
	}

	private void identifyPastYearData(List<Booking> bookings, DateTime fromDateTime, DateTime toDateTime) {
		List<Booking> pastyearbooking = new ArrayList<>();
		for (Booking booking : bookings) {
			for (Segment segment : booking.getItinerary().getSegments()) {
				Date departuretime = DateUtil.parseDate(segment.getDepartureTime());
				if (fromDateTime.isBefore(departuretime.getTime()) && toDateTime.isAfter(departuretime.getTime())) {
					pastyearbooking.add(booking);
				}
			}
		}

	}

}
