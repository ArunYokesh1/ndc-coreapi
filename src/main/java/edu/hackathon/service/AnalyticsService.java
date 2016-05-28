/**
 * 
 */
package edu.hackathon.service;

import java.util.Date;

import edu.hackathon.rest.domain.BookingCostAnalytics;

/**
 * @author x096284
 *
 */
public interface AnalyticsService {

	BookingCostAnalytics forecastBookingCost(Date from, Date to);

}
