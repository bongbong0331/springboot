package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.annota.Timer;
import com.example.demo.dto.User;

@RestController
@RequestMapping("/lsw/user")
public class ApiController {

	// http://localhost:8080/lsw/user

	@Timer
	@GetMapping("/get/{id}")
	public String get(@PathVariable Long id, @RequestParam String name) {
		return id + "," + name;
	}

	// http://localhost:8080/lsw/user/post
	@PostMapping("/post")
	public ResponseEntity<User> post(@RequestBody User user) {

		StopWatch stopWatch = new StopWatch();
		stopWatch.start();

		try {
			Thread.sleep(5500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		////////////////////////////////////////
		stopWatch.stop();
		System.err.println("걸린 시간은 ☆ : " + stopWatch.getTotalTimeMillis() + "★");

		return ResponseEntity.status(HttpStatus.OK).body(user);
	}
	
	@Timer
	@DeleteMapping("/delete")
	public void delete() {
		// d b logic . . . 
		
		try {
			Thread.sleep(77777);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
}
