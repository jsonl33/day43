package day43;

class Account06 {
	private int balance = 1000;

	public int getBalance() {
		return balance;
	}

	public void withdraw(int money) {
		if (balance >= money) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ie) {
			}
			balance -= money;
		}
	}
}

class Thread06 implements Runnable {
	Account06 acc = new Account06();

	@Override
	public void run() {
		while (acc.getBalance() > 0) {
			int money = (int) (Math.random() * 3 + 1) * 100;
			acc.withdraw(money);
			System.out.println("계좌잔액="+acc.getBalance());
		}
	}
}

public class ThreadTest06 {
	public static void main(String[] args) {
		Thread06 tr = new Thread06();
		new Thread(tr).start();
		Thread th02 = new Thread(tr);
		th02.start();
	}
}
