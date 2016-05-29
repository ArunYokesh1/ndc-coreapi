/**
 * 
 */
package edu.hackathon.controller;

import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.hackathon.rest.domain.BookingAnalytics;
import edu.hackathon.service.AnalyticsService;

/**
 * @author Prabu S B
 *
 */
@RestController
@RequestMapping("/analytics")
public class AnalyticsController {

	@Autowired
	private AnalyticsService analyticsService;

	@RequestMapping
	@ResponseBody
	public String healthcheck() {
		return "Server is Running properly :) ";
	}

	/**
	 * 
	 * @param from
	 * @param to
	 * @param type
	 * @return
	 */
	@RequestMapping("/forecast/{from}/{to}/{type}")
	@ResponseBody
	public HttpEntity<List<BookingAnalytics>> bookingForecast(@PathVariable String from, @PathVariable String to,
			@PathVariable String type) {
		return new ResponseEntity<>(
				analyticsService.forecastBookingCost(getDateFromString(from), getDateFromString(to)), HttpStatus.OK);
	}

	/**
	 * 
	 * @param from
	 * @param to
	 * @param type
	 * @param country
	 * @return
	 */
	@RequestMapping("/forecast/{from}/{to}/{type}/{country}")
	@ResponseBody
	public BookingAnalytics bookingForecast(@PathVariable String from, @PathVariable String to,
			@PathVariable String type, @PathVariable String country) {
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
	@RequestMapping("/forecast/{from}/{to}/{type}/{country}/{location}")
	@ResponseBody
	public BookingAnalytics bookingForecast(@PathVariable String from, @PathVariable String to,
			@PathVariable String type, @PathVariable String country, @PathVariable String location) {
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
	@RequestMapping("/forecast/{from}/{to}/{type}/{country}/{location}/{department}")
	@ResponseBody
	public BookingAnalytics bookingForecast(@PathVariable String from, @PathVariable String to,
			@PathVariable String type, @PathVariable String country, @PathVariable String location,
			@PathVariable String department) {
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
	@RequestMapping("/forecast/{from}/{to}/{type}/airport/{airportCode}}")
	@ResponseBody
	public BookingAnalytics bookingForecastForAirport(@PathVariable String from, @PathVariable String to,
			@PathVariable String type, @PathVariable String airportCode) {
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
	@RequestMapping("/forecast/{from}/{to}/{type}/airline/{airlineCode}}")
	@ResponseBody
	public BookingAnalytics bookingForecastForAirLine(@PathVariable String from, @PathVariable String to,
			@PathVariable String type, @PathVariable String airlineCode) {
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
	@RequestMapping("/forecast/airline/{from}/{to}")
	@ResponseBody
	public BookingAnalytics forecastForAirLineBasedBooking(@PathVariable String from, @PathVariable String to) {
		return analyticsService.forecastForAirlineBasedBooking(getDateFromString(from), getDateFromString(to));
	}

	/**
	 * 
	 * @param from
	 * @param to
	 * @param type
	 * @param airlineCode
	 * @return
	 */
	@RequestMapping("/forecast/ancillary/{from}/{to}")
	@ResponseBody
	public BookingAnalytics forecastForAncillaryBasedBooking(@PathVariable String from, @PathVariable String to) {
		return analyticsService.forecastForAncillaryBasedBooking(getDateFromString(from), getDateFromString(to));
	}
	/**
	 * Return all the users from the institutions.
	 * 
	 * @return the list of user from the institutions
	 */
	@RequestMapping("/actual/{from}/{to}")
	@ResponseBody
	public HttpEntity<List<BookingAnalytics>> bookingActuals(@PathVariable String from, @PathVariable String to) {
		return new ResponseEntity<>(analyticsService.bookingActuals(getDateFromString(from), getDateFromString(to)),
				HttpStatus.OK);
	}

	private DateTime getDateFromString(String sourceDate) {
		DateTimeFormatter formatter = DateTimeFormat.forPattern("dd-MM-yyyy");
		DateTime date = formatter.parseDateTime(sourceDate);
		return date;
	}

}
