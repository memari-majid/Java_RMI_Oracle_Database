
import java.rmi.*;

	public interface ServerIntf extends Remote {
		
		String FortuneTeller() throws RemoteException,Exception;
}