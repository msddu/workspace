package edu.kh.jdbc.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import edu.kh.jdbc.model.dto.Member;



public class ProjectDAO1 {
	
		PreparedStatement pstmt = null;
	
	
	
		

	public int insertMember(Member member, Connection conn) {
		
		int result = 0;
		
		String sql = "INSERT INTO MEMBER "
				+ "VALUES(SEQ_MEMBER_NO.NEXTVAL, ?, ?, ?, ?, ?, DEFAULT, DEFAULT)";
		
		try {
			
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, member.getMemberEmail());
			pstmt.setString(2, member.getMemberPw());
			pstmt.setString(3, member.getMemberNickname());
			pstmt.setString(4, member.getMemberTel());
			pstmt.setString(5, member.getMemberAddress());
			
			result = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}





	public List<Member> selectMember(int sort, Connection conn) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<Member> memberList =  new ArrayList<Member>();
		
		
		String sql = "SELECT * FROM MEMBER ORDER BY MEMBER_NO";
		
		if(sort == 1) sql += "DESC";
		
		
		try {
			
			
			while(rs.next()){
				
				
				pstmt = conn.prepareStatement(sql);
				
				rs = pstmt.executeQuery();
				
				int memberNo 			= rs.getInt(1); // 컬럼 순서
				String memberEmail 		= rs.getString(2);
				String memberPw 		= rs.getString(3);
				String memberNickname 	= rs.getString(4);
				String memberTel 		= rs.getString(5);
				String memberAddress 	= rs.getString(6);
				
				Date enrollDate 		= rs.getDate(7);
				String memberDelFl 		= rs.getString(8);
				
				
				Member member = new Member(memberNo, 
											memberEmail, 
											memberPw, 
											memberNickname, 
											memberTel, 
											memberAddress, 
											enrollDate.toString(),  
											memberDelFl);
				
				
				
				memberList.add(member);
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			
			close(rs);
			close(pstmt);
			
		}
		
		
		return memberList;
	}

}
