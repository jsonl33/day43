package day43;

import javax.swing.JOptionPane;

public class ThreadTest09 {
	public static void main(String[] args) {
		String inputName = JOptionPane.showInputDialog("이름을 입력하세요");
		System.out.println("입력하신 이름: " + inputName);

		for (int i = 10; i >= 1; i--) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ie) {
			}
		}
	}
}
