
public class SumSubArray extends Thread{
	
	public static int PARTIALSUM = 0;
	private int[] array;
	private int start;
	private int finish;
	private static Object lock = new Object();
	
	public SumSubArray(int[] array, int start, int finish) {
		
		this.array = array;
		this.start= start;
		this.finish = finish;
		
		
	}
	
	public void run() {
		
		for(int i = start; i<finish;i++) {
			
			synchronized (lock) {
				PARTIALSUM += array[i];
			}
		}
	}
	
	
	
}
