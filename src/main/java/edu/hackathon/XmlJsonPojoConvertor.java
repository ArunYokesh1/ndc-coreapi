/*
 * Copyright (c) KLM Royal Dutch Airlines. All Rights Reserved.
 * ============================================================
 */
package edu.hackathon;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.iata.ndc.schema.AirShoppingRQ;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.hackathon.domain.value.Offers;

/**
 * @author Jayaprabahar
 * @since May 28, 2016
 * @version 1.0
 */
public class XmlJsonPojoConvertor {

    public static Object getPojoFromXml(String inputXml, Object requestObject) throws JAXBException {
        Object returnObject = null;
        File file = new File(requestObject.getClass().getClassLoader().getResource(inputXml).getFile());
        JAXBContext jaxbContext = JAXBContext.newInstance(requestObject.getClass());
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        if (requestObject instanceof AirShoppingRQ)
            returnObject = jaxbUnmarshaller.unmarshal(file);

        return returnObject;
    }
    
    public static Object getPojoFromJson(String inputJSON, Object requestObject) throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        Object returnObject = null;

        if (requestObject instanceof Offers)
        	returnObject = mapper.readValue(requestObject.getClass().getClassLoader().getResource(inputJSON).getFile(), Offers.class);

        return returnObject;
    }

}
