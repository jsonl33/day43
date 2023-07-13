package day43;

import javax.swing.JOptionPane;

class CityNameInput {
	String cityName;

	public CityNameInput() {
	}

	public CityNameInput(String cityName) {
		this.cityName = cityName;
	}

	public String getCityName() {
		return cityName;
	}

	void printName(String cityName) {
		System.out.println("도시 이름: " + cityName);
	}
}

class CountThread extends Thread {
	CityNameInput cni;

	public CountThread(CityNameInput cni) {
		this.cni = cni;
	}

	@Override
	public void run() {
		for (int i = 10; i >= 1; i--) {
			try {
				sleep(500);
			} catch (InterruptedException e) {
			}
			cni.printName(cni.getCityName());
			System.out.println(i);
		}
	}
}

public class Thread10 {
	public static void main(String[] args) {
		String cityName = JOptionPane.showInputDialog("도시 이름을 입력하세요");
		CityNameInput cni = new CityNameInput(cityName);
		CountThread ct = new CountThread(cni);
		ct.run();
	}
}
