
package edu.hackathon.rest.domain;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonView;

import edu.hackathon.rest.view.AnalyticsDataView;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "dataType", "dataRange", "bookingCount", "totalCost", "itinerary", "cabinClass" })
public class BookingCostAnalytics {

	//Type of data represents, either actual or prediction
	@JsonProperty("dataType")
	@JsonView(AnalyticsDataView.BaseDataView.class)
	private String dataType;

	@JsonProperty("dataRange")
	@JsonView(AnalyticsDataView.BaseDataView.class)
	private DataRange dataRange;
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
	@JsonProperty("itinerary")
	@JsonView(AnalyticsDataView.BaseDataView.class)
	private List<Itinerary> itinerary = new ArrayList<Itinerary>();
	/**
	 * 
	 * (Required)
	 * 
	 */
	@JsonProperty("cabinClass")
	@JsonView(AnalyticsDataView.BaseDataView.class)
	private List<CabinClass> cabinClass = new ArrayList<CabinClass>();

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public DataRange getDataRange() {
		return dataRange;
	}

	public void setDataRange(DataRange dataRange) {
		this.dataRange = dataRange;
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

	public List<Itinerary> getItinerary() {
		return itinerary;
	}

	public void setItinerary(List<Itinerary> itinerary) {
		this.itinerary = itinerary;
	}

	public List<CabinClass> getCabinClass() {
		return cabinClass;
	}

	public void setCabinClass(List<CabinClass> cabinClass) {
		this.cabinClass = cabinClass;
	}

}
