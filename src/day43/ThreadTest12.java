package day43;

import javax.swing.JOptionPane;

class Thread12 extends Thread {

	@Override
	public void run() {
		int i = 10;
		while(i != 0 && !isInterrupted()) {
			System.out.println(i--);
			try {
				Thread.sleep(1000);
			}catch (InterruptedException ie) {
				interrupt();
			}
		}
		System.out.println("카운터 종료");
	}
}

public class ThreadTest12 {
	public static void main(String[] args) {
		Thread12 th = new Thread12();
		th.start();
		
		String name = JOptionPane.showInputDialog("이름을 입력하세요");
		System.out.println("입력하신 이름: "+name);
		th.interrupt();
		System.out.println("인터럽트 된 상태: "+th.isInterrupted());
	}
}
