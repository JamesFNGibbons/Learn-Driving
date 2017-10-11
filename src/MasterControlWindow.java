import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;

public class MasterControlWindow extends JFrame{
	
	/**
	 * Used to render the quick test panel
	 */
	private JPanel quick_test(){
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createTitledBorder("Start Revision Session"));
		panel.setLayout(new GridLayout(2, 1));
		
		// Create the Start Random Topics button
		JButton start_rand_topics = new JButton("Start with random topics");
		panel.add(start_rand_topics);
		
		// Create the Select topics button.
		JPanel specific_topic = new JPanel();
		specific_topic.setBorder(BorderFactory.createTitledBorder("Select Specific Topic"));
		
		// Create the select topic dropdown.
		String[] topics = {
			"Parking",
			"Roundabouts",
			"Junctions"
		};	
		JComboBox<String> topic = new JComboBox(topics);
		specific_topic.add(topic);
		
		JButton specific_topic_start = new JButton("Start with selected topic");
		specific_topic.add(specific_topic_start);
		
		panel.add(specific_topic);
		
		return panel;
	}
	
	/**
	 * Used to render the accounts panel
	 */
	private JPanel accounts_panel(){
		JPanel panel = new JPanel();
		
		// Set the title border of the panel. 
		Border border = BorderFactory.createTitledBorder("Active Accounts");
		panel.setBorder(border);
		
		// Create the table to hold the accounts.
		String[] cols = {
			"Account Name",
			"Username",
			"High Score"
		};
		
		Object[][] accounts = {
				{
					"Jhon Doe",
					"jdoe",
					300
				}
		};
		
		JTable table = new JTable(accounts, cols);
		table.setCellSelectionEnabled(false);
		table.setFillsViewportHeight(true);
		table.setPreferredScrollableViewportSize(table.getPreferredSize());
		table.setFillsViewportHeight(true);
		panel.add(new JScrollPane(table));
		
		return panel;
	}
	
	/**
	 * Constructor used to init the window.
	 */
	public MasterControlWindow(){
		this.setTitle("Learn Driving - Dashboard");
		this.setSize(new Dimension(700, 400));
		this.setMinimumSize(new Dimension(700, 400));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(1, 3));
		
		this.add(this.accounts_panel());
		this.add(this.quick_test());
		
		this.render();
	}
	
	public void render(){
		this.setVisible(true);
	}
}
