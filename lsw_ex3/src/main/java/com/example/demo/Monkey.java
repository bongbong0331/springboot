package com.example.demo;

import org.springframework.stereotype.Component;

@Component("Monkey")
public class Monkey implements IAnimal{

	@Override
	public String animal(String mon) {
		// TODO Auto-generated method stub
		
		String monkey = mon;
		return monkey + "monkey";
	}

	
}
