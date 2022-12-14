package com.mingcoding.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mingcoding.blog.dto.User;
import com.mingcoding.blog.model.RoleType;
import com.mingcoding.blog.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	
	public int saveUser(User user) {
		
		try {
			String rawPassword = user.getPassword();
			String encPassword = encoder.encode(rawPassword);
			System.out.println("encPssword" + encPassword);
			
			user.setPassword(encPassword);
			user.setRole(RoleType.USER);
			userRepository.save(user);
			return 1;
		} catch (Exception e) {
			
		}
		
		return -1;
	}
	
	
	
	
	
	
	
	
//	// 초반
//	@Transactional
//	public int saveUser(User user) {
//		
//		
//		try {
//			userRepository.save(user);
//			return 1;
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return -1;
//	}
//	
	
//	public User login(User user) {
//		
//		User userEntity = userRepository.findByUsernameAndPassword(
//		User userEntity = userRepository.login(user.getUsername(), user.getPassword());
//		System.out.println("userEntity : " + userEntity);
//				
//		
//		return userEntity;
//	}
	
}
