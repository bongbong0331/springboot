package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDiApplication.class, args);
		
		MyBase64Encoder base64Encoder = new MyBase64Encoder();
		UrlEncoder urlEncoder = new UrlEncoder();
		
		MyAsonEncoder asonEncoder = new MyAsonEncoder();
		////////////////////////////////////////////////////////////////////////
		
		String mUrl = "www.naver.com/q?오늘축구이기나?";
		MyEncoder encoder = new MyEncoder(asonEncoder);
		String result = encoder.encode(mUrl);
		System.out.println(result);
		
	}

}
