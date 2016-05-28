package edu.hackathon.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.hackathon.domain.Booking;
import edu.hackathon.repository.BookingRepository;
import edu.hackathon.rest.domain.BookingCostAnalytics;
import edu.hackathon.service.AnalyticsService;

@Service
public class AnalyticsServiceImpl implements AnalyticsService {

	@Autowired
	private BookingRepository bookingRepository;

	@Override
	public BookingCostAnalytics forecastBookingCost(Date from, Date to) {
		//List<Booking> bookings = bookingRepository.findBookingOrderedTimeWithinTime(from, to);

		return null;
	}

}
