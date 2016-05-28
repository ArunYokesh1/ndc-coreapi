package edu.hackathon.rest.domain;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Airport extends AbstractAnalyticsItem {

	@JsonProperty
	private String name;

	@JsonProperty
	private String code;

	@JsonProperty
	private List<Airline> airlines;

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

	public List<Airline> getAirlines() {
		return airlines;
	}

	public void setAirlines(List<Airline> airlines) {
		this.airlines = airlines;
	}

	public void addAirline(Airline airline) {
		if (this.airlines == null) {
			this.airlines = new ArrayList<>();
		}
		this.airlines.add(airline);

	}

}
