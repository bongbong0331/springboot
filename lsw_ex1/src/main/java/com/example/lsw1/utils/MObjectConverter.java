package com.example.lsw1.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MObjectConverter <T>{

	
	T obj;
	
	public String objectToJson(T t) {
		String json = "";
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			json = mapper.writeValueAsString(t);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json;
	}
}
