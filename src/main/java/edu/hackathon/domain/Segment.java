/**
 * 
 */
package edu.hackathon.domain;

import org.joda.time.Duration;

/**
 * @author ArunYokesh1
 *
 */
public class Segment {

	private String id;
	private Station departure;
	private Station arrival;
	private Carrier marketingCarrier;
	private Carrier operatingCarrier;
	private Duration duration;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Station getDeparture() {
		return departure;
	}

	public void setDeparture(Station departure) {
		this.departure = departure;
	}

	public Station getArrival() {
		return arrival;
	}

	public void setArrival(Station arrival) {
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

	public Duration getDuration() {
		return duration;
	}

	public void setDuration(Duration duration) {
		this.duration = duration;
	}

}
