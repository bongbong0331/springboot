package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class LswIoc1Application {

	public static void main(String[] args) {
		SpringApplication.run(LswIoc1Application.class, args);
		
		
		ApplicationContext acctt = ApplicationContextProvider.getContext();
		
		MyBase64Encoder base64Encoder = acctt.getBean(MyBase64Encoder.class);
		
		System.out.println(base64Encoder.play("dddd123d"));
		System.out.println("asdsad");
		
		
		
	}
	
	
	

}
