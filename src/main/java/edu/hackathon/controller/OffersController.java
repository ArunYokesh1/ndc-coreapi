/*
 * Copyright (c) KLM Royal Dutch Airlines. All Rights Reserved.
 * ============================================================
 */
package edu.hackathon.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.hackathon.domain.value.Offers;
import edu.hackathon.domain.value.builder.OffersBuilder;

/**
 *
 * @author Malai
 *
 * @since May 28, 2016
 * @version 1.0
 */

@RestController
@RequestMapping("/offers")
public class OffersController {

    @RequestMapping(value = "/itineraries", method = RequestMethod.GET)
    public HttpEntity<Offers> itineraries() {
        OffersBuilder offersBuilder = new OffersBuilder().setMeetingInfo("Hello", "28-5-2016", "11:00").setRoute("AMS", "CDG");
        return new ResponseEntity<>(offersBuilder.build(), HttpStatus.OK);
    }
}
