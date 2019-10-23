import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		ServerSocket myServer = null;
		Socket connection = null;
		
		myServer = new ServerSocket(9000);
		connection = myServer.accept();
		ObjectOutputStream out = new ObjectOutputStream(connection.getOutputStream());
		ObjectInputStream in = new ObjectInputStream(connection.getInputStream());
		
		Couple clientCouple = (Couple) in.readObject();
		int result = clientCouple.getFirst() + clientCouple.getSecond();
		out.writeObject(result);
		out.flush();
		in.close();
		out.close();
		myServer.close();

	}

}
