package tw.idv.haocheng.exam1;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class QuickSelectTest {

	@Test
	public void quickSelect() throws Exception {
		// odd case
		Integer[] ints = new Integer[] { 77, 1, 2, 30, 99, 5, 3, 9, 7, 10, 15,
				4, 100 };

		QuickSelect.quickSelect(ints, 7);
		
		System.err.println(Arrays.toString(ints));
		
		assertArrayEquals(new Integer[]{1, 2, 3, 4, 5, 7, 9, 10, 15, 30, 77, 99, 100}, ints);

		// even case
		ints = new Integer[] { 77, 22, 1, 2, 30, 99, 5, 3, 9, 7, 10, 15,
				4, 100 };
		
		QuickSelect.quickSelect(ints, 7);
		
		System.err.println(Arrays.toString(ints));
		
		assertArrayEquals(new Integer[]{1, 2, 3, 4, 5, 7, 9, 10, 22, 30, 15, 77, 99, 100}, ints);
	}

}
