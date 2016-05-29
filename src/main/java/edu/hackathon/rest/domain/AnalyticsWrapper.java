package edu.hackathon.rest.domain;

import java.util.List;

public class AnalyticsWrapper {
	
	private List<BookingAnalytics> bookingAnalyticsList;

	private List<CountryAnalytics> countryAnalyticsList;

	/**
	 * @return the bookingAnalyticsList
	 */
	public List<BookingAnalytics> getBookingAnalyticsList() {
		return bookingAnalyticsList;
	}

	/**
	 * @param bookingAnalyticsList the bookingAnalyticsList to set
	 */
	public void setBookingAnalyticsList(List<BookingAnalytics> bookingAnalyticsList) {
		this.bookingAnalyticsList = bookingAnalyticsList;
	}

	/**
	 * @return the countryAnalyticsList
	 */
	public List<CountryAnalytics> getCountryAnalyticsList() {
		return countryAnalyticsList;
	}

	/**
	 * @param countryAnalyticsList the countryAnalyticsList to set
	 */
	public void setCountryAnalyticsList(List<CountryAnalytics> countryAnalyticsList) {
		this.countryAnalyticsList = countryAnalyticsList;
	}
	

}
