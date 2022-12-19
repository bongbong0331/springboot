package com.demo.client1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.client1.dto.UserResponse;
import com.demo.client1.service.RestTemplateService;

@RestController
@RequestMapping("/api/client")
public class ApiController {

	private final RestTemplateService service;

	public ApiController(RestTemplateService service) {
		this.service = service;
	}

	@GetMapping("/get-hello")
	public UserResponse getHello() {

		return service.반가워();
	}
}
