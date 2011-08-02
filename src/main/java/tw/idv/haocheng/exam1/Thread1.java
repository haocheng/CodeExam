package tw.idv.haocheng.exam1;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Thread1 implements Runnable {

	private BlockingQueue<Integer> queue;

	public Thread1(BlockingQueue<Integer> queue) {
		this.queue = queue;
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
				queue.put(nextInt);
				TimeUnit.MILLISECONDS.sleep(interval);
				System.err.println("Thread1 sleep " + interval + "ms");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
