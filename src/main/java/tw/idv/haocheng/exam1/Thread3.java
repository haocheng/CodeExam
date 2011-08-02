package tw.idv.haocheng.exam1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Thread3 implements Runnable {

	private final List<Integer> seq;

	private final NumberPool pool;

	public Thread3(NumberPool pool) {
		this.pool = pool;
		this.seq = new ArrayList<Integer>();
	}

	@Override
	public void run() {
		while (true) {
			int sum = pool.forThread3();
			seq.add(sum);
			Double median = findMedian(seq);
			System.err.println("Thread3 median: " + median);
		}
	}

	private Double findMedian(List<Integer> numbers) {
		Collections.sort(numbers);
		System.err.println("Thread3 numbers: " + Arrays.toString(numbers.toArray()));

		int size = numbers.size();

		if (size % 2 == 1) {
			return Double.valueOf(numbers.get((int) Math.floor(size / 2)));
		} else {
			Double lowerMiddle = Double.valueOf(numbers.get(size / 2));
			Double upperMiddle = Double.valueOf(numbers.get(size / 2 - 1));
			return (lowerMiddle + upperMiddle) / 2;
		}
	}

}
