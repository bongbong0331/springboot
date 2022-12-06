package com.example.demo.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class User {
	
	
	@NotEmpty
	@Size(min = 3, max = 5)
	private String userName;
	@Min(2)
	private int userAge;

}
