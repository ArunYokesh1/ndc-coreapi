/**
 * 
 */
package edu.hackathon.repository.model;

/**
 * @author ArunYokesh1
 *
 */
public class Segment {

	private String id;
	private Airport departure;
	private String departureTime;
	private Airport arrival;
	private String arrivalTime;
	private Carrier marketingCarrier;
	private Carrier operatingCarrier;
	private String duration;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Airport getDeparture() {
		return departure;
	}

	public void setDeparture(Airport departure) {
		this.departure = departure;
	}

	public Airport getArrival() {
		return arrival;
	}

	public void setArrival(Airport arrival) {
		this.arrival = arrival;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public Carrier getMarketingCarrier() {
		return marketingCarrier;
	}

	public void setMarketingCarrier(Carrier marketingCarrier) {
		this.marketingCarrier = marketingCarrier;
	}

	public Carrier getOperatingCarrier() {
		return operatingCarrier;
	}

	public void setOperatingCarrier(Carrier operatingCarrier) {
		this.operatingCarrier = operatingCarrier;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

}
