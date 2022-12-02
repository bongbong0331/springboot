package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/my")
public class APIControllerMyEx {

	
	@GetMapping("/first")
	public String myExController() {
		System.out.println("http://localhost:8080/my/first 처음인데! 여기로 왔네요 !!!!");
		return "처음인데 !!!!";
	}

}
