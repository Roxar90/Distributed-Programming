import java.io.Serializable;

public class Couple implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int first, second = 0;
	
	public Couple(int a, int b) {
		this.first = a;
		this.second = b;
	}
	
	public int getFirst() {
		return this.first;
	}
	
	public int getSecond() {
		return this.second;
	}

}
