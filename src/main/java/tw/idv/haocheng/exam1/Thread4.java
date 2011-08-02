package tw.idv.haocheng.exam1;


public class Thread4 implements Runnable {

	private final NumberPool pool;

	public Thread4(NumberPool pool) {
		this.pool = pool;
	}

	@Override
	public void run() {
		while (true) {
			Pair pair = pool.forThread4();
			String romanNumeral = convertToRomanNumeral(pair);

			System.err.println("Thread4 value of numbers: " + pair.getSum());
			System.err.println("Thread4 Roman Numeral: " + romanNumeral);
		}
	}

	private static final String[] RCODE = { "M", "CM", "D", "CD", "C", "XC",
			"L", "XL", "X", "IX", "V", "IV", "I" };
	private static final int[] BVAL = { 1000, 900, 500, 400, 100, 90, 50, 40,
			10, 9, 5, 4, 1 };

	private String convertToRomanNumeral(Pair pair) {
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

}
