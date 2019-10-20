import java.io.Console;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MontecarloWithThreads {

	static Logger log = Logger.getGlobal();

	public static void main(String[] args) throws InterruptedException {
		
		int numThreads = 4;

		double numOfPoints = 100000000000L;
		double totApprox = 0.0;
		
		CalcolaPI[] threads = new CalcolaPI[numThreads];
		System.out.println("PI Approximation with Montecarlo method");
		System.out.println("Calculated on " + numOfPoints + "points");
		System.out.println();
		log.info("Starting " + numThreads + " thread(s)");

		for (int i = 0; i < numThreads; i++) {
			threads[i] = new CalcolaPI(numOfPoints / numThreads);
			

		}
		long start = System.currentTimeMillis();
		for (int i = 0; i < numThreads; i++) {
			log.info("Started thread ["+ i +"]");
			threads[i].start();

		}

		for (int i = 0; i < numThreads; i++) {
			threads[i].join();

		}
		for (int i = 0; i < numThreads; i++) {
			totApprox += threads[i].getApproximation();

		}

		log.log(Level.INFO, "Result of Approximation " + (((double)(totApprox / numOfPoints) * 4)));
		log.info("Tempo impiegato:(secondi) " + ((System.currentTimeMillis() - start)/1000.0));
	}

}
