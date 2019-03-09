package com.brainmentor.testengine.uder.view;

import java.awt.EventQueue;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.apache.log4j.Logger;

import com.brainmentor.testengine.registration.UserRegistration;
import com.brainmentor.testengine.user.DTO.UserDTO;
import com.brainmentor.testengine.user.Dao.userDAO;



public class LoginView extends JFrame {
Logger logger=Logger.getLogger(LoginView.class);
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JLabel usertxt;
	
	private JPasswordField passwordtxt;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView frame = new LoginView();
					frame.logger.debug("Inside Main And Loading LoginView Frame..");
					frame.setVisible(true);
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
     private void registration() {
    	 
 		this.setVisible(false);

 		this.dispose();

 		UserRegistration reg = new UserRegistration();

 		reg.setVisible(true);
    	
 		
     }
	private void checklogin( ) {
		String userid = textField.getText();
		String password= new String(passwordField.getPassword());
		
	//	logger.debug("inside chechlogin and calling dologin"+userid);
	userDAO loginDAO =  new userDAO();
	try {
	//	logger.debug("Inside Check Login and After LoginDAO Message is... "+userid);
		UserDTO userdto=loginDAO.doLogin(userid , password);
		if (userdto==null) {
			JOptionPane.showMessageDialog(this, "Invalid Userid or Password");

			return ;
		}
		//String message = loginDAO.doLogin(userid , password);
	//	logger.debug("Inside Check Login and After LoginDAO Message is... "+userid);
		
		//JOptionPane.showMessageDialog(this, userdto);

		
		DashBoard dashboard = new DashBoard();
		dashboard.fillDashBoard( userdto);
		dashboard.setVisible(true);

		dashboard.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.dispose();

		this.setVisible(false);
		
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		//logger.error(convertPrintStackIntoString(e));
		JOptionPane.showMessageDialog(this, "Contact to System Admin Some DB Problem Occur...");

	//	e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
		// TODO Auto-generated catch block
		//logger.error(convertPrintStackIntoString(e));
		JOptionPane.showMessageDialog(this, "Might be DB change contact to DB admin...");

	//	e.printStackTrace();
	}
	
	}	
	
	private Object convertPrintStackIntoString(ClassNotFoundException e) {
		// TODO Auto-generated method stub
		return null;
	}

 public void reset()
 {
	 textField.setText(null);
	 passwordField.setText(null);
 }
 
	
	
	/**
	 * Create the frame.
	 */
	public LoginView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Arial", Font.BOLD, 25));
		lblLogin.setBounds(77, 25, 332, 39);
		contentPane.add(lblLogin);
		
		JLabel lblUserId = new JLabel("User ID.");
		lblUserId.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserId.setFont(new Font("Arial", Font.BOLD, 22));
		lblUserId.setBounds(32, 75, 123, 39);
		contentPane.add(lblUserId);
		
		textField = new JTextField();
		textField.setBounds(227, 75, 160, 31);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Arial", Font.BOLD, 20));
		lblPassword.setBounds(32, 125, 123, 39);
		contentPane.add(lblPassword);
		passwordField = new JPasswordField();
		passwordField.setBounds(227, 125, 160, 32);
		contentPane.add(passwordField);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setFont(new Font("Arial", Font.BOLD, 16));
		btnReset.setBounds(62, 175, 89, 23);
		contentPane.add(btnReset);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				reset();

			}
		});
	
		JButton button = new JButton("Login");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				checklogin();
				
			}
		});
		button.setFont(new Font("Arial", Font.BOLD, 15));
		button.setBounds(256, 176, 89, 23);
		contentPane.add(button);
		
		JButton btnRegistration = new JButton("Registration");
		btnRegistration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				registration();
			}
		});
		btnRegistration.setFont(new Font("Arial Black", Font.BOLD, 15));
		btnRegistration.setBounds(132, 227, 147, 23);
		contentPane.add(btnRegistration);
		
		
	}
}
