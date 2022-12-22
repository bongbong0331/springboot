package com.bongcoding.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bongcoding.blog.dto.User;
import com.bongcoding.blog.model.RoleType;
import com.bongcoding.blog.repository.UserRepository;


@Service
public class UserService {
	
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;

	@Transactional
	public int saveUser(User user) {
		
		try {
			
			String rawPassword = user.getPassword();
			String encPassword = encoder.encode(rawPassword);
			
			user.setPassword(encPassword);
			user.setEmail(user.getEmail());
			user.setRole(RoleType.USER);
			userRepository.save(user);
			
			return 1;
		} catch (Exception e) {
		}
		
	return -1;
		
	}
	@Transactional
	public int updateUser(User requser) {
		// TODO Auto-generated method stub
		User userEntity = userRepository.findById(requser.getId()).orElseThrow(() -> {
			return new IllegalArgumentException("해당 사용자 찾을수 없다");
		});
		
		String rawPassword = requser.getPassword();
		String encPassword = encoder.encode(rawPassword);
		
		userEntity.setUsername(userEntity.getUsername());
		userEntity.setPassword(encPassword);
		userEntity.setEmail(requser.getEmail());
				
		return 1;
	}
	
	@Transactional
	public User searchUserName(String username) {
		// TODO Auto-generated method stub
		return userRepository.findByUsername(username).orElseGet(() -> {
			return new User();
		});
	}
	
	
	
	
}