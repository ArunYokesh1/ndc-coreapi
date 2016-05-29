package edu.hackathon.business;

import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Component;

import edu.hackathon.repository.model.Booking;

@Component
public class RandomizeForecastBusiness {

	public List<Booking> randomizeBooking(List<Booking> actualBookings) {
		Random random = new Random();
		//randomNumber = random.doubles(10);
		
		return actualBookings;
	}
}
