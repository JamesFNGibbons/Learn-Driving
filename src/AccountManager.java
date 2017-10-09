import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class AccountManager {
	
	private Object root;
	private JFrame login_window;
	
	public AccountManager(Object app){
		this.root = app;
	}
	
	/**
	 * Function used to display the incorrect login
	 * window.
	 */
	public void incorrect_login(){
		// Create and display a dialog.
		JFrame window = new JFrame();
		window.setTitle("Incorrect Login!");
		window.setVisible(true);
		window.setAlwaysOnTop(true);
		window.setSize(600, 300);
		window.setResizable(false);
		
		// Create the container panel for the content of the dialog. 
		JPanel master_panel = new JPanel();
		master_panel.setLayout(new GridLayout(3, 1));
		master_panel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
		
		// Display the error icon.
		ImageIcon error_icon = new ImageIcon(new ImageIcon(this.getClass().getResource("resources/icons/error.png")).getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH));
		JLabel error = new JLabel(error_icon);
		master_panel.add(error);
		
		// Display the text
		JLabel text = new JLabel("Your username or password is incorrect.", SwingConstants.CENTER);
		text.setFont(new Font(text.getFont().getFontName(), Font.BOLD, 20));
		master_panel.add(text);
		
		// Display the close button.
		JButton close = new JButton("Close");
		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				// Close the dialog.
				window.dispose();
			}
		});
		master_panel.add(close);
		
		window.setContentPane(master_panel);
		window.show();
	}
	
	/**
	 * Function used to validate a users login.
	 * @param String username The users username,
	 * @param String password The users password, 
	 */
	public void validate_login(String username, String password){
//		if(username != "" && password != ""){
//			
//		}
//		else{
//			/* Login is incorrect */
//			this.incorrect_login();
//		}
		
		this.incorrect_login();
	}
	
	/*
	 * Function used to load up the account login dialog. 
	 */
	public void load_account_login(){
		// Check that the user is already loggedin.
		this.login_window = new JFrame();
		login_window.setVisible(true);
		login_window.setSize(250, 250);
		login_window.setTitle("Please Sign In");
		login_window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		login_window.setResizable(false);
		
		// Create the master panel
		JPanel master_panel = new JPanel();
		
		/**
		 * Create the logo for the header, and add it 
		 * to the master_panel.
		 */
		ImageIcon image = new ImageIcon(new ImageIcon(this.getClass().getResource("resources/logo.png")).getImage().getScaledInstance(200, 40, Image.SCALE_SMOOTH));
		JLabel logo = new JLabel();
		logo.setIcon(image);
		master_panel.add(logo);
		
		// Create the new content pane for the login items.
		// this will be within the master panel.
		JPanel login_input = new JPanel();
		login_input.setMaximumSize(new Dimension(100, 300));;
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(5, 1));
		
		/*
		 * Creates the username input in its own
		 * container panel.
		 */
		JPanel username_input = new JPanel();
		username_input.setLayout(new GridLayout(2, 1));
		
		JTextField username = new JTextField();
		JLabel username_label = new JLabel("Username");
		username_input.add(username_label);
		username_input.add(username);
		// Push the new field panel to the input panel.
		panel.add(username_input);
		
		/*
		 * Creates the password input in its own
		 * container panel.
		 */
		JPanel password_input = new JPanel();
		password_input.setLayout(new GridLayout(2, 1));
		
		JPasswordField password = new JPasswordField();
		JLabel password_label = new JLabel("Password");
		password_input.add(password_label);
		password_input.add(password);
		// Push the new field panel to the input panel.
		panel.add(password_input);
		
		// Create another panel for the two login buttons.
		JPanel btns = new JPanel();
		btns.setLayout(new GridLayout(1, 2));
		
		JButton login = new JButton("Login");
		JButton register = new JButton("Register");
		
		btns.add(login);
		btns.add(register);
		
		panel.add(btns);
		
		// Add the panel to the login_input panel.
		login_input.add(panel);
		// Add the login input panel to the master panel.
		master_panel.add(login_input);
		
		login_window.setContentPane(master_panel);
		
		// Render the window.
		login_window.show();
		
		Object root = this;
		
		/* Handles the login button being clicked. */
		login.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				((AccountManager) root).validate_login(username.getText(), password.getText());
				
			}
		});
	}
}
