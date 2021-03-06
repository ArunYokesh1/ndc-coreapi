package edu.hackathon.repository.model;

import java.util.List;

public class Order {
	
	private String orderId;
	private String orderOwner;
	private Price orderPrice;
	private Price flightPrice;
	private List<OrderItem> orderItems;
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getOrderOwner() {
		return orderOwner;
	}
	public void setOrderOwner(String orderOwner) {
		this.orderOwner = orderOwner;
	}
	public Price getOrderPrice() {
		return orderPrice;
	}
	public void setOrderPrice(Price orderPrice) {
		this.orderPrice = orderPrice;
	}
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	/**
	 * @return the flightPrice
	 */
	public Price getFlightPrice() {
		return flightPrice;
	}
	/**
	 * @param flightPrice the flightPrice to set
	 */
	public void setFlightPrice(Price flightPrice) {
		this.flightPrice = flightPrice;
	}

}
