import java.util.Random;

public class MainThread {

	public static void main(String[] args) throws InterruptedException {

		int[] array = new int[500000000];
		long sum = 0;
		for (int i = 0; i < array.length; i++) {
			array[i] = 1;
		}

		int numThread = 2;

		SumSubArray[] threads = new SumSubArray[numThread];

		int start = 0;

		double startTime = System.nanoTime();

		for (int i = 0; i < threads.length; i++) {

			threads[i] = new SumSubArray(array, start, start + array.length / numThread);
			start = array.length / numThread;
			threads[i].start();

		}

		for (int i = 0; i < threads.length; i++) {

			threads[i].join();
		}
		
		double finalTime = (System.nanoTime() - startTime) / 1000000;
		
		System.out.println("Time :" + finalTime + "ms");
		

		System.out.println("Sum= " + SumSubArray.PARTIALSUM);

	}

}
