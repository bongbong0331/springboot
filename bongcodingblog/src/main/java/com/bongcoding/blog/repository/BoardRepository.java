package com.bongcoding.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bongcoding.blog.dto.Board;

public interface BoardRepository extends JpaRepository<Board, Integer>{

}
