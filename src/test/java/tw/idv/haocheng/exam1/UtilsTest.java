package tw.idv.haocheng.exam1;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.junit.Test;

import tw.idv.haocheng.exam1.Pair;
import tw.idv.haocheng.exam1.Utils;

public class UtilsTest {

	@Test
	public void convertToRomanNumeral() throws Exception {
		assertEquals("IV", Utils.convertToRomanNumeral(new Pair(1, 3)));
		assertEquals("X", Utils.convertToRomanNumeral(new Pair(5, 5)));
		assertEquals("XIII", Utils.convertToRomanNumeral(new Pair(10, 3)));
	}

	@Test
	public void findMedian() {
		List<Integer> ints = Arrays.asList(1, 3, 5);

		assertEquals(3.0d, Utils.findMedian(ints).doubleValue(), 1e-15);

		List<Integer> ints2 = Arrays.asList(7, 3, 5, 1);

		assertEquals(4.0d, Utils.findMedian(ints2).doubleValue(), 1e-15);
	}

	@Test
	public void findMedianWithoutSort() {
		List<Integer> ints = Arrays.asList(1, 3, 5);

		assertEquals(2.0d, Utils.findMedianWithoutSort(ints).doubleValue(),
				1e-15);

		List<Integer> ints2 = Arrays.asList(7, 2, 3, 4, 9, 1, 5, 3);

		assertEquals(4.0d, Utils.findMedianWithoutSort(ints2).doubleValue(),
				1e-15);

		List<Integer> ints3 = Arrays.asList(7, 2, 3, 4, 9, 1, 5, 3, 10, 12, 5,
				8, 9, 99, 100, 2);

		assertEquals(4.0d, Utils.findMedianWithoutSort(ints3).doubleValue(),
				1e-15);
	}

	@Test
	public void isPrime() throws Exception {
		assertTrue(Utils.isPrime(3));
		assertTrue(Utils.isPrime(17));
		assertTrue(Utils.isPrime(31));
		assertTrue(Utils.isPrime(997));
		assertTrue(Utils.isPrime(1378663747));

		assertFalse(Utils.isPrime(10));
		assertFalse(Utils.isPrime(9));
		assertFalse(Utils.isPrime(99));
		assertFalse(Utils.isPrime(999));
		assertFalse(Utils.isPrime(1378663748));
	}

	@Test
	public void isPrime2() throws Exception {
		assertTrue(Utils.isPrime2(3));
		assertTrue(Utils.isPrime2(17));
		assertTrue(Utils.isPrime2(31));
		assertTrue(Utils.isPrime2(997));
		assertTrue(Utils.isPrime2(1378663747));

		assertFalse(Utils.isPrime2(10));
		assertFalse(Utils.isPrime2(9));
		assertFalse(Utils.isPrime2(99));
		assertFalse(Utils.isPrime2(999));
		assertFalse(Utils.isPrime2(1378663748));
	}

	@Test
	public void isMersennePrime() throws Exception {
		assertTrue(Utils.isMersennePrime(3));
		assertTrue(Utils.isMersennePrime(17));
		assertTrue(Utils.isMersennePrime(31));
		assertTrue(Utils.isMersennePrime(997));

		assertFalse(Utils.isMersennePrime(10));
		assertFalse(Utils.isMersennePrime(9));
		assertFalse(Utils.isMersennePrime(99));
		assertFalse(Utils.isMersennePrime(999));
	}

	@Test
	public void compareIsPrimeAlgorithms() throws Exception {

		Random random = new Random();
		int[] randoms = new int[1000];
		for (int i = 0; i < 1000; i++) {
			randoms[i] = random.nextInt(Integer.MAX_VALUE);
		}

		long start = new Date().getTime();
		for (int i = 0; i < randoms.length; i++) {
			int num = randoms[i];
			BigInteger integer = new BigInteger(String.valueOf(num));
			System.out.println(integer);
			System.out.println(integer.isProbablePrime(10));
		}
		long end = new Date().getTime();
		System.err.println("BigInteger.isProbablePrime(10) time spent: "
				+ (end - start));

		start = new Date().getTime();
		for (int i = 0; i < randoms.length; i++) {
			int num = randoms[i];
			System.out.println(num);
			System.out.println(Utils.isPrime(num));
		}
		end = new Date().getTime();
		System.err.println("isPrime time spent: " + (end - start));

		start = new Date().getTime();
		for (int i = 0; i < randoms.length; i++) {
			int num = randoms[i];
			System.out.println(num);
			System.out.println(Utils.isPrime2(num));
		}
		end = new Date().getTime();
		System.err.println("isPrime2 time spent: " + (end - start));

		start = new Date().getTime();
		for (int i = 0; i < randoms.length; i++) {
			int num = randoms[i];
			System.out.println(Utils.isMersennePrime(num));
		}
		end = new Date().getTime();
		System.err.println("isMersennePrime time spent: " + (end - start));
	}

}
