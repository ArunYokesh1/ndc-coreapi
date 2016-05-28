package edu.hackathon.rest.domain;

import java.math.BigInteger;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AbstractAnalyticsItem {

	@JsonProperty
	private BigInteger bookingCount;

	@JsonProperty
	private Price bookingCost;

	@JsonProperty
	private BigInteger ancillaryCount;

	@JsonProperty
	private Price ancillaryCost;

	public BigInteger getBookingCount() {
		return bookingCount;
	}

	public void setBookingCount(BigInteger bookingCount) {
		this.bookingCount = bookingCount;
	}

	public Price getTotalBookingCost() {
		return bookingCost;
	}

	public void setTotalBookingCost(Price totalBookingCost) {
		this.bookingCost = totalBookingCost;
	}

	public BigInteger getAncillaryCount() {
		return ancillaryCount;
	}

	public void setAncillaryCount(BigInteger ancillaryCount) {
		this.ancillaryCount = ancillaryCount;
	}

	public Price getTotalAncillaryCost() {
		return ancillaryCost;
	}

	public void setTotalAncillaryCost(Price totalAncillaryCost) {
		this.ancillaryCost = totalAncillaryCost;
	}

}
