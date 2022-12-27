package com.demo.qlrm.dto.res;

import java.math.BigInteger;
import java.sql.Date;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class SalariesDto {
	
	private int emp_no;
	private int salary;
	private Date from_date;
	private Date to_date;
	private BigInteger paycheck;

	
	public SalariesDto(Object[] objs) {
		
		for(int i = 0; i < objs.length; i++) {
			System.out.println(objs[i].getClass().getTypeName());
			System.out.println("=-=-==-=-==-=-=-=-=-===-=-==");
		}
		this.emp_no = ( (Integer)objs[0] ).intValue();
		this.salary = ( (Integer)objs[1] ).intValue();
		this.from_date = ( (Date)objs[2] );
		this.to_date = ( (Date)objs[3] );
		this.paycheck = ( (BigInteger)objs[4] );
	}
	
	
	


//	public SalariesDto(int emp_no, int salary, Date from_date, Date to_date) {
//		this(emp_no, salary, from_date, to_date, null);
//		this.emp_no = emp_no;
//		this.salary = salary;
//		this.from_date = from_date;
//		this.to_date = to_date;
//	}
	public SalariesDto(Integer emp_no, Integer salary, Date from_date, Date to_date, BigInteger paycheck) {
		super();
		this.emp_no = emp_no.intValue();
		this.salary = salary;
		this.from_date = from_date;
		this.to_date = to_date;
		this.paycheck = paycheck;
	}
	
	public SalariesDto(Integer emp_no, Integer salary, Date from_date, Date to_date) {
		
		this(emp_no, salary, from_date, to_date, null);
	}







	
	
	
	
}
