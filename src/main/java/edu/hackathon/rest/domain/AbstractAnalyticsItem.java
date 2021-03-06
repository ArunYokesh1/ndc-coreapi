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

    public void addBookingCount(BigInteger bookingCount) {
        this.bookingCount.add(bookingCount);
    }

	public Price getBookingPrice() {
		return bookingPrice;
	}

	public void setBookingPrice(Price bookingPrice) {
		this.bookingPrice = bookingPrice;
	}

	public BigInteger getAncillaryCount() {
		return ancillaryCount;
	}

	public void setAncillaryCount(BigInteger ancillaryCount) {
		this.ancillaryCount = ancillaryCount;
	}

	public void addAncillaryCount(BigInteger ancillaryCount) {
		this.ancillaryCount.add(ancillaryCount);
	}
	
	public void updateBookingPrice(Price bookingPrice) {
		this.bookingPrice.setAmount(this.bookingPrice.getAmount() + bookingPrice.getAmount());
	}

	public void updateAncillaryPrice(Price ancillaryPrice) {
		this.ancillaryPrice.setAmount(this.ancillaryPrice.getAmount() + ancillaryPrice.getAmount());
	}
		
	public Price getAncillaryPrice() {
		return ancillaryPrice;
	}

	public void setAncillaryPrice(Price ancillaryPrice) {
		this.ancillaryPrice = ancillaryPrice;
	}

}
