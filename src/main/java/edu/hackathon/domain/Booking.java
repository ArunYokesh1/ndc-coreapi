package edu.hackathon.domain;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Booking {
	
	@org.springframework.data.annotation.Id
	private String Id;
	
	private String bookingCode;
	
	
	

}
