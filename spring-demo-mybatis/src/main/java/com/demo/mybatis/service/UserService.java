package com.demo.mybatis.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.mybatis.model.dao.UserDAO;
import com.demo.mybatis.model.dto.common.User;

@Service
public class UserService {

	private final UserDAO userDAO;
	
	public UserService(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	@Transactional
	public List<User> findByUserAll(){
		List<User> userList = userDAO.findAll();
		return userList;
	}

	@Transactional
	public int saveUser(User user) {
		int result = userDAO.insert(user);
		return result;
	}
	
	@Transactional
	public int deleteUser(int userId) {
		return userDAO.deleteById(userId);
	}
	
	@Transactional
	public int userUpdate(User user) {
		int result = userDAO.update(user);
		return result;
	}
}
