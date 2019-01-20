package com.caen.util;

import java.io.IOException;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class UnixTimestampDeserializer extends JsonDeserializer<Date>{

	@Override
	public Date deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		String timestamp = p.getText().trim();

		        try {
		            return new Date(Long.valueOf(timestamp + "000"));
		        } catch (NumberFormatException e) {
		            System.out.println("Unable to deserialize timestamp: " + timestamp+e.getMessage());
		            return null;
		        }
	}

}
