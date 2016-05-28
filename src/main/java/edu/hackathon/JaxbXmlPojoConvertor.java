/*
 * Copyright (c) KLM Royal Dutch Airlines. All Rights Reserved.
 * ============================================================
 */
package edu.hackathon;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.iata.ndc.schema.AirShoppingRQ;

/**
 * @author Jayaprabahar
 * @since May 28, 2016
 * @version 1.0
 */
public class JaxbXmlPojoConvertor {

    public static Object getPojoFromXml(String requestXml, Object requestObject) throws JAXBException {
        Object returnObject = null;
        File file = new File(requestObject.getClass().getClassLoader().getResource(requestXml).getFile());
        JAXBContext jaxbContext = JAXBContext.newInstance(requestObject.getClass());
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        if (requestObject instanceof AirShoppingRQ)
            returnObject = jaxbUnmarshaller.unmarshal(file);

        return returnObject;
    }

}
