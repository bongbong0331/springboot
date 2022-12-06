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
@RequestMapping("/apie")
@Validated
public class ApiController {

	
	@GetMapping("/user1")
	public User get(@Size(min = 2, max = 10) @RequestParam(required = false) String userName, @Min(2) @RequestParam(required = true) Integer userAge) {
		
		System.out.println("실행 겟");
		
		
		User user = new User();
		user.setUserName(userName);
		user.setUserAge(userAge);
		
		
		int temp = 10 + userAge;
		
		return user;
	}
	
	
	@PostMapping("/user1")
	public User post(@Valid @RequestBody User user) {
		
		System.out.println("실행 포스트");
		System.out.println("user : " + user);
		return user;
	}
	
}
