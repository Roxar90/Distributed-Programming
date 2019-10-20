public class Incrementatore extends Thread {

	private Integer i;
	
	public Incrementatore() {
		this.i = 0 ;
	}
	
	public synchronized void increment() {
		i++;
	}
	
	public Integer getInteger() {
		return i;
	}
	
}
