import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub

		Socket connection = new Socket("localhost", 9000);
		
		ObjectOutputStream out = new ObjectOutputStream(connection.getOutputStream());
		ObjectInputStream in = new ObjectInputStream(connection.getInputStream());
		
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Insert a number to sum in the principal thread: ");
		int numberToSend = keyboard.nextInt();
		keyboard.nextLine();
		keyboard.close();
		
		out.writeObject(numberToSend);
		out.flush();
		
		int instantResult = (int) in.readObject();
		System.out.println("The sum is " + instantResult);
		
		connection.close();
		
	}

}
