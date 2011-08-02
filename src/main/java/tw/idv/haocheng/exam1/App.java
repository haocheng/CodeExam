package tw.idv.haocheng.exam1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		NumberPool pool = new NumberPool();

		executorService.execute(new Thread1(pool));
		executorService.execute(new Thread2(pool));
		executorService.execute(new Thread3(pool));
		executorService.execute(new Thread4(pool));
		executorService.execute(new Thread5(pool));
	}

}
