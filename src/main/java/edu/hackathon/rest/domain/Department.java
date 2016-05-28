package edu.hackathon.rest.domain;

import java.util.List;

public class Department extends AbstractAnalyticsItem {

	private String name;

	private String code;

	private List<Ancillary> ancillaries;

	private List<Airline> airlines;

	private List<Airport> airports;

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

	public List<Ancillary> getAncillaries() {
		return ancillaries;
	}

	public void setAncillaries(List<Ancillary> ancillaries) {
		this.ancillaries = ancillaries;
	}

	public List<Airline> getAirlines() {
		return airlines;
	}

	public void setAirlines(List<Airline> airlines) {
		this.airlines = airlines;
	}

	public List<Airport> getAirports() {
		return airports;
	}

	public void setAirports(List<Airport> airports) {
		this.airports = airports;
	}

}
