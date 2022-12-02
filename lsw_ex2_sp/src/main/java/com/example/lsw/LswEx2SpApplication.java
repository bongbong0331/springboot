package com.example.lsw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class LswEx2SpApplication {

	public static void main(String[] args) {
		SpringApplication.run(LswEx2SpApplication.class, args);
		
		ApplicationContext context = ApplicationContextProvider.getContext();
		
		String myUrl = "www.naver.com/아아아아";
		
		MtBase64Encoder base64Encoder = context.getBean(MtBase64Encoder.class);
		UrlEncoder urlEncoder = context.getBean(UrlEncoder.class);
		
		MyEncoder myEncoder = context.getBean(MyEncoder.class);
		
		String result = myEncoder.encode(myUrl);
		
		myEncoder.setIComponent(base64Encoder);
		
		System.out.println(result);
	}

}
