
public class MaxSubArray extends Thread {

	private int max;
	private int[] array;
	private int start;
	private int finish;

	public MaxSubArray(int[] array, int start, int finish) {

		this.array = array;
		this.start = start;
		this.finish = finish;
		this.max = 0;

	}

	public void run() {

		for (int i = start; i < finish; i++) {
			if (max < array[i])
				max = array[i];
		}
	}

	public int getMax() {
		return max;
	}

}
