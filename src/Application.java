import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;

public class Application {
		
	public WindowManager windowManager;
	public Database database;
	private boolean is_loggedin = false;
	private String username = null;

	/*
	 * The constructor function
	 */
	public static void main(String args[]){
		/* Load the window manager */
		Application app = new Application();
		app.init_application();
		app.load_models();
	}
	
	/**
	 * Function used when the user is loggein to the system
	 * @param The login status of the user.
	 */
	public void set_loggedin(boolean status){
		this.is_loggedin = status;
	}
	
	/**
	 * Function used to set the username of the loggedin user.
	 * @param The username
	 */
	public void set_username(String username){
		this.username = username;
	}
	
	/**
	 * Function used to get the username of the current user
	 * @return 
	 * @return The username
	 */
	public String get_username(){
		return this.username;
	}
	
	/**
	 * Function called when the login process is complete.
	 */
	public void login_complete(){
		System.out.println("Login process complete.");
		// Display the MasterControlWindow
		MasterControlWindow mainWindow = new MasterControlWindow();
	}
	
	public void init_application(){
		this.windowManager = new WindowManager();
		
		// Load up the login window
		if(!this.is_loggedin){
			AccountManager accounts = new AccountManager(this);
			accounts.load_account_login();
		}
	}
	
	/**
	 * Function used to loop through the models directory
	 * and create anything new in the database.
	 * @return
	 */
	public void load_models(){
		String dir = new File("src").getAbsolutePath();
		String _models = dir + "/models/Models.sql";
		
		String content = null;
		
		try {
			content = new String(Files.readAllBytes(Paths.get(_models)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Setup the sql connection to the database
		// and create the connection that will be used
		// to execute the contents of the models.sql file.
		Database db = new Database();
		Statement statment = null;
		
		try {
			statment = db.get().createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Run the contents of the sql file.
		try {
			statment.execute(content);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// All done. Close the connection to the database. 
		db.close();
	}
}
