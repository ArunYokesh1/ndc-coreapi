/**
 * 
 */
package edu.hackathon.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public List<BookingAnalytics> bookingForecast(@PathVariable String from, @PathVariable String to, @PathVariable String type) {
		return new ArrayList();
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
	public List<BookingAnalytics> bookingForecast(@PathVariable String from, @PathVariable String to, @PathVariable String type, @PathVariable String country) {
		return new ArrayList();
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
	public List<BookingAnalytics> bookingForecast(@PathVariable String from, @PathVariable String to, @PathVariable String type, @PathVariable String country, @PathVariable String location) {
		return new ArrayList();
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
	public List<BookingAnalytics> bookingForecast(@PathVariable String from, @PathVariable String to, @PathVariable String type, @PathVariable String country, @PathVariable String location, @PathVariable String department) {
		return new ArrayList();
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
	public List<BookingAnalytics> bookingForecastForAirport(@PathVariable String from, @PathVariable String to, @PathVariable String type, @PathVariable String airportCode) {
		return new ArrayList();
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
	public List<BookingAnalytics> bookingForecastForAirLine(@PathVariable String from, @PathVariable String to, @PathVariable String type, @PathVariable String airlineCode) {
		return new ArrayList();
	}
	
	

	/**
	 * Return all the users from the institutions.
	 * 
	 * @return the list of user from the institutions
	 */
	@RequestMapping("/actual")
	@ResponseBody
	public List<BookingAnalytics> bookingActuals(@RequestParam(name = "from", required = true) Date from,
			@RequestParam(name = "to", required = true) Date to) {
		return new ArrayList();
	}
}
