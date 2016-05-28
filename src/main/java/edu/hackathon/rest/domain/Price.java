
package edu.hackathon.rest.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;

import edu.hackathon.rest.view.AnalyticsDataView;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Price {

	/**
	 * 
	 * (Required)
	 * 
	 */
	@JsonProperty("amount")
	@JsonView(AnalyticsDataView.BaseDataView.class)
	private Double amount;
	/**
	 * 
	 * (Required)
	 * 
	 */
	@JsonProperty("currency")
	@JsonView(AnalyticsDataView.BaseDataView.class)
	private String currency;

	/**
	 * 
	 * (Required)
	 * 
	 * @return The amount
	 */
	@JsonProperty("amount")
	public Double getAmount() {
		return amount;
	}

	/**
	 * 
	 * (Required)
	 * 
	 * @param amount
	 *            The amount
	 */
	@JsonProperty("amount")
	public void setAmount(Double amount) {
		this.amount = amount;
	}

	/**
	 * 
	 * (Required)
	 * 
	 * @return The currency
	 */
	@JsonProperty("currency")
	public String getCurrency() {
		return currency;
	}

	/**
	 * 
	 * (Required)
	 * 
	 * @param currency
	 *            The currency
	 */
	@JsonProperty("currency")
	public void setCurrency(String currency) {
		this.currency = currency;
	}

}
