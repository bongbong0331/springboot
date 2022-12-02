package com.example.demo;

import java.util.Base64;

import org.springframework.stereotype.Component;

// 스프링 빈은 스프링 컨테이너에 의해 관리되는 자바 객체를 의미한다.
// 개발자 : 스프링 컨테이너에 너가 객체를 생성해서 관리 해 !
// spring : 알았어 내가 관리하는 컨테이너에 넣고 싱글톤으로 관리할게 ! 나중에 너가 필요하다면 DI를 통해서 가져가서 사용 해 !!!
@Component
public class MyBase64Encoder implements IEncoder {

	@Override
	public String encode(String msg) {
		return Base64.getEncoder().encodeToString(msg.getBytes());
	}

	// 테스트 코드
	public static void main(String[] args) {
		MyBase64Encoder base64Encoder = new MyBase64Encoder();
		String msg = base64Encoder.encode("안녕하세요포항항");
		System.out.println(msg);
	}

}
