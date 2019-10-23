import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	private static volatile int serverSum = 0;
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		ServerSocket server = null;
		Socket connection = null;
		
		server = new ServerSocket(9000);
		
		while(true) {
			//Getting a connection for a client
			System.err.println("Waiting connections...");
			connection = server.accept();
			System.err.println("Connection created!");
			ThreadSum myThread = new ThreadSum(connection);
			myThread.start();
		}
		
	}
	
	public synchronized static int getServerSum() {
		return Server.serverSum;
	}
	public synchronized static void increaseServerSum(int increment) {
		Server.serverSum += increment;
	}
	
}
