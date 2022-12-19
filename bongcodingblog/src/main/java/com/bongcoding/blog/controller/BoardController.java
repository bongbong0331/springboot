package com.bongcoding.blog.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.bongcoding.blog.auth.PrincipalDetail;


@Controller
public class BoardController {
	
	
	
	
	@GetMapping({ " " , "/" })
	public String index(@AuthenticationPrincipal PrincipalDetail principalDetail) {

//		if(princi) {
//			이거하는중
//		}
		return "index";
	}

}
