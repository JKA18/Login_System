package loginSys;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Login_System {

    Component frmLoginSystem;
	private JFrame frame;
	private JTextField txtUsername;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_System window = new Login_System();
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
	public Login_System() {
		initialize();
	}

	public static void findUsername(String[] args) {
		try {
			Scanner findUsername = new Scanner(new File("D:\\\\Git\\\\repository\\\\Login_System\\\\Login_System\\\\src\\\\loginSys\\\\Username.txt"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(200, 200, 500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JList list = new JList();
		list.setBounds(288, 35, 1, 1);
		frame.getContentPane().add(list);
		
		JLabel lblSignIn = new JLabel("Sign In");
		lblSignIn.setBounds(243, 10, 46, 14);
		frame.getContentPane().add(lblSignIn);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(85, 84, 117, 20);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(10, 87, 65, 14);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(10, 155, 46, 14);
		frame.getContentPane().add(lblPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// TODU change txtPassword text box to passwordField widget
				String password = passwordField.getText();
				String username = txtUsername.getText();
		
				if (password.contains("king") && username.contains("one")) {
					passwordField.setText(null);
					txtUsername.setText(null);
					
					Main_Page info = new Main_Page();
					Main_Page.main(null);
					frame.dispose();
					
				}
				else {					
					JOptionPane.showMessageDialog(null,"Invalid Login Details","Login Error", JOptionPane.ERROR_MESSAGE);
					passwordField.setText(null);
					txtUsername.setText(null);
				}
			}
		});
		btnLogin.setBounds(52, 227, 89, 23);
		frame.getContentPane().add(btnLogin);
		
		JButton btnExitSignin = new JButton("Exit");
		btnExitSignin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			frmLoginSystem = new JFrame("Exit");
			if (JOptionPane.showConfirmDialog(frmLoginSystem, "confirm if you want to exit", "Login Systems",
					JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION) {
				System.exit(0);
			}
					
			}
		});
		btnExitSignin.setBounds(354, 227, 89, 23);
		frame.getContentPane().add(btnExitSignin);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				txtUsername.setText(null);
				passwordField.setText(null);
			}
		});
		btnReset.setBounds(200, 227, 89, 23);
		frame.getContentPane().add(btnReset);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(85, 152, 117, 20);
		frame.getContentPane().add(passwordField);
		
		JLabel lblCreateAccount = new JLabel("Create Account");
		  lblCreateAccount.addMouseListener(new MouseAdapter() {
              @Override
              public void mouseClicked(MouseEvent e) {
            	  Account_Creation account_creation = new Account_Creation();
            	  account_creation.NewScreen();
              }

          });
		lblCreateAccount.setForeground(Color.BLUE);
		lblCreateAccount.setBounds(354, 80, 89, 28);
		frame.getContentPane().add(lblCreateAccount);
		
		JLabel lblDntHveAc = new JLabel("Don't have an account?");
		lblDntHveAc.setBounds(229, 87, 140, 14);
		frame.getContentPane().add(lblDntHveAc);
	}
}
