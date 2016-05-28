
package edu.hackathon.rest.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "dataType", "dataRange", "bookingCount", "totalCost", "countries" })
public class BookingAnalytics extends AbstractAnalyticsItem {

	// Type of data represents, either actual or prediction
	@JsonProperty("dataType")
	private String dataType;

	@JsonProperty("dataRange")
	private DataRange dataRange;

	@JsonProperty
	private List<Country> countries;

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

	public List<Country> getCountries() {
		return countries;
	}

	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}

}
