package edu.hackathon.repository.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Booking {

	@org.springframework.data.annotation.Id
	private String Id;

	private BookingReference bookingReference;

	private String orderedTime;

	private List<Passenger> passengers;

	private Itinerary itinerary;

	private List<Order> orders;

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public BookingReference getBookingReference() {
		return bookingReference;
	}

	public void setBookingReference(BookingReference bookingReference) {
		this.bookingReference = bookingReference;
	}

	public String getOrderedTime() {
		return orderedTime;
	}

	public void setOrderedTime(String orderedTime) {
		this.orderedTime = orderedTime;
	}

	public List<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}

	public Itinerary getItinerary() {
		return itinerary;
	}

	public void setItinerary(Itinerary itinerary) {
		this.itinerary = itinerary;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

}
