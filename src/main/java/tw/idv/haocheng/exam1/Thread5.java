package tw.idv.haocheng.exam1;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Thread5 implements Runnable {

	private AtomicInteger sum;

	private BlockingQueue<Integer> queue1;

	private BlockingQueue<Integer> queue2;

	public Thread5(BlockingQueue<Integer> queue1, BlockingQueue<Integer> queue2) {
		this.queue1 = queue1;
		this.queue2 = queue2;
		this.sum = new AtomicInteger(0);
	}

	@Override
	public void run() {
		while (true) {
			try {
				sum.addAndGet(queue1.take());
				sum.addAndGet(queue2.take());
				
				if (sum.get() > 200) {
					System.err.println("JackPot!!!");
					sum = new AtomicInteger(0);
				}

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

}
