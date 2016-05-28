
package edu.hackathon.rest.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonView;

import edu.hackathon.rest.view.AnalyticsDataView;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "from", "to" })
public class DataRange {

	@JsonProperty("from")
	@JsonView(AnalyticsDataView.BaseDataView.class)
	private String from;
	/**
	 * 
	 * (Required)
	 * 
	 */
	@JsonProperty("to")
	@JsonView(AnalyticsDataView.BaseDataView.class)
	private String to;

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

}
