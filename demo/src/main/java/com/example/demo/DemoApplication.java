package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		System.out.println("여기 돌아 가나요 ?");
		SpringApplication.run(DemoApplication.class, args);
	}

}
