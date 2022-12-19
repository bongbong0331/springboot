package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.User;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@RequestMapping("/api")
public class ApiController {

	// http://localhost:8080/api/get/[]?name=[홍기동]
	@GetMapping("/get/{id}")
	public String get(@PathVariable Long id,@RequestParam String name) {
//		System.out.println("---------------------------");
//		log.info(">>> id  넘겨 받은 값은 {}", id);
//		log.info("id : {}, name : {}", id, name);
//		System.out.println("---------------------------");
		
		return "id: " + id +", name: " + name ;
	}
	
	
	@PostMapping("/post")
	public ResponseEntity<User> post (@RequestBody User user) {
//		log.info("user >>> {}", user);
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}
	
	
}
