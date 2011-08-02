package tw.idv.haocheng;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;

import tw.idv.haocheng.exam1.Thread1;
import tw.idv.haocheng.exam1.Thread3;

public class ThreadTest {

	@Test
	public void test() {
		AtomicInteger integer = new AtomicInteger(0);
		integer.addAndGet(10);
		integer.addAndGet(20);
		
		System.err.println(integer.get());
	}

}
