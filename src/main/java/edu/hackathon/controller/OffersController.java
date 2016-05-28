/*
 * Copyright (c) KLM Royal Dutch Airlines. All Rights Reserved.
 * ============================================================
 */
package edu.hackathon.controller;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import org.apache.http.client.ClientProtocolException;
import org.iata.ndc.ClientException;
import org.iata.ndc.schema.AirShoppingRQ;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.hackathon.JaxbXmlPojoConvertor;
import edu.hackathon.NdcClientConfiguration;
import edu.hackathon.domain.value.Meeting;
import edu.hackathon.domain.value.Offers;
import edu.hackathon.domain.value.builder.AirShoppingResonseMapper;

/**
 *
 * @author Malai
 *
 * @since May 28, 2016
 * @version 1.0
 */

@RestController
@RequestMapping("/offers")
public class OffersController extends NdcClientConfiguration {

    @RequestMapping(value = "/itineraries", method = RequestMethod.GET)
    public HttpEntity<Offers> itineraries() throws JAXBException, ClientProtocolException, ClientException, IOException {

        // TODO - Get Origin & Destination from UI
        AirShoppingRQ request = (AirShoppingRQ) JaxbXmlPojoConvertor.getPojoFromXml("MockAirShoppingRQ.xml", new AirShoppingRQ());
        Offers offers = new AirShoppingResonseMapper().mapAirShoppingResponse(getNdcClient().airShopping(request));
        // Offers offers = new AirShoppingResonseMapper().mapAirShoppingResponse((AirShoppingRS) JaxbXmlPojoConvertor.getPojoFromXml("MockAirShoppingRS.xml", new AirShoppingRS()));

        Meeting meeting = new Meeting();
        // meeting.setSubject(sub);
        // meeting.setDate(date);
        // meeting.setTime(time);
        offers.setMeeting(meeting);

        return new ResponseEntity<>(offers, HttpStatus.OK);
    }
}
