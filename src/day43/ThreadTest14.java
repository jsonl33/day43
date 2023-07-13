package day43;

import java.util.ArrayList;

class Table14 {
	String[] dishNames = { "donut", "donut", "burger" };
	final int MAX_FOOD = 6;
	private ArrayList<String> dishes = new ArrayList<>();

	public synchronized void add(String dish) {
		if (dishes.size() >= MAX_FOOD) {
			return;
		}
		dishes.add(dish);
		System.out.println("추가된 음식 목록: " + dishes.toString());
	}// add()

	public boolean remove(String dishName) {
		synchronized (this) {
			while (dishes.size() == 0) {
				String name = Thread.currentThread().getName();
				System.out.println(name + " is waiting");
				try {
					Thread.sleep(500);
				} catch (InterruptedException ie) {
				}
			} // while
			for (int i = 0; i < dishes.size(); i++) {
				if (dishName.equals(dishes.get(i))) {
					dishes.remove(i);
					return true;
				} // if
			} // for
		}
		return false;
	}// remove()

	public int dishNum() {
		return dishNames.length;
	}
}

class Custumer14 implements Runnable {
	private Table14 table;
	private String food;

	public Custumer14() {
	}

	public Custumer14(Table14 table, String food) {
		this.table = table;
		this.food = food;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException ie) {
			}
			String name = Thread.currentThread().getName();
		} // while
	}// run()

	boolean eatFood() {
		return table.remove(food);
	}
}

public class ThreadTest14 {
	public static void main(String[] args) {

	}
}
