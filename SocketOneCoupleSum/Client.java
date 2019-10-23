import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		Socket connection = null;
		
		connection = new Socket("localhost", 9000);
		ObjectOutputStream out = new ObjectOutputStream(connection.getOutputStream());
		ObjectInputStream in = new ObjectInputStream(connection.getInputStream());
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Inserisci il primo valore da sommare: ");
		int firstValue = keyboard.nextInt();
		keyboard.nextLine();
		System.out.print("Inserisci il secondo valore da sommare: ");
		int secondValue = keyboard.nextInt();
		keyboard.nextLine();
		keyboard.close();
		Couple clientCouple = new Couple(firstValue, secondValue);
		out.writeObject(clientCouple);
		out.flush();
		int result = (int) in.readObject();
		System.out.println("The result is: " + result);
		in.close();
		out.close();
		connection.close();

	}

}
