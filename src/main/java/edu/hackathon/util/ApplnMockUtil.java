package edu.hackathon.util;

import java.util.ArrayList;
import java.util.List;

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
		ancilaries.setAncillaryName("Inflight Wi-Fi");

		AvailableAncilaries ancilaries1 = new AvailableAncilaries();
		ancilaries1.setAncillaryName("Lounge pass");

		AvailableAncilaries ancilaries2 = new AvailableAncilaries();
		ancilaries2.setAncillaryName("Advanced seat selection");

		AvailableAncilaries ancilaries3 = new AvailableAncilaries();
		ancilaries3.setAncillaryName("Premium Seating");

		AvailableAncilaries ancilaries4 = new AvailableAncilaries();
		ancilaries4.setAncillaryName("Vegetarian Meal");

		availableAncilaries.add(ancilaries);
		availableAncilaries.add(ancilaries1);
		availableAncilaries.add(ancilaries2);
		availableAncilaries.add(ancilaries3);
		availableAncilaries.add(ancilaries4);

		Segment segment = new Segment();
		segment.setFlightNumber("FL1");
		segment.setDepTime("09:25");
		segment.setArrivalTime("22:50");
		segment.setAvailableAncilaries(availableAncilaries);
		
		Segment segment1 = new Segment();
		segment1.setFlightNumber("FL2");
		segment1.setDepTime("13:55");
		segment1.setArrivalTime("03:20");
		segment1.setAvailableAncilaries(availableAncilaries);
		
		Segment segment2 = new Segment();
		segment2.setFlightNumber("FL3");
		segment2.setDepTime("20:40");
		segment2.setArrivalTime("11:45");
		segment2.setAvailableAncilaries(availableAncilaries);
		
		Segment segment3 = new Segment();
		segment3.setFlightNumber("FL4");
		segment3.setDepTime("06:15");
		segment3.setArrivalTime("18:00");
		segment3.setAvailableAncilaries(availableAncilaries);

		List<Segment> segments = new ArrayList<Segment>();
		segments.add(segment);

		RecommendedItinerary recommendedItinerary = new RecommendedItinerary();
		recommendedItinerary.setReasonForRecomendation("Last time you have preferred this Flight");
		recommendedItinerary.setSegments(segments);

		List<Segment> segments1 = new ArrayList<Segment>();
		segments1.add(segment1);
		segments1.add(segment2);
		segments1.add(segment3);

		Itinerary itinerary = new Itinerary();
		itinerary.setSegments(segments1);

		List<Itinerary> otherItineraries = new ArrayList<Itinerary>();
		otherItineraries.add(itinerary);

		Offers offers1 = new Offers();
		offers1.setOrgin("AMS");
		offers1.setDestination("CDG");
		offers1.setMeeting(meeting);
		offers1.setRecommendedItinerary(recommendedItinerary);

		offers1.setOtherItineraries(otherItineraries);

		return offers1;
	}

}
