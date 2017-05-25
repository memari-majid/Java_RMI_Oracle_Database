
import java.rmi.*;

public class Client {

    public static void main(String args[]) {
        
		try {
            String ServerURL = "rmi://" + args[0] + "/Server";
            ServerIntf ServerIntf = (ServerIntf) Naming.lookup(ServerURL);
            System.out.println(ServerIntf.FortuneTeller());
        } catch (Exception e) {
            System.err.println("RemoteException: " + e.getMessage());
        }
    }
}
