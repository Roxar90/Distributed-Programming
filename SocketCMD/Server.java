import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public final static int SERVERPORT = 9000;
	
	public static void main(String[] args) {
		ServerSocket server = null;
		Socket connection = null;
		ObjectInputStream keyboardIn = null;
		ObjectOutputStream keyboardOut = null;
		try {
			System.out.println("@ServerSys_>>> Waiting for client...");
			server = new ServerSocket(Server.SERVERPORT);
		} catch (IOException e) {
			System.err.println("@ServerSys_>>> Cannot create the server");
			System.exit(0);
		}
		try {
			connection = server.accept();
			System.out.println("@ServerSys_>>> Connection accepted!");
		} catch (IOException e) {
			System.err.println("@ServerSys_>>> Cannot start connection");
			System.exit(0);
		}
		try {
			System.out.println("@ServerSys_>>> Creating streams and preparing the server for commands...");
			keyboardOut = new ObjectOutputStream(connection.getOutputStream());
			keyboardIn = new ObjectInputStream(connection.getInputStream());
			System.out.println("@ServerSys_>>> Streams prepared.");
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			System.err.println("@ServerSys_>>> Cannot create streams");
			System.exit(0);
		}
		boolean cycle = true;
		while(cycle) {
			String message = null;
			try {
				System.out.println("@ServerSys_>>> Waiting for commands...");
				message = (String) keyboardIn.readObject();
				System.err.println("@ClientResponse_>>> Insered: " + message);
			} catch (ClassNotFoundException | IOException e) {
				System.err.println("@ClientResponse_>>> Cannot read the command");
				System.exit(0);
			}
			String strReply = reply(message);
			if (strReply.equals("cmd-quitconsole"))
				try {
					cycle = false;
					System.err.println("@ServerSys_>>> Now the cycle is " + cycle);
					connection.close();
				} catch (IOException e1) {
					System.err.println("@ServerSys_>>> Connection already closed");
					System.exit(0);
				}
			else {
				try {
					keyboardOut.writeObject(strReply);
					keyboardOut.flush();
				} catch (IOException e) {
					System.err.println("@ServerSys_>>> Cannot write the reply");
					System.exit(0);
				}
			}
			//End of while
		}
		try {
			keyboardOut.close();
			keyboardIn.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("@ServerSys_>>> Stream already closed");
		}
		
		System.err.println("@ServerSys_>>> Server closed");
		
	}
	
	private static String reply(String command) {
		String toReturn = null;
		if (command.equals("test"))
			toReturn = "That's a test!";
		if (command.equals("close") || command.equals("quit"))
			toReturn = "cmd-quitconsole";
		return toReturn;
	}
	
}
