
public class FourThread {
	
	public static void main(String[] args) throws InterruptedException {

		int[] array = new int[500000000];

		Thread one = new Thread(new Runnable() {

			@Override
			public void run() {

				long start = System.currentTimeMillis();
				for (int i = 0; i < array.length / 4; i++) {

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
				for (int i = array.length / 4; i < array.length/2; i++) {

					array[i] = 42;
				}
				
				System.out.println("2° Finish. Time = " + (System.currentTimeMillis() - start) + "ms");
			}
		});

		two.start();
		
		Thread three = new Thread(new Runnable() {

			@Override
			public void run() {

				long start = System.currentTimeMillis();
				for (int i = array.length / 2; i < (array.length-array.length/4) ; i++) {

					array[i] = 42;
				}
				
				System.out.println("3° Finish. Time = " + (System.currentTimeMillis() - start) + "ms");
			}
		});

		three.start();
		
		Thread four = new Thread(new Runnable() {

			@Override
			public void run() {

				long start = System.currentTimeMillis();
				for (int i = (array.length-array.length/4); i < array.length; i++) {

					array[i] = 42;
				}
				
				System.out.println("4° Finish. Time = " + (System.currentTimeMillis() - start) + "ms");
			}
		});

		four.start();
		
		
		
		System.out.println("Finish Time: "+ ((System.nanoTime()- total)/1000000));		

		
	}

}
