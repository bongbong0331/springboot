package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Actor;
import com.example.demo.utils.MObjectConverter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api")
public class APIController {

	
	
	// Response 방법에 대한 이해
	
	
	// text/plain 으로 리턴
	@GetMapping("/article")
	public String article(@RequestParam String text) {
		return text;
	}
	
	
	// Object type 리턴 하면 json 으로 자동 변환 처리
	
	// application/json
	// request(json) => objectMapper => object 변환 처리 함. 
	// response(object) => objectMapper => json 문자형식 변환 함.
	@PostMapping("/act")
	public Actor returnSelfActor(@RequestBody Actor actor) {
		// 200
		actor.setActorId("2"); 
		return actor;
	}
	
	@PutMapping("/act")
	public ResponseEntity<Actor> put(@RequestBody Actor actor) {
		actor.setCode(1);
		actor.setMessage("리소스 갱신 성공 메세지");
		actor.setActorId("2");
		
		return ResponseEntity.status(HttpStatus.CREATED).body(actor);
	}
	
	
	// 생성된 객체가 있다면 json 형식의 문자열을 만드는 샘플 코드를 굳이 만들어 보자
	@GetMapping("/test1") // http://locahost:8080/api/test1
	public String makeJsonOfObject() {
		Actor actor = Actor.builder()
				.actorId("2")
				.lastUpdate("2006-02-15")
				.firstName("NICK")
				.lastName("WAHLBERG")
				.build();
		
		String json = "";
		
		MObjectConverter<Actor> converter = new MObjectConverter();
		json = converter.objectToJson(actor);
		return json;
	}
	
	
}
