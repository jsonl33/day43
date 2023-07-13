package day43;

class Thread13 implements Runnable{
	@Override
	public void run() {
		while(true) {
			System.out.println(Thread.currentThread().getName());
			try {
				Thread.sleep(1000);
			}catch (InterruptedException ie) {}
		}
	}
}

public class ThreadTest13 {
	public static void main(String[] args) {
		Thread13 th = new Thread13();
		Thread th01 = new Thread(th, "#");
		Thread th02 = new Thread(th, "##");
		Thread th03 = new Thread(th, "###");
		
		th01.start();
		th02.start();
		th03.start();
		
		try {
			Thread.sleep(2000);
			th01.suspend();
			Thread.sleep(2000);
			th02.suspend();
			Thread.sleep(3000);
			th01.resume();
			Thread.sleep(3000);
			th01.stop();
			th02.stop();
			Thread.sleep(2000);
			th03.stop();
		}catch (InterruptedException ie) {
			
		}
	}
}
