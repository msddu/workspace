package edu.kh.jdbc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static edu.kh.jdbc.common.JDBCTemplate.*;
import edu.kh.jdbc.model.dto.Member;

//DAO(Data(Database) Access Object) : 데이버베이스 접근 객체
//-JDBC를 이용해서 DB에 SQL을 전달하여 수행 후 결과를 반환 받는 역할
public class MemberDao {
	
	//필드
	
	//JDBC객체 참조 변수를 선언(Connection은 Service에서 생성하기 때문에 제외)
	private Statement stmt = null;
	private ResultSet rs = null;
	
	//PreparedStatement(준비된 Statement)
	//-외부 변수 값을 SQL에 받아드릴(삽입할)준비가 되어있는 Statement
	//->성능, 속도면에서 우위를 가지고 있음
	
	//-?(placeholder) : 변수를 위치시킬 자리 지정
	private PreparedStatement pstmt = null;
	
	/**회원 가입
	 * @param conn
	 * @param member
	 * @return
	 */
	public int insertMember(Connection conn, Member member) {
		
		// 1. JDBC 객체 참조 변수 선언 -> 필드에 작성 완료
	    // 2. DriverManager를 이용해 Connection 객체 생성
	    //      -> Service에서 만들어서 전달 받음
		
		//-------------------------------------------------------
		//DAO 작성법
		//1. 최종 결과를 저장할 변수 선언 또는 객체생성
		int result = 0;
		
		
		//2.SQL작성
		
		// 1) Statement를 이용해서 수행할 SQL작성법 --> 작성이 어려움
		//   -->Statement의 자식인 PreparedStatement 사용
	
//		String sql = "INSERT INTO MEMBER \r\n"
//				+ "VALUES(SEQ_MEMBER_NO.NEXTVAL,\r\n"
//				+ "'"+member.getMemberEmail()+"', \r\n"
//				+ "'"+member.getMemberPw()+"' , \r\n"
//				+ "'"+member.getMemberNickname()+"', \r\n"
//				+ "'"+member.getMemberTel()+"', \r\n"
//				+ "'"+member.getMemberAdress()+"' , \r\n"
//				+ "DEFAULT, \r\n"
//				+ "DEFAULT)";
		
		// 2) PreparedStatement용 SQL작성
		String sql = "INSERT INTO MEMBER "
				+ "VALUES(SEQ_MEMBER_NO.NEXTVAL, ?, ?, ?, ?, ?, DEFAULT, DEFAULT)" ;
												//-?(placeholder) : 변수를 위치시킬 자리 지정
		
		try {
			
			// 3.PreparedStatement 객체 생성
			//  (Statement와 다르게 생성 시 sql을 매개변수로 사용)
			//  ->SQL을 생성할 때 전달하여 ?에 값 대입을 준비함
			pstmt = conn.prepareStatement(sql);
			
			
			//4. ?(placeholder)에 알맞은 값 대입
			//작성법: pstmt.set자료형(순서,값);
		
			//pstmt.setString()으로 문자열을 SQL에 대입하면
			//자동으로 양쪽에 ''(홑따옴표) 추가해준다(굉장히 편함)
			pstmt.setString(1,member.getMemberEmail());
			pstmt.setString(2,member.getMemberPw());
			pstmt.setString(3,member.getMemberNickname());
			pstmt.setString(4,member.getMemberTel());
			pstmt.setString(5,member.getMemberAdress());
			
			
			//5. SQL 수행(INSERT) 후 결과 반환(결과 행의 수) 받기
			result = pstmt.executeUpdate(); //매개변수에 SQL추가 X  -> 이미 pstmt 생성할 때 추가했기 때문에
									
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			//6.사용한 JDBC객체 자원을 반환
			//PreparedStatement는 Statement의 자식
			close(pstmt);
			
		}
		
		return result;
	}

