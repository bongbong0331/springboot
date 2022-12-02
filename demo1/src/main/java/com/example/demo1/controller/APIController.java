package com.example.demo1.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo1.dto.UserDTO;import ch.qos.logback.core.joran.spi.ConsoleTarget;

@RestController
@RequestMapping("/api")
public class APIController {

	
	// 시나리오 
	// REST API Client
	// { "name" : "홍길동" , "age" : 10 }
	
	// http://localhost:8080/api/post
	@PostMapping("/post")
	public String post1(@RequestBody Map<String, Object>reqBody) {
		
		StringBuffer buffer = new StringBuffer();
		reqBody.entrySet().forEach(e -> {
			System.out.println("key : " + e.getKey());
			System.out.println("value : " + e.getValue());
			buffer.append(e.getKey() + " : " + e.getValue() + "\n");
		});
		
		return buffer.toString();
	}
	
	
	// 문제 - dto 설계해서 값을 받아서 출려갷보시오
//	{ "name" : "홍길동" , "age" : 10 }
	// http://localhost:8080/api/post2
	@PostMapping("/post2")
	public String postMun(@RequestBody UserDTO user) {
				
		return user.toString();
	}
	
	
	
	
}
