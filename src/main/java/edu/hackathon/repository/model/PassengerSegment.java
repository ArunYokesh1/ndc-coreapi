package edu.hackathon.repository.model;

import java.util.List;

public class PassengerSegment {

	private String flightSegmentRef;

	private List<Product> products;

	private String seatNumber;
	private String seatType;

	public String getFlightSegmentRef() {
		return flightSegmentRef;
	}

	public void setFlightSegmentRef(String flightSegmentRef) {
		this.flightSegmentRef = flightSegmentRef;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}

	public String getSeatType() {
		return seatType;
	}

	public void setSeatType(String seatType) {
		this.seatType = seatType;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
