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

	
	//게시글 조회
	@Override
	public Board selectOne(int no) {
		return mapper.selectOne(no);
	}

	
	//게시글 작성
	@Override
	public int insert(Board board) {
		
		board.setBoardPw(bcrypt.encode(board.getBoardPw()));
		
		return mapper.insert(board);
	}

	
	//비밀번호 일치하면 게시글 삭제
	@Override
	public int deleteBoard(String boardPw, int boardNo) {
		
		String encPw = mapper.selectBoardPw(boardNo);

	
		if( !bcrypt.matches(boardPw, encPw) ) {
			return 0;
		}

		return mapper.deleteBoard(boardNo);
	}

	

	
}