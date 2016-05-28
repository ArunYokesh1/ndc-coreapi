package edu.hackathon.repository.model;

public class Product {

	private String productName;
	private String productType;
	private String associatedOrderId;
	private Price price;
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getAssociatedOrderId() {
		return associatedOrderId;
	}
	public void setAssociatedOrderId(String associatedOrderId) {
		this.associatedOrderId = associatedOrderId;
	}
	public Price getPrice() {
		return price;
	}
	public void setPrice(Price price) {
		this.price = price;
	}
	
}
