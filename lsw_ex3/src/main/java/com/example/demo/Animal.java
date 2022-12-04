package com.example.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Animal {

	private IAnimal iAnimal;
	
	public Animal(@Qualifier("Monkey")IAnimal iAnimal) {
		// TODO Auto-generated constructor stub
		this.iAnimal = iAnimal;
	}
	
	
	public void setAnimal(IAnimal iAnimal) {
		this.iAnimal = iAnimal;
	}
	
	public String callAnimal(String mon) {
		return iAnimal.animal(mon) + "부르기";
	}
	
}
