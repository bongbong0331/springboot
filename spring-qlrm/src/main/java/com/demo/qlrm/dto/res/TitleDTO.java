package com.demo.qlrm.dto.res;

import java.sql.Date;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class TitleDTO {

	private int emp_no;
	private String title;
	private Date from_date;
	private Date to_date;



	

	public TitleDTO(Object[] objs) {
		
		
		for(int i = 0; i < objs.length; i++) {
			
			
		}
	
	}
	
}
