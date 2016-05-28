package edu.hackathon.repository.model;

import java.util.List;

public class Itinerary {
	
	private List<Segment> segments;
	
	private String duration;

	public List<Segment> getSegments() {
		return segments;
	}

	public void setSegments(List<Segment> segments) {
		this.segments = segments;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	
}
