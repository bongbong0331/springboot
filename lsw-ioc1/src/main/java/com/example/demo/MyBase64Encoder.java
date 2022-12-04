package com.example.demo;

import java.util.Base64;

import org.springframework.stereotype.Component;

@Component
public class MyBase64Encoder implements IPlay{

	@Override
	public String play(String playing) {
		// TODO Auto-generated method stub
		return Base64.getEncoder().encodeToString(playing.getBytes());
	}
	

}
