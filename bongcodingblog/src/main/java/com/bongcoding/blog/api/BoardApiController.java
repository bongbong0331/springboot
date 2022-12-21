package com.bongcoding.blog.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bongcoding.blog.auth.PrincipalDetail;
import com.bongcoding.blog.dto.Board;
import com.bongcoding.blog.dto.ResponseDto;
import com.bongcoding.blog.service.BoardService;

@RestController
public class BoardApiController {

	@Autowired
	private BoardService boardService;
	
	@PostMapping("/api/board")
	public ResponseDto<Integer> save(@RequestBody Board board,
			@AuthenticationPrincipal PrincipalDetail detail){
		
		System.out.println(board);
		boardService.write(board, detail.getUser());
		
		return new ResponseDto<Integer>(HttpStatus.OK, 1);
	}
	
	@DeleteMapping("/api/board/{id}")
	public ResponseDto<Integer> deleteDetailById(@PathVariable int id){
		boardService.deleteById(id);
		return new ResponseDto<Integer>(HttpStatus.OK, 1);
	}
	
	@PutMapping("/api/board/{boardId}")
	public ResponseDto<Integer> update(@PathVariable int boardId, @RequestBody Board board){
		System.out.println("아오옹");
		int result = boardService.modifyBoard(boardId, board);
		return new ResponseDto<Integer>(HttpStatus.OK, result);
	}
	
}
