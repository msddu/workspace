package edu.kh.thread.ex2;

import java.util.Scanner;

public class StopWatchController {

	public void watchStart() {
		Thread stopWatch = new Thread(new StopWatch());
		stopWatch.start();
		System.out.println("엔터 입력시 종료");
		
		Scanner sc = new Scanner(System.in);
	    sc.nextLine(); //엔터 입력 시 까지 무한대기
	    
	    //스톱워치 스레드 멈추게 하기
	    //-> sleep()이용 중이라 예외 발생
	    stopWatch.interrupt();
	}
}
