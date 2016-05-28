package edu.hackathon.rest.domain;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Department extends AbstractAnalyticsItem {

	@JsonProperty
	private String name;

	@JsonProperty
	private String code;

	@JsonProperty
	private List<Ancillary> ancillaries;

	@JsonProperty
	private List<Airline> airlines;

	@JsonProperty
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

	public void addAirline(Airline airline) {
		if (this.airlines != null) {
			this.airlines = new ArrayList<>();
		}
		airlines.add(airline);
	}

	public void addAirport(Airport airport) {
		if (this.airports != null) {
			this.airports = new ArrayList<>();
		}
		airports.add(airport);
	}

}
