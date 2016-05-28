/*
 * Copyright (c) KLM Royal Dutch Airlines. All Rights Reserved.
 * ============================================================
 */
package edu.hackathon.repository;

import java.io.IOException;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 *
 *
 * @since May 28, 2016
 * @version 1.0
 */
public class CustomDateSerializer extends JsonSerializer<DateTime> {

    private static org.joda.time.format.DateTimeFormatter formatter = DateTimeFormat.forPattern("dd-MM-yyyy");

    /**
     * {@inheritDoc}
     */
    @Override
    public void serialize(DateTime value, JsonGenerator gen, SerializerProvider arg2) throws IOException, JsonProcessingException {
        gen.writeString(formatter.print(value));
    }

}
