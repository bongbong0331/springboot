//package com.example.demo.advice;
//
//import java.util.HashMap;
//import java.util.StringTokenizer;
//
//import javax.validation.ConstraintViolationException;
//import javax.validation.Path;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.FieldError;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//@RestControllerAdvice(basePackages = "com.example.demo.controller.StudentApiController")
//public class StudentApiControllerAdvice {
//
//	@ExceptionHandler(value = Exception.class)
//	public ResponseEntity<?> myException(Exception exception) {
//
//		System.out.println("----------------------------------");
//		System.out.println(exception.getClass().getName());
//		System.out.println(exception.getMessage());
//		System.out.println("----------------------------------");
//
//		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("FAIL");
//	}
//
//	// post 넘겨 받을 시 값이 잘못 되었을 때
//	@ExceptionHandler(value = MethodArgumentNotValidException.class)
//	public ResponseEntity<?> methodArgumentNotValidException(MethodArgumentNotValidException e) {
//
//		// name ---...
//		// age ---...
//		// List<ObjectErrors>
//
//		HashMap<String, String> errorMap = new HashMap<>();
//
//		e.getBindingResult().getAllErrors().forEach(e2 -> {
//			FieldError fieldError = (FieldError) e2;
//			String fieldName = fieldError.getField(); // name, .. 2 , age. 3 email....
//			String message = fieldError.getDefaultMessage();
//			// name : "뭐가 잘못 되었어"
//			errorMap.put(fieldName, message);
//		});
//
////		System.out.println("여기 들어오나요 >?");
////		e.printStackTrace();
//
//		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMap);
//	}
//
//	// Get 요청시 선언된 valid 값이 잘못 들어왔을 경우
//	@ExceptionHandler(value = ConstraintViolationException.class)
//	public ResponseEntity<?> constraintViolationException(ConstraintViolationException exception) {
//		HashMap<String, String> errorMap = new HashMap<>();
//
//		// request . id <====
//		exception.getConstraintViolations().forEach(e2 -> {
//			Path path = e2.getPropertyPath();
//			StringTokenizer stringTokenizer = new StringTokenizer(path.toString(), ".");
//			if (stringTokenizer.hasMoreElements()) {
//				String preName = stringTokenizer.nextToken();
//				
//				
//				String lastName = stringTokenizer.nextToken();
//				String message = e2.getMessage();
//				System.out.println("invalidValue : " + e2.getInvalidValue());
//				errorMap.put(lastName, message);
//				
//			}
//
//		});
//
//		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMap);
//	}
//
//}



// 지은이 꺼 
package com.example.demo.advice;

import java.util.HashMap;
import java.util.StringTokenizer;

import javax.validation.ConstraintViolationException;
import javax.validation.Path;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackages = "com.example.demo.controller")
public class StudentApiControllerAdvice {

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<?> myException(Exception exception) {

		System.out.println("-----------------------------------");
		System.out.println(exception.getClass().getName());
		System.out.println(exception.getMessage());
		System.out.println("-----------------------------------");

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("FAIL");
	}

	// Get 요청시 선언된 Valid 값이 잘못 들어왔을 경우 (id >100 인데 1들어왔을때)
	@ExceptionHandler(value = ConstraintViolationException.class)
	public ResponseEntity<?> constraintViolationException(ConstraintViolationException exception) {

		HashMap<String, String> errorMap = new HashMap<>();

		exception.getConstraintViolations().forEach(e -> {
			Path path = e.getPropertyPath();

			StringTokenizer stringTokenizer = new StringTokenizer(path.toString(), ".");

			if (stringTokenizer.hasMoreElements()) {
				String preName = stringTokenizer.nextToken();

				String lastName = stringTokenizer.nextToken();
				String message = e.getMessage();
				
				System.out.println("InvalidValue : "+e.getInvalidValue());
				// 잘못된 값은 1로 보냄 , 

				errorMap.put(lastName, message);
			}

		});

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMap);

	}
	
	@ExceptionHandler(value = MissingServletRequestParameterException.class)
	public ResponseEntity<?> missingServletRequestParameterException (MissingServletRequestParameterException e){
		HashMap<String, String> eromap = new HashMap<>();
		
		String eee = e.getParameterName();
		System.out.println(eee+"eee");
		eromap.put(eee, eee+"아이디값을 넣으세여");
		
		
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(eromap);
	}

	

	
	// Post 넘겨 받을 시 잘못된 값이 넘어 온다면 처리 방법
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<?> methodArgumentNotValidException(MethodArgumentNotValidException e) {
		// System.out.println("여기 들어오나요 ? ");

		HashMap<String, String> errorMap = new HashMap<>();

		e.getBindingResult().getAllErrors().forEach(e2 -> {
			FieldError fieldError = (FieldError) e2;
			String fieldName = fieldError.getField();
			String message = fieldError.getDefaultMessage();

			errorMap.put(fieldName, message);

		});
		// e.printStackTrace();
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMap);
	}

	// Post 넘겨 받을 시 필수 키 값을 아예 보내지 않았을 경우

}

