package com.example.demo.dto;

import lombok.Data;

@Data
public class MyError {
	// 필드명
	// 내용
	// 거절 값
	
	private String field;
	private String message;
	private Object invalidValue;
}
