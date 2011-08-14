package tw.idv.haocheng.exam1;

import java.util.ArrayList;
import java.util.List;

import tw.idv.haocheng.exam1.utils.Utils;

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
			Double median = Utils
					.findMedian(seq.toArray(new Integer[seq.size()]));
			System.err.println("Thread3 median: " + median);
		}
	}

}
