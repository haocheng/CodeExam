package tw.idv.haocheng.exam1;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class NumberPool {

	private final BlockingQueue<Integer> forT3;
	private final BlockingQueue<Integer> fromT1ForT4;
	private final BlockingQueue<Integer> fromT2ForT4;
	private final BlockingQueue<Integer> forT5;

	public NumberPool() {
		forT3 = new LinkedBlockingQueue<Integer>();
		fromT1ForT4 = new LinkedBlockingQueue<Integer>(1);
		fromT2ForT4 = new LinkedBlockingQueue<Integer>(1);
		forT5 = new LinkedBlockingQueue<Integer>();
	}

	public void fromThread1(int i) {
		try {
			forT3.put(i);
			fromT1ForT4.put(i);
			forT5.put(i);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	public void fromThread2(int i) {
		try {
			forT3.put(i);
			fromT2ForT4.put(i);
			forT5.put(i);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	public int forThread3() {
		try {
			return forT3.take();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	public Pair forThread4() {
		try {
			return new Pair(fromT1ForT4.take(), fromT2ForT4.take());
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	public int forThread5() {
		try {
			return forT5.take();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
}
