package com.example.demo;

import org.springframework.stereotype.Component;

@Component("DarkChocolateMaker")
public class DarkChocolateMaker implements IChocolateMaker{

	@Override
	public String maker(String taste) {
		String darkChocolate = taste;
		return darkChocolate;
	}

}
