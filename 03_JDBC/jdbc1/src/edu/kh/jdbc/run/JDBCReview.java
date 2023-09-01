package edu.kh.jdbc.run;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCReview {
	
	public static void main(String[] args) {
		
		
		// 부서명이 총무부
		// 해당 부서에 근무하는 모든 사원의
		// 사번, 이름, 부서명, 직급명을 직급코드 오름차순
		
		
		Connection conn = null; //DB연결 정보 저장한 객체
		Statement stmt = null;  //DB에 SQL수행 - > 결과 반환 받는 객체
		ResultSet rs = null;    //SELECT 결과를 저장하는 객체
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2-2) DB 연결 정보를 이용해서 Connection 객체생성
			String type = "jdbc:oracle:thin:@"; //thin : 드라이버 종류
			String host = "115.90.212.20";	    //DB서버 컴퓨터 IP주소
			String port = ":10000";        		//DB서버 컴퓨터 내에서 DB프로그램 번호
			String dbName = ":ORCL";       		//DB이름
			
			String userName = "a230724_kms_su"; //사용자 계정
			String pw = "kms0909";				
			
			
			
			conn = DriverManager.getConnection(type + host + port + dbName ,userName , pw );
			
			Scanner sc = new Scanner(System.in);
			System.out.print("부서명 입력: " );
			String input = sc.nextLine();
			
			
			//입력 받은 문자열이 저장된 변수를 sql에 추가할 때
			//양쪽에 홑따옴표('') 를 받으시 작성해야 한다.
			String sql = "SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME\r\n"
					+ "FROM EMPLOYEE\r\n"
					+ "JOIN JOB USING(JOB_CODE)\r\n"
					+ "JOIN DEPARTMENT ON(DEPT_CODE  = DEPT_ID)\r\n"
					+ "WHERE DEPT_TITLE = '"+input+"'\r\n"
					+ "ORDER BY JOB_CODE";
			
			stmt = conn.createStatement();
			//연결된 DB와 대화(SQL 수행/ 결과 반환)를 하기 위한 객체 생성
			
			rs = stmt.executeQuery(sql);
			
			
			boolean flag = true; //true이면 조회 결과 없음, false이면 있음
			
			while(rs.next()) {
				
				flag = false;  //while문이 한번이라도 실행되면 false로 변경
				
				String empId = rs.getString("EMP_ID");
				String empName = rs.getString("EMP_NAME");
				String deptTitle = rs.getString("DEPT_TITLE");
				String jobName = rs.getString("JOB_NAME");
				
				System.out.printf("%s / %s /%s / %s\n" ,empId ,empName,deptTitle,jobName);
				
			}
			
			if(flag) { //while문 종료 후에 flag값이 true == 조회결과가 없음
				
				System.out.println("일치하는 부서가 없습니다");
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			
			
			
		}finally {
			try {
				if(rs  != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
				
				
			}catch(Exception e) {
				e.printStackTrace();
				
			}
			
			
			
		}	
			
	
			
		}
		
	}


