package com.example.demo.advice;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.dto.ErrorResponse;
import com.example.demo.dto.MyError;

@RestControllerAdvice
public class ApiControllerAdvice {

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<?> exception(Exception e) {

		System.out.println("--------------------------------------------");
		System.out.println(e.getClass().getName());
		System.out.println(e.getLocalizedMessage());
		System.out.println("------------------------------------------");

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("");
	}

	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<?> methodArgumentNotValidException(MethodArgumentNotValidException ex,
			HttpServletRequest req) {
		ArrayList<MyError> myErrors = new ArrayList<>();
		
		// name, age
		ex.getBindingResult().getAllErrors().forEach(e -> {
			FieldError fieldError = (FieldError) e;
			
			String fieldName = fieldError.getField();
			String message = fieldError.getDefaultMessage();

			Object rejectValue = fieldError.getRejectedValue();
			
			MyError error = new MyError();
			error.setField(fieldName);
			error.setMessage(message);
			error.setInvalidValue(rejectValue);
			
			myErrors.add(error);
			
		});
		
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setErrorList(myErrors);
		errorResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
		errorResponse.setMessage("잘못된 요청 입니다.");
		errorResponse.setCode(-1);
		errorResponse.setResultCode("Fail");
		errorResponse.setRequestUrl(req.getRequestURI());

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(myErrors);
	}
	
//	@ExceptionHandler(value = MissingServletRequestParameterException.class)
//	public ResponseEntity<?> missingServletRequestParameterException(MissingServletRequestParameterException em){
//		ArrayList<MyError> myErrors = new ArrayList<>();
//		
//		MyError error = new MyError();
//		
//		String e = em.getParameterName();
//		if(e.isEmpty()) {
//			
//		}
//		
//		
//		
//		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
//	}
	
	
	@ExceptionHandler(value = MissingServletRequestParameterException.class)
    public ResponseEntity<?> missingServletRequestParameterException(
            MissingServletRequestParameterException e,
            HttpServletRequest req) {


        System.out.println("여기오삼 ???");
        ArrayList<MyError> myErrors = new ArrayList<>();

        String name = e.getParameterName();
        String msg = "";

        MyError error = new MyError();
        error.setField(name);
        System.out.println("name: " + name);
        if (name.equals("name")) {
            msg = "이름을 입력하시오! (필수 입력 값)";
            error.setMessage(msg);
        } else if (name.equals("age")){
            msg = "나이를 입력하시오! (필수 입력 값)";
            error.setMessage(msg);
        }
        System.out.println("msg: " + msg);
//        error.setInvalidValue(req);
        myErrors.add(error);

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorList(myErrors);
        errorResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
        errorResponse.setMessage("잘못된 요청입니다.");
        errorResponse.setCode(-1);
        errorResponse.setResultCode("FAIL");
        errorResponse.setRequestUrl(req.getRequestURI());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }
	
	
	
	

}
