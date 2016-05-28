package edu.hackathon.domain;

public class PassengerSegment {
	
	private String flightSegmentRef;
	
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
	

}
