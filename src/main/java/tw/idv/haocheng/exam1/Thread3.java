package tw.idv.haocheng.exam1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public class Thread3 implements Runnable {

	private BlockingQueue<Integer> queue1;

	private BlockingQueue<Integer> queue2;

	private List<Integer> numbers;

	public Thread3(BlockingQueue<Integer> queue1,
			BlockingQueue<Integer> queue2, List<Integer> numbers) {
		this.queue1 = queue1;
		this.queue2 = queue2;
		this.numbers = numbers;
	}

	@Override
	public void run() {
		while (true) {
			try {
				numbers.add(queue1.take());
				numbers.add(queue2.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			Integer median = findMedian(numbers);
			System.err.println("Thread3 median: " + median);
		}
	}

	private Integer findMedian(List<Integer> numbers) {
		Collections.sort(numbers);
		System.err.println("numbers: " + Arrays.toString(numbers.toArray()));

		int size = numbers.size();

		if (size % 2 == 1) {
			return numbers.get((int) Math.floor(size / 2));
		} else {
			Integer lowerMiddle = numbers.get(size / 2);
			Integer upperMiddle = numbers.get(size / 2 - 1);
			return (lowerMiddle + upperMiddle) / 2;
		}
	}

}
