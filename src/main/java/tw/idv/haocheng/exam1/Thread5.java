package tw.idv.haocheng.exam1;

public class Thread5 implements Runnable {

	private int sum;

	private final NumberPool pool;

	public Thread5(NumberPool pool) {
		this.pool = pool;
		this.sum = 0;
	}

	@Override
	public void run() {
		while (true) {
			int number = pool.forThread5();
			sum += number;
			if (sum > 200) {
				System.err.println("Thread5 sum: " + sum);
				System.err.println("Thread5: Jackpot!");
				sum = 0;
			}
		}
	}

}
