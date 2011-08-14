package tw.idv.haocheng.exam1;

public class Pair {

	private final int t1;

	private final int t2;

	public Pair(Integer t1, Integer t2) {
		this.t1 = t1.intValue();
		this.t2 = t2.intValue();
	}

	public int getSum() {
		return t1 + t2;
	}

}