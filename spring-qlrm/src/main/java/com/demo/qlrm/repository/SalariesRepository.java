package com.demo.qlrm.repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.qlrm.mapper.JpaResultMapper;
import org.springframework.stereotype.Repository;

import com.demo.qlrm.dto.res.EmployeesDTO;
import com.demo.qlrm.dto.res.SalariesDto;

@Repository
public class SalariesRepository {

	private final EntityManager entityManager;
	
	public SalariesRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public SalariesDto getSalaryInfo() {
		
		String salQuery = " SELECT "
				+ "    * , COUNT(salary) AS paycheck "
				+ " FROM "
				+ "    salaries AS s "
				+ " GROUP BY emp_no "
				+ " HAVING emp_no = 10002 ";
		
		
		
		Query nativeSQuery = entityManager.createNativeQuery(salQuery);
		
		
		
		JpaResultMapper mapper = new JpaResultMapper();
		
		SalariesDto dto = mapper.uniqueResult(nativeSQuery, SalariesDto.class);
		
		
		return mapper.uniqueResult(nativeSQuery, SalariesDto.class);
	}
	
	
	
	
	
}
