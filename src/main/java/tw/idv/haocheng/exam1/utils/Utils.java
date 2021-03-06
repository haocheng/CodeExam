package tw.idv.haocheng.exam1.utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import tw.idv.haocheng.exam1.Pair;

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
		StringBuffer builder = new StringBuffer();

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

	public static Double findMedian(Integer[] ints) {
		List<Integer> numbers = Arrays.asList(ints);
		Collections.sort(numbers);
		// System.err
		// .println("all numbers: " + Arrays.toString(numbers.toArray()));

		int size = numbers.size();

		if (size % 2 == 1) {
			return Double.valueOf(numbers.get((int) Math.floor(size / 2)));
		} else {
			Double lowerMiddle = Double.valueOf(numbers.get(size / 2));
			Double upperMiddle = Double.valueOf(numbers.get(size / 2 - 1));
			return (lowerMiddle + upperMiddle) / 2;
		}
	}

	public static double findMedianWithoutSort(Integer[] ints) {
		int n = ints.length;

		if (n % 2 == 0) {
			int mid = (n + 1) / 2;
			int mid2 = mid + 1;
			// System.err.println("Before: " + Arrays.toString(ints));

			QuickSelect.quickSelect(ints, mid);

			// System.err.println("After: " + Arrays.toString(ints));
			System.err.println(ints[mid - 1]);
			System.err.println(ints[mid2 - 1]);
			double median1 = (double) ((Integer) ints[mid - 1]).intValue();
			double median2 = (double) ((Integer) ints[mid2 - 1]).intValue();
			return (median1 + median2) / 2;
		} else {
			int mid = (n + 1) / 2;
			// System.err.println("Before: " + Arrays.toString(ints));

			QuickSelect.quickSelect(ints, mid);

			// System.err.println("After: " + Arrays.toString(ints));
			System.err.println("median: " + ints[mid - 1]);

			return (double) ((Integer) ints[mid - 1]).intValue();
		}

	}

	public static boolean isMersennePrime(int n) {
		int primes55[] = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43,
				47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109,
				113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179,
				181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241,
				251, 257 };

		for (int i = 0; i < 55; i++) {
			if (n % primes55[i] == 0) {
				if (n == primes55[i]) {
					return true;
				} else {
					return false;
				}
			}
		}

		int maxtest = n / 16;

		for (int i = 259; i < maxtest; i += 2)
			if (n % i == 0)
				return false;

		return true;
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

	public static boolean isPrime2(int n) {
		if (n <= 1) {
			return false;
		}
		if (n == 2) {
			return true;
		}
		if (n % 2 == 0) {
			return false;
		}
		for (int i = 3; i <= Math.sqrt(n) + 1; i = i + 2) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

}
