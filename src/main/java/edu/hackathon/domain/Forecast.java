/**
 * 
 */
package edu.hackathon.domain;

/**
 * @author Prabu S B
 *
 */
public class Forecast {
	
	private String expectedValue;
	
	private String expectedAmount;

	/**
	 * @return the expectedValue
	 */
	public String getExpectedValue() {
		return expectedValue;
	}

	/**
	 * @param expectedValue the expectedValue to set
	 */
	public void setExpectedValue(String expectedValue) {
		this.expectedValue = expectedValue;
	}

	/**
	 * @return the expectedAmount
	 */
	public String getExpectedAmount() {
		return expectedAmount;
	}

	/**
	 * @param expectedAmount the expectedAmount to set
	 */
	public void setExpectedAmount(String expectedAmount) {
		this.expectedAmount = expectedAmount;
	}

}
