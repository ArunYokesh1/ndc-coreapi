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
	private Airport arrival;
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
