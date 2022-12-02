package com.example.demo.controller;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
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
@Validated // <<< GET 방식일 때는 반드시 여기에 추가 
public class ApiController {
	
	@PostMapping("/user")
	// @Valid 을 사용하여야 우리가 적용한 valid 처리를 한다 ! 
	public ResponseEntity<?> user(@Valid @RequestBody User user, BindingResult bindingResult){
		
		if(bindingResult.hasErrors()) {
			StringBuffer sb = new StringBuffer();
			
			bindingResult.getAllErrors().forEach(error -> {
				FieldError field = (FieldError)error;
				String message = error.getDefaultMessage();
				
//				System.out.println("field : " + field.getField());
//				System.out.println("message : " + message);
				
				sb.append("field : " + field.getField());
				sb.append("message : " + message);
			});
			
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sb.toString());
		}
		
		// 예전방식
//		if(user.getAge() < 1 || user.getAge() > 100) {
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(user);
//		}
		
		
		System.out.println(user);
		return ResponseEntity.ok(user); 
		
	}
	
	
	// ---- 겟 방식
	@GetMapping("/user1")
	public User user1(@Size(min = 2) @RequestParam String name,@Min(1) @RequestParam int age) {
		User user = new User();
		user.setName(name);
		user.setAge(age);
		
		return user;
		
	}
	
	

}
