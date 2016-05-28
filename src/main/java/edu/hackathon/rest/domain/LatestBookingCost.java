/**
 * 
 */
package edu.hackathon.rest.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonView;

import edu.hackathon.rest.view.AnalyticsDataView;

/**
 * @author ArunYokesh1
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "amount", "currency", "time" })
public class LatestBookingCost {

	@JsonProperty("amount")
	@JsonView(AnalyticsDataView.BaseDataView.class)
	private Double amount;

	@JsonProperty("currency")
	@JsonView(AnalyticsDataView.BaseDataView.class)
	private String currency;

	@JsonProperty("time")
	@JsonView(AnalyticsDataView.BaseDataView.class)
	private Date time;

	/**
	 * @return the amount
	 */
	public Double getAmount() {
		return amount;
	}

	/**
	 * @param amount
	 *            the amount to set
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}

	/**
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * @param currency
	 *            the currency to set
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	/**
	 * @return the time
	 */
	public Date getTime() {
		return time;
	}

	/**
	 * @param time
	 *            the time to set
	 */
	public void setTime(Date time) {
		this.time = time;
	}

}
