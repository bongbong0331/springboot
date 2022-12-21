package com.tencoding.blog.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tencoding.blog.dto.Image;

public interface ImageRepository extends JpaRepository<Image, Integer> {

//	@Query(value = "SELECT * FROM image WHERE storyText like '%q%' ", nativeQuery = true)
//	Page<Image> findByStoryText(String q, Pageable pageable);

	Page<Image> findByStoryTextContaining(String q, Pageable pageable);

////	
//	@Query(value = "SELECT * FROM image WHERE storyText like '%q%' " , nativeQuery = true)
//	Page<Image> findByImageContaining(String q, Pageable pageable);
//	

//	Image searchImage(String storyText);

//	@Query(value = " SELECT * "
//			+ " FROM user "
//			+ " WHERE username = ?1 "
//			+ " and password = ?2 " , nativeQuery = true)
//	User login(String username, String password);
}
