package edu.kh.project.mypage.model.mapper;

import org.apache.ibatis.annotations.Mapper;

import edu.kh.project.member.model.dto.Member;



@Mapper
public interface MyPageMapper {

	int info(Member updateMember);

	

}
