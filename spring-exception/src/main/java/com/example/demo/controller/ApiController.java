package com.example.demo.controller;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.User;

@RestController
@RequestMapping("/api")
@Validated   // get 방식 일때는 우리가 선언한 validation 처리가 적용이 된다.
public class ApiController {
	
	
	// ?name="티모"&age=10
	@GetMapping("/user")
	public User get(@Size(min = 2, max = 10) @RequestParam(required =true) String name, 
			@Min(1) @RequestParam(required =true) Integer age) {
		
		System.out.println("여기 코드 실행 1");
		User user = new User();
		user.setName(name);
		user.setAge(age);
		
		// 일부러 예외 발생 처리
//		int temp = 10 + age;
		
		return user;
	}
	
	@PostMapping("/user")
	public User post(@Valid @RequestBody User user) {
		System.out.println("여기 코드 실행 2");
		System.out.println("user : " + user);
		return user;
	}
	
	
	
//	@ExceptionHandler(value = MethodArgumentNotValidException.class)
//	public ResponseEntity<?> methodArgumentNotValidException(MethodArgumentNotValidException e){
//		
//		System.out.println("controller 안에서 직접 예외처리도 가능하다.");
//		System.out.println(e.getLocalizedMessage()); 
//		
//		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("");
//	}
	

}
