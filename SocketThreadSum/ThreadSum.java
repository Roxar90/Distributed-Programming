import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ThreadSum extends Thread {

	private Socket connection = null;
	private ObjectOutputStream out = null;
	private ObjectInputStream in = null;
	private int gettedNumber = 0;
	
	public ThreadSum(Socket connection) {
		this.connection = connection;
		try {
			this.in = new ObjectInputStream(connection.getInputStream());
			this.out = new ObjectOutputStream(connection.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("Problem with the creation of the streams");
			System.exit(0);
		}
	}
	
	public void run() {
		/*
		 * READING FROM STREAM
		 * */
		try {
			gettedNumber = (int) this.in.readObject();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("Class conversion problem");
			System.exit(0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("IOException found");
			System.exit(0);
		}
		System.err.println("Input number: " + gettedNumber);
		/*
		 * WRITING ON STREAM
		 * */
		Server.increaseServerSum(gettedNumber);
		System.err.println("Sum to write: " + Server.getServerSum());
		try {
			this.out.writeObject(Server.getServerSum());
			this.out.flush();
			this.in.close();
			this.out.close();
			connection.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("IOException found");
		}
		
	}
	
}
