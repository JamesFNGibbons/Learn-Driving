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
	}
	
	public void init_application(){
		this.windowManager = new WindowManager();
		
		// Load up the login window
		if(!this.is_loggedin){
			AccountManager accounts = new AccountManager(this);
			accounts.load_account_login();
		}
	}
}
