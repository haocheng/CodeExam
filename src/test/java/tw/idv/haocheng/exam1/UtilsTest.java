package tw.idv.haocheng.exam1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

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

		List<Integer> ints2 = Arrays.asList(1, 3, 5, 7);

		assertEquals(4.0d, Utils.findMedian(ints2).doubleValue(), 1e-15);
	}

	@Test
	public void isPrime() throws Exception {
		assertTrue(Utils.isPrime(3));
		assertTrue(Utils.isPrime(17));
		assertTrue(Utils.isPrime(31));
		assertTrue(Utils.isPrime(97));

		assertFalse(Utils.isPrime(10));
		assertFalse(Utils.isPrime(9));
		assertFalse(Utils.isPrime(99));
		assertFalse(Utils.isPrime(999));
	}

}
