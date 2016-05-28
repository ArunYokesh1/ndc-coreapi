package edu.hackathon.rest.domain;

import java.math.BigInteger;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AbstractAnalyticsItem {

	@JsonProperty
	private BigInteger bookingCount;

	@JsonProperty
	private Price bookingPrice;

	@JsonProperty
	private BigInteger ancillaryCount;

	@JsonProperty
	private Price ancillaryPrice;

	public BigInteger getBookingCount() {
		return bookingCount;
	}

	public void setBookingCount(BigInteger bookingCount) {
		this.bookingCount = bookingCount;
	}

	public Price getBookingPrice() {
		return bookingPrice;
	}

	public void setBookingPrice(Price totalBookingCost) {
		this.bookingPrice = totalBookingCost;
	}

	public BigInteger getAncillaryCount() {
		return ancillaryCount;
	}

	public void setAncillaryCount(BigInteger ancillaryCount) {
		this.ancillaryCount = ancillaryCount;
	}

	public Price getAncillaryPice() {
		return ancillaryPrice;
	}

	public void setAncillaryPrice(Price totalAncillaryCost) {
		this.ancillaryPrice = totalAncillaryCost;
	}

}
