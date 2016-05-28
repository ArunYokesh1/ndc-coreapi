/*
 * Copyright (c) KLM Royal Dutch Airlines. All Rights Reserved.
 * ============================================================
 */
package edu.hackathon.domain.value.builder;

import edu.hackathon.domain.value.Meeting;
import edu.hackathon.domain.value.Offers;

/**
 *
 *
 * @author TCS (x076459)
 * @since May 28, 2016
 * @version 1.0
 */
public class OffersBuilder {

    private final Offers offers;

    /**
     * Instantiates a new offers builder.
     */
    public OffersBuilder() {
        offers = new Offers();
    }

    public OffersBuilder setMeetingInfo(String sub, String date, String time) {
        Meeting meeting = new Meeting();
        meeting.setSubject(sub);
        meeting.setDate(date);
        meeting.setTime(time);
        offers.setMeeting(meeting);
        return this;
    }

    public OffersBuilder setRoute(String orgin, String destination) {
        offers.setOrgin(orgin);
        offers.setDestination(destination);
        return this;
    }

    public OffersBuilder setRecommenderItinerary() {
        return this;
    }

    public Offers build() {
        return offers;
    }

}
