package tw.idv.haocheng.exam1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class App {

	public static void main(String[] args) {

		ExecutorService executorService = Executors.newFixedThreadPool(5);
		BlockingQueue<Integer> queue1 = new LinkedBlockingQueue<Integer>(30);
		BlockingQueue<Integer> queue2 = new LinkedBlockingQueue<Integer>(30);
		List<Integer> numbers = Collections
				.synchronizedList(new ArrayList<Integer>());

		executorService.execute(new Thread1(queue1));
		executorService.execute(new Thread2(queue2));
		executorService.execute(new Thread3(queue1, queue2, numbers));
		executorService.execute(new Thread4(queue1, queue2));
		executorService.execute(new Thread5(queue1, queue2));
	}

}
