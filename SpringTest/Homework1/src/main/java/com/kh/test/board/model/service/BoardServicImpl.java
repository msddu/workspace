package com.kh.test.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.test.board.model.dto.Board;
import com.kh.test.board.model.mapper.BoardMapper;

@Transactional
@Service
public class BoardServicImpl implements BoardService {
	
	@Autowired
	private BoardMapper mapper;

	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	
	@Override
	public List<Board> selectBoardList() {
		return mapper.selectBoardList();
	}
}
