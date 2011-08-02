package tw.idv.haocheng.exam1;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Thread2 implements Runnable {

	private BlockingQueue<Integer> queue;

	public Thread2(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		while (true) {
			Random random = new Random();
			int nextInt = random.nextInt(30);
			while (!isPrime(nextInt)) {
				nextInt = random.nextInt(30);
			}

			System.err.println("Thread2: " + nextInt);
			int interval = random.nextInt(500);
			try {
				queue.put(nextInt);
				TimeUnit.MILLISECONDS.sleep(interval);
				System.err.println("Thread2 sleep " + interval + "ms");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	synchronized private boolean isPrime(int n) {
		if (n < 2)
			return false;
		if (n == 2 || n == 3)
			return true;
		if (n % 2 == 0 || n % 3 == 0)
			return false;
		long sqrtN = (long) Math.sqrt(n) + 1;
		for (long i = 6L; i <= sqrtN; i += 6) {
			if (n % (i - 1) == 0 || n % (i + 1) == 0)
				return false;
		}
		return true;
	}

}
