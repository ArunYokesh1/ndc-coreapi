package edu.hackathon.rest.domain;

import java.math.BigInteger;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Ancillary {

	@JsonProperty private String name;
	@JsonProperty private String type;
	@JsonProperty private BigInteger totalCount;
	@JsonProperty private Price totalCost;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public BigInteger getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(BigInteger totalCount) {
		this.totalCount = totalCount;
	}

	public Price getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Price totalCost) {
		this.totalCost = totalCost;
	}

}
