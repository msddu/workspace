package edu.kh.project.memberpr.model.mapper;

import org.apache.ibatis.annotations.Mapper;

import edu.kh.project.member.model.dto.Member;

@Mapper
public interface MemberPrMapper {

	Member login(Member inputMember);
	

}
