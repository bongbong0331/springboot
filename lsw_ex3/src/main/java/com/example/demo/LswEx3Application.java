package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class LswEx3Application {

	public static void main(String[] args) {
		SpringApplication.run(LswEx3Application.class, args);
		
		ApplicationContext acc = ApplicationContextProvider.getContext();
		
		Monkey monkey = acc.getBean(Monkey.class);
		Eagle eagle = acc.getBean(Eagle.class);
		Tiger tiger = acc.getBean(Tiger.class);
		Animal animal = acc.getBean(Animal.class);
		
		String callMonkey = animal.callAnimal("원숭이");
		System.out.println(callMonkey);
		
		String callTiger = animal.callAnimal("이지은");
		System.out.println(callTiger);
		
		String callEagle = animal.callAnimal("아이유");
		System.out.println(callEagle);
	}

}
