package edu.kh.jdbc.run;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class JDBCExample3 {
	
	public static void main(String[] args) {
		
		//입력 받은 최소급여 보다 많이 받고(이상)
		//입력 받은 최고 급여보단 적게 받는(이하)
		//사원의 사번, 이름, 급여를 급여 내림차순 조회
		
		
		//[실행화면]
		//최소급여 : 1000000
		//최대급여 : 3000000
		
		//사번 / 이름/ 급여
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String type = "jdbc:oracle:thin:@"; //thin : 드라이버 종류
			String host = "115.90.212.20";	    //DB서버 컴퓨터 IP주소
			String port = ":10000";        		//DB서버 컴퓨터 내에서 DB프로그램 번호
			String dbName = ":ORCL";       		//DB이름
			
			String userName = "a230724_kms_su"; //사용자 계정
			String pw = "kms0909";		
			
			
			conn = DriverManager.getConnection(type + host + port + dbName ,userName , pw );
			
			Scanner sc = new Scanner(System.in);
			
			System.out.print("최소급여: ");
			int input1 = sc.nextInt();
			
			System.out.print("최대급여: ");
			int input2 = sc.nextInt();
			
			
			
			String sql = "SELECT EMP_ID, EMP_NAME, SALARY "
						+ "FROM EMPLOYEE "
						+ "WHERE SALARY >= "+input1+" AND SALARY <= "+input2+" ORDER BY SALARY DESC";
			
			
			
			
			stmt = conn.createStatement();
			
			rs =  stmt.executeQuery(sql);
			
			
			
			while(rs.next()) {
				
				String empId = rs.getString("EMP_ID");
				String empName = rs.getString("EMP_NAME");
				int salary = rs.getInt("SALARY");
				
				
				System.out.printf("사번 : %s / 이름 : %s / 급여 : %d\n" , empId, empName, salary);
				
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			
			
		}finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			
			
		}
		
		
		
		
	}

}
