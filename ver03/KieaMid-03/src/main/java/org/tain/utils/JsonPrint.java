package org.tain.utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class JsonPrint implements JsonPrintImpl {

	/////////////////////////////////////////////////////////////
	
	@Override
	public String toJson(Object object) {
		try {
			return this.getObjectMapper().writeValueAsString(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "{}";
	}
	
	@Override
	public String toPrettyJson(Object object) {
		try {
			return this.getObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "{}";
	}
	
	@Override
	public void printJson(Object object) {
		System.out.println(">>>>> json: " + this.toJson(object));
	}
	
	@Override
	public void printPrettyJson(Object object) {
		System.out.println(">>>>> pretty json: " + this.toPrettyJson(object));
	}
	
	/////////////////////////////////////////////////////////////
	
	private ObjectMapper objectMapper = null;
	
	private ObjectMapper getObjectMapper() throws Exception {
		this.objectMapper = new ObjectMapper();
		this.objectMapper.registerModule(new JavaTimeModule());
		this.objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return this.objectMapper;
	}
}
