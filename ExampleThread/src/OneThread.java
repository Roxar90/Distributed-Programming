
public class OneThread {
	
	public static void main(String[] args) {
	
	int [] array = new int[500000000];
	
	long start = System.currentTimeMillis();
	
	for (int i = 0; i<array.length;i++) {
		
		array[i]=42;
	}
	
	System.out.println("Finish. Time = "+ (System.currentTimeMillis()-start) +"ms");
		
	}

}
