import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {

	public static void main(String[] args) {
		boolean tutorial = true;
		if (tutorial) System.err.println("@System_>>> Tutorial true -> system supports only test and quit commands");
		Socket connection = null;
		try {
			System.out.println("@System_>>> Connecting to server...");
			connection = new Socket("localhost", 9000);
		} catch (IOException e) {
			System.err.println("@System_>>> Cannot connect to the server");
			System.exit(0);
		}
		ObjectOutputStream socketOutStream = null;
		ObjectInputStream socketInStream = null;
		BufferedReader keyboardIn = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("@System_>>> Preparing streams...");
			socketOutStream = new ObjectOutputStream(connection.getOutputStream());
			socketInStream = new ObjectInputStream(connection.getInputStream());
			System.out.println("@System_>>> Streams ready!");
		} catch (IOException e1) {
			System.err.println("@System_>>> Cannot create streams");
			System.exit(0);
		}
		while(true) {
			String command = null;
			System.out.print("@Console_>>> ");
			try {
				command = keyboardIn.readLine();
			} catch (IOException e) {
				System.err.println("@System_>>> Keyboard stream doesn't works.");
			}
			try {
				socketOutStream.writeObject(command);
				socketOutStream.flush();
			} catch (IOException e) {
				System.err.println("@System_>>> Cannot send cmd command");
				System.exit(0);
			}
			if (command.equals("close") || command.equals("quit")) {
				System.err.println("@System_>>> Server and client closed");
				break;
			}
			else try {
				String response = (String) socketInStream.readObject();
				System.out.println("@Server_>>> " + response);
			} catch (ClassNotFoundException | IOException e) {
				System.err.println("@System_>>> Problem with response from the server");
				System.exit(0);
			}
			//End of while
		}
		
	}

}
