package com.bongcoding.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bongcoding.blog.dto.Board;
import com.bongcoding.blog.dto.User;
import com.bongcoding.blog.repository.BoardRepository;

@Service
public class BoardService {

	@Autowired
	private BoardRepository boardRepository;
	
	
	public void write(Board board, User user) {
		
		
		board.setCount(0);
		board.setUser(user);
		boardRepository.save(board);
	}

	@Transactional(readOnly = true)
	public Page<Board> getBoardList(Pageable pageable) {
		
		return boardRepository.findAll(pageable);
	}

	public Board boardDetail(int id) {
		
		return boardRepository.findById(id).orElseThrow(() -> {
			return new IllegalArgumentException("해당글몬찬트나");
		});
	}
	
	
	
}