package com.example.demo.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class User {

	private Long id;
	private String eamil;
	private String pw;
}
