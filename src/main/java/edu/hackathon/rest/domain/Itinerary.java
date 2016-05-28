
package edu.hackathon.rest.domain;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonView;

import edu.hackathon.rest.view.AnalyticsDataView;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "destination", "origin", "bookingCount", "totalCost", "airlines", "cabinClass" })
public class Itinerary {

	/**
	 * 
	 * (Required)
	 * 
	 */
	@JsonProperty("destination")
	@JsonView(AnalyticsDataView.BaseDataView.class)
	private String destination;
	/**
	 * 
	 * (Required)
	 * 
	 */
	@JsonProperty("origin")
	@JsonView(AnalyticsDataView.BaseDataView.class)
	private String origin;
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
	private TotalCost totalCost;
	/**
	 * 
	 * (Required)
	 * 
	 */
	@JsonProperty("airlines")
	@JsonView(AnalyticsDataView.BaseDataView.class)
	private List<Airline> airlines = new ArrayList<Airline>();
	/**
	 * 
	 * (Required)
	 * 
	 */
	@JsonProperty("cabinClass")
	@JsonView(AnalyticsDataView.BaseDataView.class)
	private List<CabinClass> cabinClass = new ArrayList<CabinClass>();

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public Integer getBookingCount() {
		return bookingCount;
	}

	public void setBookingCount(Integer bookingCount) {
		this.bookingCount = bookingCount;
	}

	public TotalCost getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(TotalCost totalCost) {
		this.totalCost = totalCost;
	}

	public List<Airline> getAirlines() {
		return airlines;
	}

	public void setAirlines(List<Airline> airlines) {
		this.airlines = airlines;
	}

	public List<CabinClass> getCabinClass() {
		return cabinClass;
	}

	public void setCabinClass(List<CabinClass> cabinClass) {
		this.cabinClass = cabinClass;
	}

}
