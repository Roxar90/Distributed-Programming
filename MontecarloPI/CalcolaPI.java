//import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class CalcolaPI extends Thread {

	private double numOfPoints;
	private double approximation;

	public CalcolaPI(double numOfPoints) {
		this.numOfPoints = numOfPoints;
		this.approximation = 0.0;
	}

	public double getApproximation() {
		return approximation;
	}

	public void run() {
		/*instead of Random class i will use ThreadLocalRandom class that is safe for threads use
		Random rand = new Random();*/
		
		ThreadLocalRandom rand = ThreadLocalRandom.current();
		
		for (double i = 0; i < numOfPoints; i++) {
			
			
			double a = rand.nextDouble();
			double b = rand.nextDouble();

			
			if ((a*a + b*b) < 1) {
				approximation++;

			}
			
		}
		
	}

}
