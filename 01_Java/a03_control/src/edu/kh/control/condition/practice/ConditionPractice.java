package edu.kh.control.condition.practice;

import java.util.Scanner;

public class ConditionPractice {
	
	//실습문제 1
	public void practice1() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자를 한개 입력하세요:");
		int num = sc.nextInt();
		
		if(num > 0 && num % 2 == 0  ) {
			System.out.println("짝수입니다");
		}else if(num > 0 && num % 2 != 0  ) { 
				System.out.println("홀수입니다");
		}else 
			System.out.println("양수만 입력해주세요");
	}
			
		
		
			
		
		
		
		
		
		
		
		
		
		

	
	public void practice2() {
		
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.print("국어점수:");
		int su1 = sc.nextInt();
		System.out.print("수학점수:");
		int su2 = sc.nextInt();
		System.out.print("영어점수:");
		int su3 = sc.nextInt();
		
		int sum = su1 + su2 + su3; 
		
		double avg = sum/3.0;
		
		if(su1 >= 40 && su2 >= 40 && su3 >= 40 && avg >= 60){
			System.out.printf("국어: %d\n", su1);
			System.out.printf("수학: %d\n", su2);
			System.out.printf("국어: %d\n", su3);
			System.out.printf("합계: %d\n", sum);
			System.out.printf("평균: %.1f\n", avg);
			System.out.printf("축하합니다. 합격입니다.");
		}else {
			System.out.println("불합격입니다.");
		}

		
		
		
		
		
		
		
	}
	public void practice3() {
		

		Scanner sc = new Scanner(System.in);
		
		System.out.print("1~12사이의 정수 입력:");
		int month = sc.nextInt();
		
	    
		int day = 0;//해당하는 달의 마지막 일(날짜)을 저장
		            //단, 1~12월이 아니면 0을 저장
		switch(month) {
		case 1 : case 3: case 5: case 7: case 8: case 10: case 12: 
			day = 31; break;
		case 4: case 6: case 9: case 11 :
			day = 30; break;
		case 2:
			day = 28; break;
	}
		if(day == 0) { //1~12사이가 입력되지 않았을때
			System.out.printf("%d월은 잘못 입력된 날입니다.", month);
		}else {
			System.out.printf("%d월은 %d일까지 있습니다", month, day);
		}
	    
	}

	    

	 
	public void practice4() {
		
		
	Scanner sc = new Scanner(System.in);
		
	  
	

		System.out.print("키(m)을 입력하세요:");
		double K = sc.nextDouble();
		System.out.print("몸무게(kg)을 입력하세요:");
		double M = sc.nextDouble();
	    
		double B = M / (K * K);
		
		if(B < 18.5) {
			System.out.println("저체중");
		
		}else if(B >= 18.5 && B < 23) {
			System.out.println("정상체중");
	
		}
		else if(B >= 23 && B < 25) {
			System.out.println("과체중");
		}
		else if(B >= 25 && B < 30) {
			System.out.println("비만");
		}
		else if(B > 30) {
			System.out.println("고도비만");
		}
		System.out.printf("bmi지수 : %f", B);
		
		
		}
		
	

		
    
		
		
		
		
	
	public void practice5() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("중간 고사 점수 : ");
		int midTerm = sc.nextInt();
		
		System.out.print("기말 고사 점수 : ");
		int finalTerm = sc.nextInt();
		
		System.out.print("과제  점수 : ");
		int homework = sc.nextInt();
		
		System.out.print("출석 횟수 : ");
		int attendance = sc.nextInt();

		System.out.println("================= 결과 =================");
		
		// 출석 횟수가 부족한 경우 (14회 이하)
		if(attendance <= 20 * (1 - 0.3)) {
			System.out.printf("Fail [출석 횟수 부족 (%d/20)]", attendance);
		
		} else { // 출석은 잘했을 때
			
			// 점수 환산
			double midScore = midTerm * 0.2;
			double finalScore = finalTerm * 0.3;
			double homeworkScore = homework * 0.3;
			double attScore = attendance * 5 * 0.2; // == attendance
			
			// 총점
			double sum = midScore + finalScore + homeworkScore + attScore;
			
			System.out.println("중간 고사 점수(20) : " + midScore);
			System.out.println("기말 고사 점수(30) : " + finalScore);
			System.out.println("과제 점수     (30) : " + homeworkScore);
			System.out.println("출석 점수     (20) : " + attScore);
			System.out.println("총점 : " + sum);
			
			if(sum >= 70) {
				System.out.println("PASS");
			}else {
				System.out.println("Fail [점수 미달]");
		
		}
		
		
	
		}
	}
}

		
		
		
		
		

	


