
import java.net.*;
import java.rmi.*;

public class Server {
	 public static void main(String args[]) {
		try {
			ServerImpl ServerImpl = new ServerImpl();
			Naming.rebind("Server", ServerImpl);
			System.out.println("Server is waiting");
			System.out.println("Please run the method remotely by CLient through local host");
		} catch(Exception e) {
			System.err.println("RemoteException: " + e.getMessage());
		}
	}
}