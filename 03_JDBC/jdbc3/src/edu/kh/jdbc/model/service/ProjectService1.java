package edu.kh.jdbc.model.service;

import edu.kh.jdbc.model.dao.ProjectDAO1;
import edu.kh.jdbc.model.dto.Member;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;



public class ProjectService1 {
	
	private ProjectDAO1 dao1 = new ProjectDAO1();

	public int insertMember(Member member) {
		
		Connection conn = getConnection();
		
		int result = dao1.insertMember(member,conn);
		
		if(result > 0)   commit(conn);
		else			rollback(conn);
		
		
		close(conn);
		
		
		return result;
	}

	public List<Member> selectMember(int sort) {
		
		
			Connection conn = getConnection();
			
			List<Member> memberList = dao1.selectMember(sort,conn);
			
			close(conn);
		
		return memberList;
	}

}
