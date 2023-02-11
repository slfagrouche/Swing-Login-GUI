package LoginGUI;

/** 
 * Login GUI 
 * @author Said Lfagrouche
 * 
 * This program is a login GUI that allows users to enter their username and password. It has a user map that stores
 * valid combinations of usernames and passwords. When the user clicks the login button, the program checks if the
 * entered username and password match a combination in the user map. If it does, the program displays a success message.
 * If it does not, the program displays an error message. The program also has a clear button that clears the user and
 * password text fields and the success message. The program also has a background image that is displayed behind the
 * components.
 * The GUI is created using the Java Swing library and the background image is displayed using
 * the Java AWT library.
 */

import java.awt.event.ActionEvent; 	  // for handling action events (such as clicking a button)
import java.awt.event.ActionListener; // for implementing the ActionListener interface and responding to action events
import java.awt.image.BufferedImage;  // for reading and storing image data
import javax.swing.JButton; 		  // for creating buttons
import javax.swing.JFrame; 			  // for creating a frame to hold the panel and components
import javax.swing.JLabel; 			  // for displaying text or an image
import javax.swing.JPanel; 			  // for organizing and displaying the components
import javax.swing.JPasswordField;    // for displaying a password field that hides the entered characters
import javax.swing.JTextField; 		  // for displaying a text field for user input
import java.util.HashMap; 			  // for storing and accessing the user map
import javax.imageio.ImageIO; 		  // for reading and displaying the background image file
import java.io.File; 				  // for accessing the background image file
import java.io.IOException; 		  // for handling input/output exceptions when reading and displaying the background image file
import javax.swing.BorderFactory; 	  // for adding a border around the panel
import javax.swing.ImageIcon; 		  // for creating an image icon from the background image file
import java.awt.Component; 			  // for setting the layout to null
import java.awt.Font;

import javax.swing.SwingConstants;    // for aligning the labels and success message to the center

public class LoginGUI implements ActionListener {
	// Declare variables for the GUI components
	private JLabel usernameLabel;
	private JTextField usernameTextField;
	private JLabel passwordLabel;
	private JPasswordField passwordTextField;
	private JButton loginButton;
	private JButton clearButton;
	private JLabel successLabel;
	private JLabel backgroundLabel;
	private HashMap<String, String> users;

	public LoginGUI() {
		// Initializing user map and add valid combinations of usernames and passwords.
		users = new HashMap<String, String>();
		users.put("Said", "Lfag#123");
		users.put("Lfagrouche", "IN123");
		users.put("Juliet", "Home800@BC");
		users.put("alex", "lexj732");
		users.put("Ahmed", "hejs7@BC");
		users.put("Moshe", "$$4s6");
		users.put("USEE", "NK@BC");
		users.put("Moshe", "$$4s6");
		users.put("USEE", "NK@BC");

		// Creating panel and frame
		JPanel panel = new JPanel();
		JFrame frame = new JFrame("Login");
		frame.setSize(400, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);

		// Setting panel layout to null
		panel.setLayout(null);

		// Adding border to panel
		panel.setBorder(BorderFactory.createTitledBorder("Login"));
		// panel.setBorder(BorderFactory.createTitledBorder("Login"));

		// Initializing and adding username label to panel
		usernameLabel = new JLabel("Username", SwingConstants.RIGHT);
		usernameLabel.setBounds(10, 20, 80, 25);
		usernameLabel.setFont(new Font(usernameLabel.getFont().getName(), Font.BOLD, usernameLabel.getFont().getSize()));
		panel.add(usernameLabel);

		// Initializing and adding username text field to panel
		usernameTextField = new JTextField(20);
		usernameTextField.setBounds(100, 20, 165, 25);
		panel.add(usernameTextField);

		// Initializing and adding password label to panel
		passwordLabel = new JLabel("Password", SwingConstants.RIGHT);
		passwordLabel.setBounds(10, 50, 80, 20);
		passwordLabel.setFont(new Font(passwordLabel.getFont().getName(), Font.BOLD, usernameLabel.getFont().getSize()));
		panel.add(passwordLabel);

		// Initializing and adding password text field to panel
		passwordTextField = new JPasswordField(20);
		passwordTextField.setBounds(100, 50, 165, 25);
		panel.add(passwordTextField);

		// Initializing and adding login button to panel
		loginButton = new JButton("Login");
		loginButton.addActionListener(this);
		loginButton.setBounds(10, 80, 80, 25);
		panel.add(loginButton);

		// Initializing and adding clear button to panel
		clearButton = new JButton("Clear");
		clearButton.addActionListener(this);
		clearButton.setBounds(100, 80, 80, 25);
		panel.add(clearButton);

		// Initializing and adding success label to panel
		successLabel = new JLabel("Success", SwingConstants.CENTER);
		successLabel.setBounds(10, 110, 400, 25);
		successLabel.setFont(new Font(successLabel.getFont().getName(), Font.BOLD, usernameLabel.getFont().getSize()));
		panel.add(successLabel);
		successLabel.setText(null);

		// Adding image as background for panel
		BufferedImage image = null;
		try {
			// Background Image source: https://www.shutterstock.com/search/login-background
			image = ImageIO.read(new File("/Users/saidlfagrouche/Downloads/backgroundPicture.jpg"));

			// Initializing and adding background label to panel
			backgroundLabel = new JLabel(new ImageIcon(image));
			backgroundLabel.setBounds(0, 0, 400, 200);
			panel.add(backgroundLabel);

			// Making frame visible
			frame.setVisible(true);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	/**
	 * The actionPerformed method is called when an action event (such as clicking a
	 * button) occurs. It gets the username and password from the text fields,
	 * checks if they match a combination in the user map, and displays a success or
	 * error message accordingly. This method is overridden from the ActionListener
	 * interface to provide custom functionality for this program.
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == loginButton) {
			// Getting text from user and password text fields
			String username = usernameTextField.getText();
			
			// Get password entered by user and Convert password to string
			char[] passwordChars = passwordTextField.getPassword();
			String password = new String(passwordChars);
						

			// Checking if username and password match a valid combination in the user map
			if (users.containsKey(username) && users.get(username).equals(password)) {
				successLabel.setText("Login successful!");
			} else {
				successLabel.setText("Invalid username or password, please try again.");
			}
		} else if (e.getSource() == clearButton) {
			// Clearing user and password text fields and success label
			usernameTextField.setText("");
			passwordTextField.setText("");
			successLabel.setText("");
		}
	}

	public static void main(String[] args) {
		// Creating a new GUI object, which will handle all the necessary tasks
		// for creating and displaying the login interface
		new LoginGUI();
	}
}
