
package edu.hackathon.rest.domain;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonView;

import edu.hackathon.rest.view.AnalyticsDataView;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "name", "bookingCount", "totalCost", "airlines" })
public class CabinClass {

	/**
	 * 
	 * (Required)
	 * 
	 */
	@JsonProperty("name")
	@JsonView(AnalyticsDataView.BaseDataView.class)
	private String name;
	/**
	 * 
	 * (Required)
	 * 
	 */
	@JsonProperty("bookingCount")
	@JsonView(AnalyticsDataView.BaseDataView.class)
	private Integer bookingCount;
	/**
	 * 
	 * (Required)
	 * 
	 */
	@JsonProperty("totalCost")
	@JsonView(AnalyticsDataView.BaseDataView.class)
	private Price totalCost;

	/**
	 * 
	 * (Required)
	 * 
	 */
	@JsonProperty("airlines")
	@JsonView(AnalyticsDataView.BaseDataView.class)
	private List<Airline> airlines = new ArrayList<Airline>();

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the bookingCount
	 */
	public Integer getBookingCount() {
		return bookingCount;
	}

	/**
	 * @param bookingCount
	 *            the bookingCount to set
	 */
	public void setBookingCount(Integer bookingCount) {
		this.bookingCount = bookingCount;
	}

	/**
	 * @return the totalCost
	 */
	public Price getTotalCost() {
		return totalCost;
	}

	/**
	 * @param totalCost
	 *            the totalCost to set
	 */
	public void setTotalCost(Price totalCost) {
		this.totalCost = totalCost;
	}

	/**
	 * @return the airlines
	 */
	public List<Airline> getAirlines() {
		return airlines;
	}

	/**
	 * @param airlines
	 *            the airlines to set
	 */
	public void setAirlines(List<Airline> airlines) {
		this.airlines = airlines;
	}

}
