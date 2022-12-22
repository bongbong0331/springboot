package com.bongcoding.blog.api;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bongcoding.blog.dto.ResponseDto;
import com.bongcoding.blog.dto.User;
import com.bongcoding.blog.service.UserService;

@RestController
public class UserApiController {
	
	@Autowired
	private UserService userService; 
	@Autowired
	private HttpSession session;
	@Autowired
	private AuthenticationManager authenticationManager;
	
	
	@PostMapping("/auth/joinProc")
	public ResponseDto<Integer> save(@RequestBody User user) {
		
		int result = userService.saveUser(user);
		
		return new ResponseDto<>(HttpStatus.OK, result);
	}
	
	@PutMapping("/api/user")
	public ResponseDto<Integer> update(@RequestBody User user){
		
		userService.updateUser(user);
		
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken
						(user.getUsername(), user.getPassword()));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		
		
		return new ResponseDto<Integer>(HttpStatus.OK, 1);
	}
	

}
