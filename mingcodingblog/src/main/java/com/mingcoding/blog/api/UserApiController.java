package com.mingcoding.blog.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mingcoding.blog.dto.ResponseDto;
import com.mingcoding.blog.dto.User;
import com.mingcoding.blog.service.UserService;

@RestController
public class UserApiController {

	@Autowired
	private UserService userService;
	
	
	@PostMapping("/api/user")
	public ResponseDto<Integer> save(@RequestBody User user){
		System.out.println("user api 호출됨 user" + user);
		int result = userService.saveUser(user);
		return new ResponseDto<Integer>(HttpStatus.OK, result);
	}
	
		
}
