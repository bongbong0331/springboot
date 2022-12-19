package com.bongcoding.blog.service;

import org.springframework.stereotype.Service;

import com.bongcoding.blog.dto.Board;
import com.bongcoding.blog.dto.User;
import com.bongcoding.blog.repository.BoardRepository;

@Service
public class BoardService {

	
	private BoardRepository boardRepository;
	
	public void write(Board board, User user) {
		
		
		board.setCount(0);
		board.setUser(user);
		boardRepository.save(board);
	}
}
