package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.Actor;
import com.fasterxml.jackson.annotation.JsonInclude;



// page 응답 할 때 사용 html, jsp, time leaf, moustch .. . .
@Controller
public class PageController {
	
	
	
	@GetMapping("/main")
	public String main() {
		// view resolver 동작으로 파일을 찾아준다. !!! 
		return "main.html";
	}
	
	//  만약 json 리턴 하고 싶다면 ? 
	@ResponseBody
	@GetMapping("/actor")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	public Actor actor() {
		var act = new Actor();
		act.setActorId("3");
		act.setFirstName("티모");
		act.setLastName("mike");
		
		return act;
	}
}
