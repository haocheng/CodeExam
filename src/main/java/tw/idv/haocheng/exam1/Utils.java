package tw.idv.haocheng.exam1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Utils {

	private static final String[] RCODE = { "M", "CM", "D", "CD", "C", "XC",
			"L", "XL", "X", "IX", "V", "IV", "I" };
	private static final int[] BVAL = { 1000, 900, 500, 400, 100, 90, 50, 40,
			10, 9, 5, 4, 1 };

	public static String convertToRomanNumeral(Pair pair) {
		int num = pair.getSum();

		// binaryToRoman
		if (num <= 0 || num >= 4000) {
			throw new NumberFormatException(
					"Value outside roman numeral range.");
		}
		
		// Roman notation will be accumualated here.
		StringBuilder builder = new StringBuilder();

		// Loop from biggest value to smallest, successively subtracting,
		// from the binary value while adding to the roman representation.
		for (int i = 0; i < RCODE.length; i++) {
			while (num >= BVAL[i]) {
				num -= BVAL[i];
				builder.append(RCODE[i]);
			}
		}
		return builder.toString();
	}

	public static Double findMedian(List<Integer> numbers) {
		Collections.sort(numbers);
		System.err.println("all numbers: "
				+ Arrays.toString(numbers.toArray()));

		int size = numbers.size();

		if (size % 2 == 1) {
			return Double.valueOf(numbers.get((int) Math.floor(size / 2)));
		} else {
			Double lowerMiddle = Double.valueOf(numbers.get(size / 2));
			Double upperMiddle = Double.valueOf(numbers.get(size / 2 - 1));
			return (lowerMiddle + upperMiddle) / 2;
		}
	}

	public static boolean isPrime(int n) {
		if (n < 2)
			return false;
		if (n == 2 || n == 3)
			return true;
		if (n % 2 == 0 || n % 3 == 0)
			return false;
		long sqrtN = (long) Math.sqrt(n) + 1;
		for (long i = 6L; i <= sqrtN; i += 6) {
			if (n % (i - 1) == 0 || n % (i + 1) == 0)
				return false;
		}
		return true;
	}

}
