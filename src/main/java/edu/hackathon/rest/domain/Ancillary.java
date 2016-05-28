package edu.hackathon.rest.domain;

import java.math.BigInteger;

public class Ancillary {

	private String name;
	private String type;
	private BigInteger totalCount;
	private Price totalCost;

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
