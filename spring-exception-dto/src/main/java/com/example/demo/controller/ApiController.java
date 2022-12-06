package com.example.demo.controller;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.User;

@RestController
@RequestMapping("/api")
public class ApiController {

	@PostMapping("/user")
	public User post(@Valid @RequestBody User user) {

		System.out.println("1111111111111111111111111111111111111111111");
		
		
		return user;
	}
	
	@Validated
	@GetMapping("/user")
	public User get(@RequestParam(required = true)@Size(min = 5) String name, @RequestParam(required = true)@Min(5) Integer age) {
		System.out.println("@2222222222222222222222222222222");
		
		User user = new User();
		user.setName(name);
		user.setAge(age);
		
		return user;
	}

}
