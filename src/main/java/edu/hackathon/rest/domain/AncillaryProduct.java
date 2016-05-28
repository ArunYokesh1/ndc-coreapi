package edu.hackathon.rest.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AncillaryProduct extends AbstractAnalyticsItem {

	@JsonProperty
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
