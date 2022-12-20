//package com.mingcoding.blog.advice;
//
//import org.springframework.dao.EmptyResultDataAccessException;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//@RestControllerAdvice(basePackages = "com.mingcoding.controller")
//public class DummyControllerTestAdvice {
//
//	
//	@ExceptionHandler(value = Exception.class)
//	public ResponseEntity<?> exeption(Exception e){
//		
//
//		System.out.println("-----------------------");
//		System.out.println("에러이름 : " + e.getClass().getName());
//		System.out.println("메시지 : " + e.getLocalizedMessage());
//		System.out.println("-----------------------");
//		
//		
//		
//		
//		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("");
//	}
//	
//	
//	public String emptyResultDataAccessException(
//			EmptyResultDataAccessException e) {
//		
//		return "현재 요청하신 아이디는 존재하지않는다";
//	}
//	
//
//}
