package edu.hackathon.repository.model;

import java.util.List;

import org.joda.time.Duration;

public class Itinerary {
	
	private List<Segment> segments;
	
	private Duration duration;

	public List<Segment> getSegments() {
		return segments;
	}

	public void setSegments(List<Segment> segments) {
		this.segments = segments;
	}

	public Duration getDuration() {
		return duration;
	}

	public void setDuration(Duration duration) {
		this.duration = duration;
	}
	
	
}
