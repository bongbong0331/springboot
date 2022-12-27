package com.bongcoding.blog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bongcoding.blog.dto.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	
	Optional<User> findByUsername(String username);

	
}
