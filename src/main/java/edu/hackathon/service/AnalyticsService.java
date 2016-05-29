/**
 * 
 */
package edu.hackathon.service;

import java.math.BigInteger;
import java.time.Month;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.hackathon.business.AirlineBasedBusiness;
import edu.hackathon.business.BookingBasedBusiness;
import edu.hackathon.business.CountryBasedBusiness;
import edu.hackathon.repository.BookingRepository;
import edu.hackathon.repository.model.Booking;
import edu.hackathon.rest.domain.Airline;
import edu.hackathon.rest.domain.AncillaryProduct;
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
	
	@Autowired
	private AirlineBasedBusiness airlineBasedBusinessRules;

	public List<BookingAnalytics> forecastBookingCost(DateTime from, DateTime to) {

		DateTime fromDateTime = new DateTime(from).minusYears(1);
		DateTime toDateTime = new DateTime(to).minusYears(1);

		List<DateTime> fromForcastedDateList = new LinkedList<>();
		List<DateTime> toForcastedDateList = new LinkedList<>();
		enrichSplittedDates(from, to, fromForcastedDateList, toForcastedDateList);

		List<DateTime> fromPastDateList = new LinkedList<>();
		List<DateTime> toPastDateList = new LinkedList<>();
		enrichSplittedDates(fromDateTime, toDateTime, fromPastDateList, toPastDateList);

		List<BookingAnalytics> analyticsResponses = new ArrayList<>();

		for (int i = 0; i < fromPastDateList.size(); i++) {

			BookingAnalytics analyticsRes = new BookingAnalytics();

			DataRange dataRange = new DataRange();
			dataRange.setFrom(fromForcastedDateList.get(i));
			dataRange.setTo(toForcastedDateList.get(i));
			analyticsRes.setDataRange(dataRange);
			analyticsRes.setDataType("forecast");

			// Get the past year bookings at the same time
			List<Booking> bookings = bookingRepository.findByOrderedTimeBetween(fromPastDateList.get(i),
					toPastDateList.get(i));

			// last param - to trigger randomization
			bookingBasedBusinessRules.calculateCostAndCount(bookings, analyticsRes, true);
			countryBasedBusinessRules.fillterPerCountry(bookings, analyticsRes, true);
			analyticsRes.setBookingCount(BigInteger.valueOf(bookings.size()));

			analyticsResponses.add(analyticsRes);
		}

		return analyticsResponses;
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
	public List<BookingAnalytics> bookingActuals(DateTime from, DateTime to) {

		List<DateTime> fromPastDateList = new LinkedList<>();
		List<DateTime> toPastDateList = new LinkedList<>();
		enrichSplittedDates(from, to, fromPastDateList, toPastDateList);

		List<BookingAnalytics> analyticsResponses = new ArrayList<>();

		for (int i = 0; i < fromPastDateList.size(); i++) {

			BookingAnalytics analyticsRes = new BookingAnalytics();

			DataRange dataRange = new DataRange();
			dataRange.setFrom(fromPastDateList.get(i));
			dataRange.setTo(toPastDateList.get(i));
			analyticsRes.setDataRange(dataRange);
			analyticsRes.setDataType("actual");

			// Get the past year bookings at the same time
			List<Booking> bookings = bookingRepository.findByOrderedTimeBetween(fromPastDateList.get(i),
					toPastDateList.get(i));

			bookingBasedBusinessRules.calculateCostAndCount(bookings, analyticsRes, false);
			countryBasedBusinessRules.fillterPerCountry(bookings, analyticsRes, false);
			analyticsRes.setBookingCount(BigInteger.valueOf(bookings.size()));

			analyticsResponses.add(analyticsRes);
		}

		return analyticsResponses;
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

	public BookingAnalytics forecastForAirlineBasedBooking(DateTime from, DateTime to) {
		BookingAnalytics bookingAnalytics = new BookingAnalytics();
		List<Booking> bookings = bookingRepository.findByOrderedTimeBetween(from, to);
		Map<String, List<Booking>> splittedBookings = countryBasedBusinessRules.splitByAirline(bookings);
		for (String airlineCode : splittedBookings.keySet()) {
			String[] airlineSplits = StringUtils.split(airlineCode, "-");
			Airline airline = new Airline();
			airline.setName(airlineSplits[1]);
			airline.setCode(airlineSplits[0]);
			List<Booking> tempBooking = splittedBookings.get(airlineCode);
			//countryBasedBusinessRules.setAncillaryCostAndCount(tempBooking, airline, true);
			countryBasedBusinessRules.setBookingCostAndCount(tempBooking, airline, true);
			airlineBasedBusinessRules.calculateAnalytics(tempBooking, airline, true);
			bookingAnalytics.addAirline(airline);
		}

		return bookingAnalytics;
	}

	public BookingAnalytics forecastForAncillaryBasedBooking(DateTime from, DateTime to) {
		BookingAnalytics bookingAnalytics = new BookingAnalytics();
		List<Booking> bookings = bookingRepository.findByOrderedTimeBetween(from, to);
		Map<String, List<Booking>> splittedBookings = countryBasedBusinessRules.splitByAncillary(bookings);
		for (String ancillary : splittedBookings.keySet()) {
			AncillaryProduct anciProd = new AncillaryProduct();
			anciProd.setName(ancillary);
			List<Booking> tempBooking = splittedBookings.get(ancillary);
			
			countryBasedBusinessRules.setBookingCostAndCount(tempBooking, anciProd, true);
			airlineBasedBusinessRules.calculateAnalytics(tempBooking, anciProd, true);
			bookingAnalytics.addAncillaryProduct(anciProd);
		}

		return bookingAnalytics;
	}
}
