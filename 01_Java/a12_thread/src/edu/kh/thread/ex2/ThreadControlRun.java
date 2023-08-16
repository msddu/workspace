package edu.kh.thread.ex2;

import edu.kh.thread.MyClock;

public class ThreadControlRun {
	
	public static void main(String[] args) {
		
		Thread sleepTest = new Thread(new SleepThread1());
	//	sleepTest.start();
		
	
		Thread clockThread = new Thread(new MyClock());
	//	clockThread.start();
		
		
		
		//인터럽트 확인하기
		
		InterruptTset it = new InterruptTset();
	//	it.test();
		
		
		//스톱워치
		StopWatchController controller = new StopWatchController();
		controller.watchStart();
		
		
	}
	
	

}
