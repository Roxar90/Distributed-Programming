import java.lang.System.Logger;

public class Counter {

	public static void main(String[] args) throws InterruptedException {

		Incrementatore b  = new Incrementatore();

		int numThreads = 1;
		int numIncrement = 5000000;
		
		class threadIncrement extends Thread{
			
			int numIncrements;
			public threadIncrement(int increments) {
				
				this.numIncrements = increments;
			}
			
			public void run() {
				for (int i = 0 ;i<numIncrements;i++) {
					b.increment();
				}
			}
		}
		
		
		threadIncrement[] arr = new threadIncrement[numThreads];

		long start = System.currentTimeMillis();

		for (int a = 0; a < numThreads; a++) {

			arr[a] = new threadIncrement(numIncrement / numThreads);
			arr[a].start();

		}

		for (int a = 0; a < numThreads; a++) {
			arr[a].join();
		}

		System.out.println(b.getInteger());
		System.out.println("finish: " + (System.currentTimeMillis() - start));

	}
}
