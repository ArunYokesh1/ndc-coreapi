package edu.hackathon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.hackathon.repository.BookingRepository;
import edu.hackathon.repository.model.Booking;

@RestController
@RequestMapping("/booking")
public class BookingsController {

	@Autowired
	private BookingRepository bookingRepository;
	
	
	@RequestMapping
	@ResponseBody
	public List<Booking> getAll() {
		return bookingRepository.findAll();
	}
}
