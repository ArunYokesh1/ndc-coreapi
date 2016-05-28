
package edu.hackathon.rest.domain;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import edu.hackathon.repository.CustomDateSerializer;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DataRange {

	@JsonProperty("from")
    @JsonSerialize(using = CustomDateSerializer.class)
    private DateTime from;
	/**
	 * 
	 * (Required)
	 * 
	 */
	@JsonProperty("to")
    @JsonSerialize(using = CustomDateSerializer.class)
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
