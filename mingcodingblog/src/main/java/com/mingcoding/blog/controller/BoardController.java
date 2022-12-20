package com.mingcoding.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

	
	@GetMapping({"", "/"})
	public String index() {
		
		return "index";
	}
	
	
	@GetMapping("/user/join")
	public String join() {
		
		return "/user/join";
	}
}
