package com.demo.qlrm.dto.res;

import java.math.BigInteger;
import java.sql.Date;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class NameSearchDTO {

	
	private int emp_no;
	private Date birth_date;
	private String first_name;
	private String last_name;
	private String gender;
	private Date hire_date;
	
	private BigInteger x_name;
	
	
	
	public NameSearchDTO(Object[] objs) {
		
		for(int i = 0; i < objs.length; i++) {
			System.out.println(objs[i]);
			// 런타임 시 데이터 타입 확인 (..)
			System.out.println(objs[i].getClass().getTypeName());  // dto 프로젝트 써라
			System.out.println("---------------------------------------");
			
		}
		
		this.emp_no = ( (Integer)objs[0] ).intValue();
		this.birth_date = ( (Date)objs[1] );
		this.first_name = ( (String)objs[2] );
		this.last_name = ( (String)objs[3] );
		this.gender = ( (Character)objs[4] ).toString();
		this.hire_date = ( (Date)objs[5] );
		this.x_name = ( (BigInteger)objs[6] );
	}




	// 전체 생성자를 활용 하면 알아서 JpaMapper 녀석이 호출하여 맵핑해준다.
	public NameSearchDTO(Integer emp_no, Date birth_date, 
			String first_name, String last_name, Character gender, Date hire_date,
			BigInteger x_name) {
		System.out.println(":111111111111111111111111111111111111111111111111");
		
		this.emp_no = emp_no.intValue();
		this.birth_date = birth_date;
		this.first_name = first_name;
		this.last_name = last_name;
		this.gender = gender.toString();
		this.hire_date = hire_date;
		this.x_name = x_name;
	}
	
	public NameSearchDTO(Integer emp_no, Date birth_date, String first_name,
			String last_name, Character gender, Date hire_date) {
		
		this(emp_no, birth_date, first_name, last_name, gender, hire_date, null);
	}


}
