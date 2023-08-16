package edu.kh.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		List<IPInfo> ipInfoList = new ArrayList<IPInfo>();
		
		ipInfoList.add(new IPInfo("123.123.123.123", "홍길동"));
		ipInfoList.add(new IPInfo("123.123.123.123", "아무이름"));
		ipInfoList.add(new IPInfo("633.132.123.111", "고길수"));
		
		System.out.print("ip입력: ");
		String ip = sc.next();
		
		for(int i = 0; i<ipInfoList.size(); i++) {
			if(ipInfoList.get(i).getIp() .equals(ip)) {
				System.out.println(ipInfoList.get(i));
				return;
			}
		}
		System.out.println("일치하는 ip가 없습니다.");
			
			
	}

}
