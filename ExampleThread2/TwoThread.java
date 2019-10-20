
public class TwoThread {

	public static void main(String[] args) throws InterruptedException {

		int[] array = new int[500000000];

		Thread one = new Thread(new Runnable() {

			@Override
			public void run() {

				long start = System.currentTimeMillis();
				for (int i = 0; i < array.length / 2; i++) {

					array[i] = 42;
				}
				
				System.out.println("1° Finish. Time = " + (System.currentTimeMillis() - start) + "ms");
			}
			
		});
		
		double total = System.nanoTime(); 
		one.start();
		

		Thread two = new Thread(new Runnable() {

			@Override
			public void run() {

				long start = System.currentTimeMillis();
				for (int i = array.length / 2; i < array.length; i++) {

					array[i] = 42;
				}
				
				System.out.println("2° Finish. Time = " + (System.currentTimeMillis() - start) + "ms");
			}
		});

		two.start();
		
		
	
		
		System.out.println("Finish Time: "+ ((System.nanoTime()- total)/1000000));
		

		
	}

}
