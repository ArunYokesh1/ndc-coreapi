package edu.hackathon.rest.domain;

import java.math.BigInteger;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CountryAnalytics extends AbstractAnalyticsItem {
	
	@JsonProperty
	private String name;

	@JsonProperty
	private String code;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	public CountryAnalytics(BigInteger ancillaryCount, BigInteger bookingCount, Price ancillaryPrice, Price bookingPrice, String code, String name) {
		this.setAncillaryCount(ancillaryCount);
		this.setBookingCount(bookingCount);
		this.setBookingPrice(bookingPrice);
		this.setAncillaryPrice(ancillaryPrice);
		this.code = code;
		this.name = name;
	}

	public void updateNewDetails(Country country) {
		this.addBookingCount(country.getBookingCount());
		this.addAncillaryCount(country.getAncillaryCount());
		this.updateAncillaryPrice(country.getAncillaryPrice());
		this.updateBookingPrice(country.getBookingPrice());
	}

}
