package com.kh.test.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.test.board.model.dto.Board;
import com.kh.test.board.model.service.BoardService;

@Controller
@RequestMapping("/")
public class BoardController {

	@Autowired
	private BoardService service;
	
	@GetMapping("selectBoard")
	public String selectBoard(String inputTitle, Board board) {
		
		List<Board> list = service.selectBoard(inputTitle, board);
		
		
		
		if( list== null) {
			return "searchFail";
		}
	
		return "searchSuccess";
	}
	
}
