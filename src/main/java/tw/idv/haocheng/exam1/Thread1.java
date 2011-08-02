package tw.idv.haocheng.exam1;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Thread1 implements Runnable {

	private final NumberPool pool;

	public Thread1(NumberPool pool) {
		this.pool = pool;
	}

	@Override
	public void run() {
		while (true) {
			Random random = new Random();
			int nextInt = random.nextInt(30);
			while (nextInt % 2 != 0) {
				nextInt = random.nextInt(30);
			}

			System.err.println("Thread1: " + nextInt);
			int interval = random.nextInt(500);
			try {
				pool.fromThread1(nextInt);
				TimeUnit.MILLISECONDS.sleep(interval);
				System.err.println("Thread1 sleep " + interval + "ms");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
