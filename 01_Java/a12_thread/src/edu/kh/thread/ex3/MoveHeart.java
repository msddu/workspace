package edu.kh.thread.ex3;


public class MoveHeart implements Runnable{

	@Override
	public void run() {
		try {
			
		
		for(int i = 0; i < 10; i++) {
			
			for(int a = 0; a<30; a++) System.out.println();
			
			//i미만 까지 반복하며 한칸씩 띄우기
			for(int h = 0; h < i; h++) System.out.print(" ");
			System.out.println("♥");
			
			//i미만 까지 반복하며 한칸씩 띄우기
			for(int s = 0; s < i; s++) System.out.print(" ");
			System.out.print("☆");
			
			Thread.sleep(1000); //1초 일시정지
		}
		
		}catch(InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

}
