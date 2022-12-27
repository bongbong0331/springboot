
package com.demo.qlrm.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.qlrm.dto.res.EmployeesDTO;
import com.demo.qlrm.dto.res.NameSearchDTO;
import com.demo.qlrm.dto.res.SalariesDto;
import com.demo.qlrm.repository.EmployeeRepository;
import com.demo.qlrm.repository.SalariesRepository;

@RestController
public class HomeApiController {
	
	// 여기에서는 service 를 만들지 않고 바로 repository test 하기
	private final EmployeeRepository employeeRepository;
	private final SalariesRepository salariesRepository;
	
	
	

	public HomeApiController(EmployeeRepository employeeRepository, SalariesRepository salariesRepository) {
		this.employeeRepository = employeeRepository;
		this.salariesRepository = salariesRepository;
	}



	@GetMapping({"", "/index", "/home"})
	public ResponseEntity<?> home() {
		// Object mapper 
		EmployeesDTO resultDto = employeeRepository.getOldEmployeesAgeInfo();
		return new ResponseEntity<EmployeesDTO>(resultDto, HttpStatus.OK);
	}
	
	@GetMapping("/salary")
	public ResponseEntity<?> salaryHome(){
		SalariesDto resultDto = salariesRepository.getSalaryInfo();
		return new ResponseEntity<SalariesDto>(resultDto, HttpStatus.OK);
	}
	
	@GetMapping("/x-name-search")
	public ResponseEntity<?> nameHome(){
		List<NameSearchDTO> resultDto = employeeRepository.getKyoichiInfo();
		return new ResponseEntity<List<NameSearchDTO>>(resultDto, HttpStatus.OK);
	}
	
	@GetMapping("/x-name-search2")
	
	public ResponseEntity<?> nameHome2(){
		NameSearchDTO resultDto = employeeRepository.getKyoichiInfo2();
		return new ResponseEntity<NameSearchDTO>(resultDto, HttpStatus.OK);
		
	}
	
}
