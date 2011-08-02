package tw.idv.haocheng.exam1;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Thread2 implements Runnable {

	private final NumberPool pool;

	public Thread2(NumberPool pool) {
		this.pool = pool;
	}

	@Override
	public void run() {
		while (true) {
			Random random = new Random();
			int nextInt = random.nextInt(30);
			while (!Utils.isPrime(nextInt)) {
				nextInt = random.nextInt(30);
			}

			System.err.println("Thread2: " + nextInt);
			int interval = random.nextInt(500);
			try {
				pool.fromThread2(nextInt);
				TimeUnit.MILLISECONDS.sleep(interval);
				System.err.println("Thread2 sleep " + interval + "ms");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
