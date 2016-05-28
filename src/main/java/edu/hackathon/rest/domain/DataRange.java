
package edu.hackathon.rest.domain;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DataRange {

	@JsonProperty("from")
    private DateTime from;
	/**
	 * 
	 * (Required)
	 * 
	 */
	@JsonProperty("to")
    private DateTime to;

    public DateTime getFrom() {
		return from;
	}

    public void setFrom(DateTime from) {
		this.from = from;
	}

    public DateTime getTo() {
		return to;
	}

    public void setTo(DateTime to) {
		this.to = to;
	}

}
