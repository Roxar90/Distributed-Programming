import java.util.Random;
import java.util.logging.Logger;

public class MontecarloSequenziale {

	static Logger logger = Logger.getGlobal();
	
	public static void main(String[] args) {
		
		double numOfPoints = 1000000000;
		double approx = 0 ;
		long start = System.currentTimeMillis();
		logger.info("Start!");
		Random rand = new Random();
		for (double i = 0 ;i<numOfPoints;i++) {
			
			double a = rand.nextDouble();
			double b = rand.nextDouble();
			
			double centro = a*a + b*b;
			if(centro<1) {
				approx++;
			
			}
			
		}
		logger.info("Tempo esecuzione:" + (System.currentTimeMillis() - start) );
		logger.info("Approximation : "  + ((approx/numOfPoints)*4));
		
		
	}

}
