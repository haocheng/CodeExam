package tw.idv.haocheng.exam1;

import tw.idv.haocheng.exam1.utils.Utils;

public class Thread4 implements Runnable {

	private final NumberPool pool;

	public Thread4(NumberPool pool) {
		this.pool = pool;
	}

	@Override
	public void run() {
		while (true) {
			Pair pair = pool.forThread4();
			String romanNumeral = Utils.convertToRomanNumeral(pair);

			System.err.println("Thread4 value of numbers: " + pair.getSum());
			System.err.println("Thread4 Roman Numeral: " + romanNumeral);
		}
	}

}
