/**
 * 
 */
package edu.hackathon.rest.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
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

	@InitBinder
	void initBinder(final WebDataBinder webDataBinder) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, false));
	}

	/**
	 * Return all the users from the institutions.
	 * 
	 * @return the list of user from the institutions
	 */
	@RequestMapping
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
	@RequestMapping
	@ResponseBody
	public List<BookingCostAnalytics> bookingActuals(@RequestParam(name = "from", required = true) Date from,
			@RequestParam(name = "to", required = true) Date to) {
		return new ArrayList();
	}
}
