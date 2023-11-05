package edu.kh.project.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.kh.project.model.dto.Board;



@Mapper
public interface BoardMapper {

	List<Board> selectBoard(int boardCode);

	



	

}
