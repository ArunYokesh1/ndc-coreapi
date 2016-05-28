package edu.hackathon.repository.model;

import java.util.List;

public class OrderItem {
	
	private String orderId;
	
	private List<String> associatedPassengers;
	
	private String orderedTime;
	
	private String itemType;
	
	private List<String> associatedSegments;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	

	public String getOrderedTime() {
		return orderedTime;
	}

	public void setOrderedTime(String orderedTime) {
		this.orderedTime = orderedTime;
	}

	public List<String> getAssociatedPassengers() {
		return associatedPassengers;
	}

	public void setAssociatedPassengers(List<String> associatedPassengers) {
		this.associatedPassengers = associatedPassengers;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public List<String> getAssociatedSegments() {
		return associatedSegments;
	}

	public void setAssociatedSegments(List<String> associatedSegments) {
		this.associatedSegments = associatedSegments;
	}

	
}
