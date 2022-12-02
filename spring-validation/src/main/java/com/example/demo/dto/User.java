package com.example.demo.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;

import lombok.Data;


@Data
public class User {

	@NotBlank(message = "이름을 입력해주세요")
	private String name;
	
	@Max(value = 100, message = "죄송하지만 100세는 가입 불가입니다.")
	@Min(value = 10, message = "중학생 이후 가입 가능합니다.")
	private int age;  // 101
	
	@Email
	private String email;
	
	// @Pattern(regexp = "^\d{2,3}-\d{3,4}-\d{4}$") 디코로 받은것
	@Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$", message = "핸드폰 번호의 양식과 맞지 않습니다.")
	private String phoneNumber;
	
	
	
	
	
	
	
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public int getAge() {
//		return age;
//	}
//
//	public void setAge(int age) {
//		this.age = age;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public String getPhoneNumber() {
//		return phoneNumber;
//	}
//
//	public void setPhoneNumber(String phoneNumber) {
//		this.phoneNumber = phoneNumber;
//	}
//
//	@Override
//	public String toString() {
//		return "User [name=" + name + ", age=" + age + ", email=" + email + ", phoneNumber=" + phoneNumber + "]";
//	}

}
