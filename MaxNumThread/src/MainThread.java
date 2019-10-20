import java.util.Random;

public class MainThread {

	public static void main(String[] args) throws InterruptedException {

		int[] array = new int[500000000];
		
		Random rand = new Random();
		
		for (int i = 0; i < array.length; i++) {
			array[i] = rand.nextInt(10)+1;
		}
		
		int numThread = 2;

		MaxSubArray[] threads = new MaxSubArray[numThread];

		

		double startTime = System.nanoTime();

		int start = 0;
		
		for (int i = 0; i < threads.length; i++) {

			threads[i] = new MaxSubArray(array, start, start + array.length / numThread);
			start = array.length / numThread;
			threads[i].start();

		}

		for (int i = 0; i < threads.length; i++) {

			threads[i].join();
		}
		
		double finalTime = (System.nanoTime() - startTime) / 1000000;
		
		System.out.println("Time :" + finalTime + "ms");
		int max=0;
		for (int i = 0; i < threads.length; i++) {
			if(max < threads[i].getMax())
				max = threads[i].getMax();
		}
		
		System.out.println("Max in array is :" +max);
	}

}
