import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JFrame;

public class Application {
		
	public WindowManager windowManager;
	public Database database;
	public boolean is_loggedin = false;

	/*
	 * The constructor function
	 */
	public static void main(String args[]){
		/* Load the window manager */
		Application app = new Application();
		app.init_application();
		app.load_models();
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
		try {
			BufferedReader models = new BufferedReader(new FileReader(this.getClass().getClassLoader().getResource("/models/Models.sql").getFile()));
			System.out.println(models.toString());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
