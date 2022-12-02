package com.example.demo2.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo2.dto.RequestPutDTO;
import com.example.demo2.dto.ResponsePutDTO;

@RestController
@RequestMapping("/api")
public class PutApiController {

	@PutMapping("/put1")
	public ResponsePutDTO put(@RequestBody RequestPutDTO reqDto) {

		// 연산 과정 ...
		// DB 접근해서 처리
		ResponsePutDTO result = new ResponsePutDTO();

		// 문제 제이슨을 만들어서 응답처리까지 완료하시오 !
		result.setAge(reqDto.getAge());
		result.setName(reqDto.getName());
		result.setCarList(reqDto.getCarList());
		result.setStatusCode(200);

		return result;
	}

//	문제 2 !! !! ! !
//	// http://localhost:8080/api/put2/100
//	@PutMapping(path = "/put2/{age}")
//	public String put2(@RequestBody ResponsePutDTO reqDto, @PathVariable int age) {
//		
//		return reqDto.toString() + "...." + age;
//	}

}
