
public class SumSubArray extends Thread{
	
	private long partialSum;
	private int[] array;
	private int start;
	private int finish;
	
	public SumSubArray(int[] array, int start, int finish) {
		
		this.array = array;
		this.start= start;
		this.finish = finish;
		this.partialSum = 0;
		
	}
	
	public void run() {
		
		for(int i = start; i<finish;i++) {
			partialSum += array[i];
		}
	}
	
	public long getPartialSum() {
		return partialSum;
	}
	
}
