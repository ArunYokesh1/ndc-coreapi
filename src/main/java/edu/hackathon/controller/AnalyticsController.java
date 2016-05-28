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

	@RequestMapping("/healthcheck")
	@ResponseBody
	public String healthcheck() {
		return "SUCESS";
	}

	/**
	 * Return all the users from the institutions.
	 * 
	 * @return the list of user from the institutions
	 */
	@RequestMapping("/forecast/{from}/{to}")
	@ResponseBody
	public List<BookingAnalytics> bookingForecast(@PathVariable String from, @PathVariable String to) {
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
