package tw.idv.haocheng.exam1;

import java.util.concurrent.BlockingQueue;

public class Thread4 implements Runnable {

	private BlockingQueue<Integer> queue1;

	private BlockingQueue<Integer> queue2;

	public Thread4(BlockingQueue<Integer> queue1, BlockingQueue<Integer> queue2) {
		this.queue1 = queue1;
		this.queue2 = queue2;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Pair pair = new Pair(queue1.take(), queue2.take());
				String romanNumeral = convertToRomanNumeral(pair);
				System.err.println("Thread4 Sum of numbers: " + pair.getSum());
				System.err.println("Thread4 Roman Numeral: " + romanNumeral);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

	private static final String[] RCODE = { "M", "CM", "D", "CD", "C", "XC",
			"L", "XL", "X", "IX", "V", "IV", "I" };
	private static final int[] BVAL = { 1000, 900, 500, 400, 100, 90, 50, 40,
			10, 9, 5, 4, 1 };

	synchronized private String convertToRomanNumeral(Pair pair) {
		int binary = pair.getSum();

		// ===========================================================
		// binaryToRoman
		if (binary <= 0 || binary >= 4000) {
			throw new NumberFormatException(
					"Value outside roman numeral range.");
		}
		String roman = ""; // Roman notation will be accumualated here.

		// Loop from biggest value to smallest, successively subtracting,
		// from the binary value while adding to the roman representation.
		for (int i = 0; i < RCODE.length; i++) {
			while (binary >= BVAL[i]) {
				binary -= BVAL[i];
				roman += RCODE[i];
			}
		}
		return roman;
	}

	private static class Pair {
		Integer fromT1;

		Integer fromT2;

		public Pair(Integer fromT1, Integer fromT2) {
			this.fromT1 = fromT1;
			this.fromT2 = fromT2;
		}

		int getSum() {
			return fromT1.intValue() + fromT2.intValue();
		}

	}

}
