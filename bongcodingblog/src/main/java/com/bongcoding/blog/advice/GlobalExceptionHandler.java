package com.bongcoding.blog.advice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.UnexpectedRollbackException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.bongcoding.blog.dto.CustomError;
import com.bongcoding.blog.dto.ErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(value = Exception.class)
	public void exception(Exception e) {
		System.out.println("---------------------");
		System.out.println(e.getClass().getName());
		System.out.println(e.getMessage());
		System.out.println("---------------------");
	}
	
	@ExceptionHandler(value = IllegalArgumentException.class)
	public String illegalArgumentException(IllegalArgumentException e) {
		
		return "<h1>" + e.getMessage() + "</h1>";
	}
	
	
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<?> methodArgumentNotValidException(MethodArgumentNotValidException e){
		System.out.println("IllegalArgumentException 발생");
		List<CustomError> eList = new ArrayList<CustomError>();
		
		BindingResult bindingResult = e.getBindingResult();
		bindingResult.getAllErrors().forEach(action -> {
			FieldError fieldError = (FieldError) action;
			String fieldName = fieldError.getField();
			String message = fieldError.getDefaultMessage();
			
			CustomError customError = new CustomError();
			customError.setField(fieldName);
			customError.setMessage(message);
			eList.add(customError);
		});
		
		// TODO
		// Error Response 는 추후 처리
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(eList);
	}
	
	@ExceptionHandler(value = UnexpectedRollbackException.class)
	public ResponseEntity<?> unexpectedRollbackException(UnexpectedRollbackException e){
		System.out.println("UnexpectedRollbackException 발생");
		ErrorResponse errorResponse = ErrorResponse
				.builder()
				.statusCode(HttpStatus.BAD_REQUEST.toString())
				.code(HttpStatus.BAD_REQUEST.value())
				.message("동일안 하이디가 존재하나디")
				.build();
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
	}
	
}
