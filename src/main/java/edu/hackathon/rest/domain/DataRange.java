
package edu.hackathon.rest.domain;

import java.util.Date;

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
	private Date from;
	/**
	 * 
	 * (Required)
	 * 
	 */
	@JsonProperty("to")
	@JsonView(AnalyticsDataView.BaseDataView.class)
	private Date to;

	public Date getFrom() {
		return from;
	}

	public void setFrom(Date from) {
		this.from = from;
	}

	public Date getTo() {
		return to;
	}

	public void setTo(Date to) {
		this.to = to;
	}

}
