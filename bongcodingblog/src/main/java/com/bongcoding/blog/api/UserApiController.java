package com.bongcoding.blog.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bongcoding.blog.dto.ResponseDto;
import com.bongcoding.blog.dto.User;
import com.bongcoding.blog.service.UserService;

@RestController
public class UserApiController {
	
	@Autowired
	private UserService userService; 
	
	
	
	@PostMapping("/auth/joinProc")
	public ResponseDto<Integer> save(@RequestBody User user) {
		
		int result = userService.saveUser(user);
		
		return new ResponseDto<>(HttpStatus.OK, result);
	}

}
