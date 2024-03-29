package com.demo.mybatis.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.mybatis.model.dto.common.User;
import com.demo.mybatis.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class TestController {

	private final UserService userService;
	
	
	// localhost:8080/req-test
	@GetMapping("/req-test")
	@ResponseBody
	public String reqTest() {
		return "<h1>test OK </h1>";
	}
	
	// localhost:8080/test
	@GetMapping("/test")
	public String Test() {
		return "index";
	}
	
	@GetMapping("/user-list")
	@ResponseBody
	public List<User> userList() {
		// 서비스를 통하여 유저 리스트 요청
		List<User> list = userService.findByUserAll();
		return list; 
	}
	
	@PostMapping("/user-save")
	@ResponseBody
	public int insertUserTest(@RequestBody User user) {
		System.out.println(user.toString());
		int resultRow = userService.saveUser(user);
		return resultRow;
	}
	
	@DeleteMapping("/user-delete/{userId}")
	@ResponseBody
	public int deleteUserTest(@PathVariable int userId) {
		return userService.deleteUser(userId);
	}
	
	@PutMapping("/user-update")
	@ResponseBody
	public int userUpdate(@RequestBody User user) {
		return userService.userUpdate(user);
	}
	
}
