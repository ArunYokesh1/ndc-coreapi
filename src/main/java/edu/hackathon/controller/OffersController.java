/*
 * Copyright (c) KLM Royal Dutch Airlines. All Rights Reserved.
 * ============================================================
 */
package edu.hackathon.controller;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import org.apache.http.client.ClientProtocolException;
import org.iata.ndc.ClientException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.hackathon.NdcClientConfiguration;
import edu.hackathon.domain.value.Offers;
import edu.hackathon.util.MockUtil;

/**
 * 
 * @author Malai, Jayaprabahar
 * 
 * @since May 28, 2016
 * @version 1.0
 */

@RestController
@RequestMapping("/offers")
public class OffersController extends NdcClientConfiguration {

	@RequestMapping(value = "/itineraries", method = RequestMethod.GET)
	public HttpEntity<Offers> itineraries() throws JAXBException, ClientProtocolException, ClientException, IOException {
		Offers offers = new Offers();

		// TODO - Get Origin & Destination from UI
/*		AirShoppingRQ request = (AirShoppingRQ) XmlJsonPojoConvertor.getPojoFromXml("MockAirShoppingRQ.xml",
				new AirShoppingRQ());
		offers = (Offers) XmlJsonPojoConvertor.getPojoFromJson("MockOffersResponse.json", new Offers());
		offers = new AirShoppingResonseMapper().mapAirShoppingResponse(getNdcClient().airShopping(request));*/
		
		offers = new MockUtil().getOffersDto();

		return new ResponseEntity<>(offers, HttpStatus.OK);
	}
}
