/**
 * 
 */
package edu.hackathon.rest.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.hackathon.rest.domain.BookingCostAnalytics;
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

	/**
	 * Return all the users from the institutions.
	 * 
	 * @return the list of user from the institutions
	 */
	@RequestMapping("/forecast")
	@ResponseBody
	public List<BookingCostAnalytics> bookingForecast(@RequestParam(name = "from", required = true) Date from,
			@RequestParam(name = "to", required = true) Date to) {
		return new ArrayList();
	}

	/**
	 * Return all the users from the institutions.
	 * 
	 * @return the list of user from the institutions
	 */
	@RequestMapping("/actual")
	@ResponseBody
	public List<BookingCostAnalytics> bookingActuals(@RequestParam(name = "from", required = true) Date from,
			@RequestParam(name = "to", required = true) Date to) {
		return new ArrayList();
	}
}
