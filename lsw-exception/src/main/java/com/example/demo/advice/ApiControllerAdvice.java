package com.example.demo.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackages = "com.example.demo.advice")
@ControllerAdvice
public class ApiControllerAdvice {

	
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<?> exception(Exception exception){
		
		System.out.println("-----");
		System.out.println(exception.getClass().getName());
		System.out.println(exception.getLocalizedMessage());
		System.out.println("-----");
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("");
	}
	
	
	
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<?> methodArgumentNotValidException(MethodArgumentNotValidException exception){
		
		System.out.println("MethodArgumentNotValidException 예외 발생123");
		System.out.println(exception.getLocalizedMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("");
	}
	
	@ExceptionHandler(value = HttpMessageNotReadableException.class)
	public ResponseEntity<?> httpMessageNotReadableException(HttpMessageNotReadableException exception){
		
		System.out.println("HttpMessageNotReadableException 예외 발생!!!");
		System.out.println(exception.getLocalizedMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("");
	}
	
	
	
	
}
