
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Database {
	
	private Connection connection;
	
	public Database(){
		// Establish a connection.
		this.connect();
	}
	
	/**
	 * Function used to connect to the sqlite databas.
	 */
	private void connect(){
		// Generate the database connection uri.
		String db_uri = "jdbc:sqlite:";
		db_uri += this.getClass().getResource("db/db.db");
		
		// Attempt a connection
		try{
			this.connection = DriverManager.getConnection(db_uri);
			System.out.println("Loaded database file.");
		}
		catch(SQLException e){
			System.out.print(e.getMessage());
		}
	}
	
	/**
	 * Function used to get the currect connection to the sqlite database.
	 * @return 
	 */
	public Connection get(){
		try {
			if(!this.connection.isClosed()){
				return this.connection;
			}
			else return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * Function used to kill the connection to the database.
	 */
	public void close(){
		try {
			this.connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
