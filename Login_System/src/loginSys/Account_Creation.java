package loginSys;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Account_Creation {

	Component frmLoginSystem;
	protected static final String Account_Creation = null;
	private JFrame frame;
	private JTextField txtCreateUserName;
	private JTextField txtCreatePassword;

	/**
	 * Launch the application.
	 */
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Account_Creation window = new Account_Creation();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Account_Creation() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCreateName = new JLabel("Choose a username");
		lblCreateName.setBounds(10, 63, 97, 14);
		frame.getContentPane().add(lblCreateName);
		
		txtCreateUserName = new JTextField();
		txtCreateUserName.setBounds(10, 88, 130, 20);
		frame.getContentPane().add(txtCreateUserName);
		txtCreateUserName.setColumns(10);
		
		JLabel lblCreatePassword = new JLabel("Choose a password");
		lblCreatePassword.setBounds(192, 63, 97, 14);
		frame.getContentPane().add(lblCreatePassword);
		
		txtCreatePassword = new JTextField();
		txtCreatePassword.setBounds(192, 88, 130, 20);
		frame.getContentPane().add(txtCreatePassword);
		txtCreatePassword.setColumns(10);
		
		JButton btnSubmitCreds = new JButton("Create Account");
		btnSubmitCreds.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String createUsername = txtCreateUserName.getText();
				String createPassword = txtCreatePassword.getText();
				
				if(createUsername.length()<4) {
					JOptionPane.showMessageDialog(null,"Username must be atleast 8 characters long","Login Error", JOptionPane.ERROR_MESSAGE);
					txtCreateUserName.setText(null);
					txtCreatePassword.setText(null);
					if(createPassword.length()<8) {
						JOptionPane.showMessageDialog(null,"Password must be atleast 8 characters long","Login Error", JOptionPane.ERROR_MESSAGE);
						txtCreateUserName.setText(null);
						txtCreatePassword.setText(null);
					}
				}
				else {
					try {
						//TODO add ability to pull from database??
						//This would only work if you put the path of the text file
					    BufferedWriter userNameWriter = new BufferedWriter(new FileWriter("D:\\Git\\repository\\Login_System\\Login_System\\src\\loginSys\\Username.txt", true));
					    BufferedWriter passwordWriter = new BufferedWriter(new FileWriter("D:\\Git\\repository\\Login_System\\Login_System\\src\\loginSys\\Password.txt", true));
					        userNameWriter.write(createUsername);
					        userNameWriter.newLine();
					        passwordWriter.write(createPassword);
					        passwordWriter.newLine();
					    userNameWriter.close();
					    passwordWriter.close();
						txtCreateUserName.setText(null);
						txtCreatePassword.setText(null);
					} catch (Exception e) {
					    e.printStackTrace();
					}
				}
				
			}
		});
		btnSubmitCreds.setBounds(10, 119, 130, 23);
		frame.getContentPane().add(btnSubmitCreds);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(10, 153, 130, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmLoginSystem = new JFrame("Exit");
				if (JOptionPane.showConfirmDialog(frmLoginSystem, "confirm if you want to exit", "Login Systems",
						JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		btnNewButton_2.setBounds(10, 187, 130, 23);
		frame.getContentPane().add(btnNewButton_2);
	}
}
