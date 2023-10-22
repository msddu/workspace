package com.kh.test.board.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kh.test.board.model.dto.Board;

@Mapper
public interface BoardMapper {

	/** 게시글 목록 조회
	 * @return boardList
	 */
	List<Board> selectBoardList();

	//게시글 조회
	Board selectOne(int no);

	//게시글 작성
	int insert(Board board);

	//비밀번호 조회
	String selectBoardPw(int boardNo);

	
	//게시글 삭제
	int deleteBoard(int boardNo);






}