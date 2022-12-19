package com.demo.client1.service;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.demo.client1.dto.UserResponse;

@Service
public class RestTemplateService {

	// 여기서 hello 만들어서 다른 서버에 접근하여 결과를 받아오기
	public UserResponse 반가워() {

		// 이녀석을 통하여 객체 만들거야
		URI uri = UriComponentsBuilder.fromUriString("http://localhost:8080")
				.path("/api/server/hello/{userId}/name/{username}")
				.queryParam("test1", "value1")
				.queryParam("test2", "value2")
				.encode() // %341sada213
				.build()
				.expand(100, "mike")
				.toUri();

		System.out.println("주소 확인 " + uri.toString());

		RestTemplate restTemplate = new RestTemplate();
//		String result = restTemplate.getForObject(uri, String.class);

		ResponseEntity<UserResponse> result = restTemplate.getForEntity(uri, UserResponse.class);

		System.out.println(result.getStatusCode());
		System.out.println(result.getBody());
		
		return result.getBody();
	}
	
}
