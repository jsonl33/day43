package day43;

import javax.swing.JOptionPane;

class Thread11 extends Thread{

	@Override
	public void run() {
		int i = 10;
		
		while(i != 0 && !isInterrupted()) {
			System.out.println(i--);
			for(long x = 0;x<2500000000L;x++);
			System.out.println("카운터 종료");
		}
	}
	
}

public class ThreadTest11 {
	public static void main(String[] args) {
		Thread11 th = new Thread11();
		th.start();
		
		String name = JOptionPane.showInputDialog("이름 입력");
		System.out.println("입력하신 이름: "+name);
		
		th.interrupt();
		System.out.println("isInterrupt() 된 상태 "+th.isInterrupted());
	}
}
