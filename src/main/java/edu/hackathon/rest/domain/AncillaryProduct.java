package edu.hackathon.rest.domain;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AncillaryProduct extends AbstractAnalyticsItem {

	@JsonProperty
	private String name;

	@JsonProperty
	private List<Analytics> analytics;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addAnalytics(Analytics analytics) {
		if (this.analytics == null) {
			this.analytics = new ArrayList<>();
		}
		this.analytics.add(analytics);
	}

}