	/**회원 정보 수정
	 * @param conn
	 * @param member
	 * @return
	 */
	public int updateMember(Connection conn, Member member) {
		
		//1. 최종 결과를 저장할 변수 선언 또는 객체생성
		int result = 0;
		
		
		//2.SQL작성
		
		String sql = "UPDATE MEMBER \r\n"
				+ "SET MEMBER_NICKNAME = ?,   "
				+ "MEMBER_TEL  = ?,    "
				+ "MEMBER_ADDRESS = ?\r\n"
				+ "WHERE MEMBER_EMAIL  =  ?\r\n"
				+ "AND MEMBER_PW = ?   ";
		
		try {
		
			// 3.PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			//->세팅된 sql의 ? 자리에 값 대입 준비
			
			
			//4. ?(placeholder)에 알맞은 값 대입	
			pstmt.setString(1,member.getMemberNickname());
			pstmt.setString(2,member.getMemberTel());
			pstmt.setString(3,member.getMemberAdress());
			pstmt.setString(4,member.getMemberEmail());
			pstmt.setString(5,member.getMemberPw());
			
			
			//5. SQL 수행(UPDATE) 후 결과 반환(결과 행의 수) 받기
			//   ->DML 수행 결놔는 결과 행의 개수(int)
			result = pstmt.executeUpdate();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//6.사용한 JDBC객체 자원을 반환
			//PreparedStatement는 Statement의 자식
			try {
				//conn은 Service에서 close처리!
				close(pstmt);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		//7.SQL결과 반환
		return result;
	}

	/**회원 탈퇴
	 * @param conn
	 * @param member
	 * @return
	 */
	public int deletMember(Connection conn, Member member) {
		//1. 최종 결과를 저장할 변수 선언 또는 객체생성
		int result = 0;
		
		
		//2.SQL작성
			
		String sql = "DELETE FROM MEMBER\r\n"
				+ "WHERE MEMBER_EMAIL  =  ?\r\n"
				+ "AND MEMBER_PW = ?";
			
		
		try {
			// 3.PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			
			
			//4. ?에 알맞는 값 세팅
			pstmt.setString(1,member.getMemberEmail());
			pstmt.setString(2,member.getMemberPw());
			
			//5.SQL(DELETE) 수행 결과 반환(성공한 행의 개수) 받기
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}finally {
			try {
				// 6.JDBC객체 자원 반환
				close(pstmt);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
	
		return result;
	}

	public int updatePwMember(Connection conn, Member member) {
		
		//1. 최종 결과를 저장할 변수 선언 또는 객체생성
		int result = 0;
		
		//2 SQL문 작성
	
		String sql = "UPDATE MEMBER \r\n"
				+ "SET MEMBER_PW  = ?\r\n"
				+ "WHERE MEMBER_EMAIL = ? AND MEMBER_PW = ?";
		
		
		try {
			// 3.PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			
			//4. ?에 알맞는 값 세팅
			pstmt.setString(1,member.getMemberNPw());
			pstmt.setString(2,member.getMemberEmail());
			pstmt.setString(3,member.getMemberPw());
			
			//5.SQL(DELETE) 수행 결과 반환(성공한 행의 개수) 받기
			result = pstmt.executeUpdate();
		
			
			
			
			
		}catch(Exception e) {
			
			e.printStackTrace();
		}finally {
			
			try {
				close(pstmt);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		
		
		return result;
	}

	public int insertMember2(Connection conn, Member member) {
		
		int result = 0; //최종 결과값 저장
		
		
		String sql = "INSERT INTO MEMBER "
				+ "VALUES(SEQ_MEMBER_NO.NEXTVAL, ?, ?, ?, ?, ?, DEFAULT, DEFAULT)" ; 
		
		
		
		try {
			
			
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			
		}
		
		return result;
	}

	public int updateDelFl(Connection conn, Member member) {
		
		int result = 0;
		
		
		String sql = "DELETE FROM MEMBERS \n"
				+ "WHERE MEMBER_PWD = ?";
		
		
		try {
			
			
			stmt = conn.prepareStatement(sql);
			
			
			
			
			
			
			
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}finally {
			
			try {
				
				close(pstmt);
				
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			
		}
		
		
		
		
		
		return 0;
	}

public int updateMember2(Connection conn, String nickname, String tel, int memberNo) {
		
		int result = 0;
		
		String sql = "UPDATE MEMBER SET \r\n"
				+ "MEMBER_NICKNAME = ? ,\r\n"
				+ "MEMBER_TEL = ? \r\n"
				+ "WHERE MEMBER_NO = ? ";
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, nickname);
			pstmt.setString(2, tel);
			pstmt.setInt(3, memberNo);
			
			// executeUpdate() : DML
			// executeQuery() : SELECT
			result = pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

public int insertBoard(Connection conn, String title, String content, int memberNo) {
	
	int result = 0;
		
	String sql = "";
	
	
	try {
		
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		try {

		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, title);
		pstmt.setString(2, content);
		pstmt.setInt(1, memberNo);
		
		
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	return result;
}

public Member login(Connection conn, String email, String pw) {
		
		// 1. 결과 저장용 변수 선언
		Member member = null;
		
		// 2. SQL 작성
		String sql = "SELECT MEMBER_NO, MEMBER_NICKNAME, MEMBER_TEL, MEMBER_ADDRESS,\r\n"
				+ "	TO_CHAR(ENROLL_DATE, 'YYYY\"년\" MM\"월\" DD\"일\" HH24:MI:SS') ENROLL_DATE\r\n"
				+ "FROM MEMBER\r\n"
				+ "WHERE MEMBER_EMAIL = ? \r\n"
				+ "AND MEMBER_PW = ? \r\n"
				+ "AND MEMBER_DEL_FL = 'N'";
		
		try {
			// 3. PreparedStatment 생성
			pstmt = conn.prepareStatement(sql);
			
			// 4. ?에 값 대입
			pstmt.setString(1, email);
			pstmt.setString(2, pw);
			
			// 5. SQL(SELECT) 수행 후 결과(ResultSet) 반환 받기
			// SELECT -> executeQuery
			// DML    -> executeUpdate
			rs = pstmt.executeQuery();
			
			// 6. ResultSet에 조회된 다음 행이 있는지 확인
			// -> 아이디, 비밀번호가 일치하는 경우는 1행 밖에 없으므로
			// while(조건식) 대신 if(조건식) 사용 가능
			
//			while(rs.next()) {
			if(rs.next()) { // 결과가 있을 때 무조건 1행이면 if 사용 권고
				
				// 7. 조회 결과가 있을 경우 컬럼 값을 모두 얻어오기
				int memberNo = rs.getInt("MEMBER_NO");
				
				String memberNickname = rs.getString("MEMBER_NICKNAME");
				
				String memberTel = rs.getString("MEMBER_TEL");
				
				String memberAddress = rs.getString("MEMBER_ADDRESS");
				
				String enrollDate = rs.getString("ENROLL_DATE");
				
				// + 매개 변수 email
				
				
				// 8. Member 객체를 생성하여 얻어온 값을 모두 세팅
				member = new Member(); 
				// 결과 저장용 변수가 Member 객체를 참조
				// == null 아님
				
				member.setMemberEmail(email);
				member.setMemberNo(memberNo);
				member.setMemberNickname(memberNickname);
				member.setMemberTel(memberTel);
				member.setMemberAdress(memberAddress);
				member.setEnrollDate(enrollDate);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 9. 사용한 JDBC 객체 반환(역순)
			close(rs);
			close(pstmt);
		}
		
		// member == null -> 로그인 실패
		// member != null -> 로그인 성공
		return member;
}

}
