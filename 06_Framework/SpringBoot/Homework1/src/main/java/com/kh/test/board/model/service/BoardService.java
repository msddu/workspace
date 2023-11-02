package com.kh.test.board.model.service;

import java.util.List;

import com.kh.test.board.model.dto.Board;

public interface BoardService {


	/** 게시글 목록 조회
	 * @return boardList
	 */
	List<Board> selectBoardList();

	//게시글 조회
	Board selectOne(int no);

	//글쓰기
	int insert(Board board);
	

	//비밀번호 일치하면 삭제
	int deleteBoard(String boardPw, int boardNo);

	

}