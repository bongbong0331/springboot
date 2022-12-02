package com.example.lsw1.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.lsw1.dto.Employees;
import com.example.lsw1.utils.MObjectConverter;

@RestController
@RequestMapping("/lsw")
public class APIController {
	
	// Response 방법에 대한 이해
	
	// text/plain 으로 리턴
	@GetMapping("/hi")
	public String article(@RequestParam String text) {
		return text;
	}
	
	@PostMapping("/emp")
	public Employees returnEmployees(@RequestBody Employees employees) {
		
		employees.setEmpNo("10001");
		return employees;
	}
		
	@PutMapping("/emp")
	public ResponseEntity<Employees> put (@RequestBody Employees employees){
		employees.setCode(1);
		employees.setMessage("리소스 갱신 성공 메시지");
		employees.setEmpNo("100001");
		
		return ResponseEntity.status(HttpStatus.CREATED).body(employees);
	}
	
	
	@GetMapping("/test11")
	public String makeJsonOfObject() {
		Employees employees = Employees.builder()
				.empNo("10002")
				.birthDate("1992-03-31")
				.firstName("lee")
				.lastName("bong")
				.gender("A")
				.hireDate("2002-06-14")
				.build();
		
		String json = "";
		MObjectConverter<Employees> converter = new MObjectConverter<>();
		json = converter.objectToJson(employees);
		return json;
	}
	

	
	
	
}
