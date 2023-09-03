package edu.kh.jdbc.model.service;

import java.sql.Connection;

//import static : 지정된 static 필드/메서드를 가져와서
//                해당 클래스 것 처럼 사용 가능하게 함
//  			  -->앞에 클래스명을 생략 가능
//                JDBCTemlpate.getConnection() == getConnection()
import static edu.kh.jdbc.common.JDBCTemplate.*;


import edu.kh.jdbc.model.dao.MemberDao;
import edu.kh.jdbc.model.dto.Member;

//Service : 비즈니스 로직
//-요청에 따른 필요 데이터를 반환
//+DB연결 코드인 DAO를 호출
//+트랜잭션 제어(commit, rollback)
//  -->commit, rollback을 하려면 Connection이 필요하기 때문에
//     Service에서 Connection을 생성/닫기
public class MemberService {
	
	//필드
	private MemberDao dao = new MemberDao();
	

	/**회원 가입 서비스
	 * @param member
	 * @return 
	 */
	public int insertMember(Member member) {
		
		// 1. 커넥션 생성(JDBCTemplate이용)
		Connection conn = getConnection();
		
		// 2.DAO 메서드 호출(커텍션, 매개변수 전달)
		//-> insert 성공한 행의 개수 반환
		int result = dao.insertMember(conn, member);
		
		
		//3.성공 여부에 따른 트랜잭션 제어
		if(result > 0) commit(conn);   //insert성공
		else           rollback(conn); //insert실패
		
		
		//4.사용 완료된 커넥션 반환(close)
		close(conn);
		
		
		//5.SQL수행 결과를 view로 반환
		return result;
	}


	/**회원 정보 수정 서비스
	 * @param member
	 * @return
	 */
	public int updateMember(Member member) {
		
		// 1. 커넥션 생성(JDBCTemplate이용)
		Connection conn = getConnection();
		
		
		// 2.DAO 메서드 호출(커텍션, 매개변수 전달)
				//-> update 성공한 행의 개수 반환
		
		int result = dao.updateMember(conn, member);
		
		//3.성공 여부에 따른 트랜잭션 제어
		// 성공: 1 , 실패 : 0
		if(result > 0) commit(conn);
		else  	       rollback(conn);
		
		
		//4.사용 완료된 커넥션 반환(close)
		close(conn);
		
		
		
		//5.SQL수행 결과를 view로 반환
		return result;
	}


	public int deleteMember(Member member) {
		
		// 1. 커넥션 생성(JDBCTemplate이용)
		Connection conn = getConnection();
		
		// 2.DAO 메서드 호출(커텍션, 매개변수 전달)
		//-> update 성공한 행의 개수 반환
		int result = dao.deletMember(conn,member);
		
		
		//3.성공 여부에 따른 트랜잭션 제어
		// 성공: 1 , 실패 : 0
		if(result > 0) commit(conn);
		else		   rollback(conn);
		
		
		//4.사용 완료된 커넥션 반환(close)
		close(conn);
		
		
		//5.SQL수행 결과를 view로 반환
		return result;
	}


	public int updatePw(Member member) {
		
		// 1. 커넥션 생성(JDBCTemplate이용)
		Connection conn = getConnection();
		
		// 2.DAO 메서드 호출(커텍션, 매개변수 전달)
		int result = dao.updatePwMember(conn,member);
		
		//3.성공 여부에 따른 트랜잭션 제어
				// 성공: 1 , 실패 : 0
		
		if(result > 0) commit(conn);
		else			rollback(conn);
		
		//4.사용 완료된 커넥션 반환(close)
		close(conn);
		
		//5.SQL수행 결과를 view로 반환
		return result;
	}


	public int insertMember2(Member member) {
		
		//JDBCTemplate를 이용해서 커넥션 생
		Connection conn = getConnection();
		
		//DAO메서드 호출(커넥션,매개변수 전달)
		int result = dao.insertMember2(conn,member);
		
		if(result > 0) commit(conn);
		else           rollback(conn);
		
		close(conn);
		
		
		
		return result;
	}

}
