package edu.hackathon.rest.domain;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Country extends AbstractAnalyticsItem {

	@JsonProperty
	private String name;

	@JsonProperty
	private String code;

	@JsonProperty
	private List<Airport> airports;

	@JsonProperty
	private List<Location> locations;

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

	public List<Airport> getAirports() {
		return airports;
	}

	public void setAirports(List<Airport> airports) {
		this.airports = airports;
	}

	public List<Location> getLocations() {
		return locations;
	}

	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}

	public void addLocation(Location loc) {
		if (this.locations == null) {
			this.locations = new ArrayList<>();
		}
		this.locations.add(loc);

	}

}
