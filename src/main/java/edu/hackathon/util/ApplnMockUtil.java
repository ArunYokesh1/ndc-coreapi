package edu.hackathon.util;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import edu.hackathon.domain.value.AvailableAncilaries;
import edu.hackathon.domain.value.Itinerary;
import edu.hackathon.domain.value.Meeting;
import edu.hackathon.domain.value.Offers;
import edu.hackathon.domain.value.RecommendedItinerary;
import edu.hackathon.domain.value.Segment;

public class ApplnMockUtil {

	public Offers getOffersDto() {
		Meeting meeting = new Meeting();
		meeting.setSubject("Hello");
		meeting.setDate("29-05-2016");
		meeting.setTime("11:30");

		List<AvailableAncilaries> availableAncilaries = new ArrayList<AvailableAncilaries>();

		AvailableAncilaries ancilaries = new AvailableAncilaries();
		ancilaries.setAncillaryName("Standard Meal");
		ancilaries.setAncillaryType("Meal");

		availableAncilaries.add(ancilaries);

		Segment segment = new Segment();
		segment.setFlightNumber("FL1");
		segment.setDepTime("07:45");
		segment.setArrivalTime("09:30");
		segment.setAvailableAncilaries(availableAncilaries);

		List<Segment> segments = new ArrayList<Segment>();
		segments.add(segment);

		RecommendedItinerary recommendedItinerary = new RecommendedItinerary();
		recommendedItinerary.setReasonForRecomendation("Last time you choosen this Flight");
		recommendedItinerary.setSegments(segments);

		Offers offers1 = new Offers();
		offers1.setOrgin("AMS");
		offers1.setDestination("CDG");
		offers1.setMeeting(meeting);
		offers1.setRecommendedItinerary(recommendedItinerary);

		List<Itinerary> otherItineraries = new ArrayList<Itinerary>();

		Itinerary itinerary = new Itinerary();
		itinerary.setSegments(segments);

		otherItineraries.add(itinerary);
		offers1.setOtherItineraries(otherItineraries);

		return offers1;
	}

}
