package vaadin.application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlBDDManager {
	private static SqlBDDManager SQLBDDMANAGER = new SqlBDDManager();
	private Connection connection;
	private boolean connected;

	private SqlBDDManager(){
		connected = false;
	}

	public static SqlBDDManager getInstance(){
		return SQLBDDMANAGER;
	}

	//Connect to the database
	public boolean connect(String srv, String user, String pwd){
		connected = true;
		try {

			//Loading of driver
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			

			//Connection to the access database
			String connectionString = "jdbc:sqlserver://" + srv;
			
			connection = DriverManager.getConnection(connectionString,user,pwd);
			System.out.println("Connexion r�ussi");
		} catch (ClassNotFoundException e) {
			System.out.println(Constant.ERRORSQLBDDDRIVER + e.getMessage());
			connected = false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(Constant.ERRORSQLCONNECTION + e.getMessage());
			e.printStackTrace();
			connected = false;
		}
		return connected;
	}

	//Disconnect from the database
	public boolean disconnect() {
		try {
			connection.close();
			connected = false;
			return true;
		}
		catch (SQLException e) {
			System.out.println(Constant.ERRORSQLCLOSE + e.getMessage());
			return false;
		}
	}

	//Send a selection request
	public ResultSet SQLSelect(String sql) throws SQLException {
		Statement statement = null;
		ResultSet result = null;
		try {
			statement = connection.createStatement();
			result = statement.executeQuery(sql);
			return result;
		}
		catch (SQLException e) {
			System.out.println(Constant.ERRORSQLREQUEST + e.getMessage());
			return null;
		}
	}

	public boolean isConnected() {
		return connected;
	}

	public void setConnected(boolean connected) {
		this.connected = connected;
	}
	
	public int countRs(ResultSet rsForCount) {
		int count = 0;
		try {
			while(rsForCount.next()){
				count++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(count);
		return count;
	}
}