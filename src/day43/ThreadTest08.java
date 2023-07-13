package day43;

class Atm {
	private int money;

	public Atm() {
	}

	public Atm(int money) {
		this.money = money;
	}

	synchronized void deposit(int amount, String name) {
		money += amount;
		System.out.println(name + " 입금금액= " + amount);
	}

	synchronized void withdraw(int amount, String name) {
		if ((money - amount) > 0) {
			money -= amount;
			System.out.println(name + " 출금금액= " + amount);
		} else {
			System.out.println(name + " 잔액부족으로 출금못함");
		}
	}

	public void getMoney() {
		System.out.println("계좌 잔액=" + money);
	}
}

class AtmUser extends Thread {
	boolean flag = false;
	Atm obj;
	
	public AtmUser() {}

	public AtmUser(Atm obj, String name) {
		super(name);
		this.obj = obj;
	}
	
	@Override
	public void run() {
		for(int i = 1;i<=5;i++) {
			try {
				sleep(500);
			}catch(InterruptedException ie) {
			}
			if(flag) {
				obj.deposit((int)(Math.random()*10+2)*100, getName());
				obj.getMoney();
			}
			else {
				obj.withdraw((int)(Math.random()*10+2)*100, getName());
				obj.getMoney();
			}
			flag = !flag;
		}
	}

}

public class ThreadTest08 {
	public static void main(String[] args) {
		Atm obj = new Atm(1000);
		AtmUser user01 = new AtmUser(obj, "홍길동");
		AtmUser user02 = new AtmUser(obj, "이순신");
		AtmUser user03 = new AtmUser(obj, "강감찬");
		
		user01.start();
		user02.start();
		user03.start();
	}

}
