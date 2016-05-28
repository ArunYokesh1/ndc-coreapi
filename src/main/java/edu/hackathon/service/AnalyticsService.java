/**
 * 
 */
package edu.hackathon.service;

import java.math.BigInteger;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.hackathon.business.BookingBasedBusiness;
import edu.hackathon.business.CountryBasedBusiness;
import edu.hackathon.repository.BookingRepository;
import edu.hackathon.repository.model.Booking;
import edu.hackathon.rest.domain.BookingAnalytics;
import edu.hackathon.rest.domain.DataRange;

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

	public List<BookingAnalytics> forecastBookingCost(DateTime from, DateTime to) {

		DateTime fromDateTime = new DateTime(from).minusYears(1);
		DateTime toDateTime = new DateTime(to).minusYears(1);

		List<DateTime> fromDateList = new LinkedList<>();
		List<DateTime> toDateList = new LinkedList<>();
		enrichSplittedDates(fromDateTime, toDateTime, fromDateList, toDateList);

		List<BookingAnalytics> analyticsResponses = new ArrayList<>();

		for (int i = 0; i < fromDateList.size(); i++) {

			BookingAnalytics analyticsRes = new BookingAnalytics();

			DataRange dataRange = new DataRange();
			dataRange.setFrom(fromDateList.get(i));
			dataRange.setTo(toDateList.get(i));
			analyticsRes.setDataRange(dataRange);
			analyticsRes.setDataType("actual");

			// Get the past year bookings at the same time
			List<Booking> bookings = bookingRepository.findAll();

			List<Booking> identifiedData = identifyPastYearData(bookings, fromDateList.get(i), toDateList.get(i));

			bookingBasedBusinessRules.calculateCostAndCount(identifiedData, analyticsRes);
			countryBasedBusinessRules.fillterPerCountry(identifiedData, analyticsRes);
			analyticsRes.setBookingCount(BigInteger.valueOf(identifiedData.size()));

			analyticsResponses.add(analyticsRes);
		}

		return analyticsResponses;
	}

	private List<Booking> identifyPastYearData(List<Booking> bookings, DateTime fromDateTime, DateTime toDateTime) {
		List<Booking> pastyearbooking = new ArrayList<>();
		for (Booking booking : bookings) {
			if (fromDateTime.isBefore(booking.getOrderedTime().getTime())
					&& toDateTime.isAfter(booking.getOrderedTime().getTime())) {
				pastyearbooking.add(booking);
			}
		}
		return pastyearbooking;

	}

	public BookingAnalytics bookingForecast(String from, String to, String type, String country) {
		return null;
	}

	/**
	 * 
	 * @param from
	 * @param to
	 * @param type
	 * @param country
	 * @param location
	 * @return
	 */
	public BookingAnalytics bookingForecast(String from, String to, String type, String country, String location) {
		return null;
	}

	/**
	 * 
	 * @param from
	 * @param to
	 * @param type
	 * @param country
	 * @param location
	 * @param department
	 * @return
	 */
	public BookingAnalytics bookingForecast(String from, String to, String type, String country, String location,
			String department) {
		return null;
	}

	/**
	 * 
	 * @param from
	 * @param to
	 * @param type
	 * @param airportCode
	 * @return
	 */
	public BookingAnalytics bookingForecastForAirport(String from, String to, String type, String airportCode) {
		return null;
	}

	/**
	 * 
	 * @param from
	 * @param to
	 * @param type
	 * @param airlineCode
	 * @return
	 */
	public BookingAnalytics bookingForecastForAirLine(String from, String to, String type, String airlineCode) {
		return null;
	}

	/**
	 * Return all the users from the institutions.
	 * 
	 * @return the list of user from the institutions
	 */
	public BookingAnalytics bookingActuals(Date from, Date to) {
		return null;
	}

	private void enrichSplittedDates(DateTime fromDate, DateTime toDate, List<DateTime> fromDateList,
			List<DateTime> toDateList) {
		for (int month = fromDate.getMonthOfYear(); month <= toDate.getMonthOfYear(); month++) {
			if (month == fromDate.getMonthOfYear()) {
				fromDateList.add(fromDate);
			} else {
				fromDateList.add(new org.joda.time.DateTime(fromDate.getYear(), month, 1, 0, 0));
			}

			if (month == toDate.getMonthOfYear()) {
				toDateList.add(toDate);
			} else {
				toDateList.add(new org.joda.time.DateTime(toDate.getYear(), month,
						Month.values()[month - 1].length(toDate.getYear() % 4 == 0), 0, 0));
			}
		}

	}
}
