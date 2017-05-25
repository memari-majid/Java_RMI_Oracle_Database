
import java.rmi.*;
import java.rmi.server.*;
import java.util.Random;
import java.sql.*;

public class ServerImpl extends UnicastRemoteObject implements ServerIntf {

    private final Random randomNumber = new Random();
    private Connection con;
    private PreparedStatement ps;
    private int id;

    public ServerImpl() throws RemoteException, Exception {
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "4837");
		} catch (Exception e) {
            System.err.println("SQLException: " + e.getMessage());
        } 
    }
	
    public String FortuneTeller() throws RemoteException, Exception {
		
        
			String r = new String();
			id = this.randomNumber.nextInt(20) + 1;
			ps = con.prepareStatement("SELECT * FROM FORTUNES WHERE ID =" + id);
			ResultSet re = ps.executeQuery();
			while (re.next()) {
				r = (re.getString("FORTUNE"));
			}
        
		return r;
    }
}
