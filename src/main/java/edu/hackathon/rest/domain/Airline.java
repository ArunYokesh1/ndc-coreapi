
package edu.hackathon.rest.domain;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;

import edu.hackathon.rest.view.AnalyticsDataView;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Airline extends AbstractAnalyticsItem {

	@JsonProperty("name")
	@JsonView(AnalyticsDataView.BaseDataView.class)
	private String name;

	@JsonProperty("code")
	@JsonView(AnalyticsDataView.BaseDataView.class)
	private String code;

	private List<CabinClass> cabinClass = new ArrayList<CabinClass>();

	@JsonProperty("itinerary")
	@JsonView(AnalyticsDataView.BaseDataView.class)
	private Itinerary itinerary;

	@JsonProperty
	private List<AncillaryProduct> ancillaryProducts;

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

	public List<AncillaryProduct> getAncillaryProducts() {
		return ancillaryProducts;
	}

	public void setAncillaryProducts(List<AncillaryProduct> ancillaryProducts) {
		this.ancillaryProducts = ancillaryProducts;
	}

	public void addAncillaryProducts(AncillaryProduct ancillaryProduct) {
		if (this.ancillaryProducts == null) {
			this.ancillaryProducts = new ArrayList<>();
		}
		this.ancillaryProducts.add(ancillaryProduct);
	}

}
