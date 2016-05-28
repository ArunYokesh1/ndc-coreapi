
package edu.hackathon.rest.domain;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonView;

import edu.hackathon.rest.view.AnalyticsDataView;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "name", "code", "bookingCount", "totalCost", "cabinClass" })
public class Airline {

	@JsonProperty("name")
	@JsonView(AnalyticsDataView.BaseDataView.class)
	private String name;
	
	@JsonProperty("code")
	@JsonView(AnalyticsDataView.BaseDataView.class)
	private String code;
	
	@JsonProperty("bookingCount")
	@JsonView(AnalyticsDataView.BaseDataView.class)
	private Integer bookingCount;
	
	@JsonProperty("totalCost")
	@JsonView(AnalyticsDataView.BaseDataView.class)
	private TotalCost totalCost;
	
	@JsonProperty("cabinClass")
	@JsonView(AnalyticsDataView.BaseDataView.class)
	private List<CabinClass> cabinClass = new ArrayList<CabinClass>();

	@JsonProperty("itinerary")
	@JsonView(AnalyticsDataView.BaseDataView.class)
	private Itinerary itinerary;

	
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("code")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@JsonProperty("bookingCount")
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

	public List<CabinClass> getCabinClass() {
		return cabinClass;
	}

	public void setCabinClass(List<CabinClass> cabinClass) {
		this.cabinClass = cabinClass;
	}

	public Itinerary getItinerary() {
		return itinerary;
	}

	public void setItinerary(Itinerary itinerary) {
		this.itinerary = itinerary;
	}

}
