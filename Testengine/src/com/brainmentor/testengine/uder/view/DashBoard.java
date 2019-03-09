package com.brainmentor.testengine.uder.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.brainmentor.testengine.user.DTO.RightDTO;
import com.brainmentor.testengine.user.DTO.UserDTO;

public class DashBoard extends JFrame {

	
	private JPanel contentPane;
	public void fillDashBoard(UserDTO userdto) {
		
		if(userdto!=null){

		userIDlbl.setText("Welcome "+userdto.getUserName()+" "+userdto.getRoleName()) ;
	    if(userdto.getRights()!=null) {
		
		for(RightDTO right : userdto.getRights()){

			JMenuItem menuItem = new JMenuItem(right.getName());
			System.out.println("rightname"+right);

			menuItem.addActionListener(new ActionListener() {

				

				@Override

				public void actionPerformed(ActionEvent e) {

					// TODO Auto-generated method stub

					System.out.println("Screen Name "+right.getScreenName());

					try{

						int lastIndex = right.getScreenName().lastIndexOf(".java");

						System.out.println("Last Index "+lastIndex);

					String className = right.getScreenName().substring(0,lastIndex);

					System.out.println("ClassName "+className);

					Object object = Class.forName(className).newInstance();

					Method method = object.getClass().getMethod("setVisible", boolean.class);

					

					method.invoke(object, true);

					}

					catch(Exception e1){

						System.out.println("Reflection Problem "+e1);

						e1.printStackTrace();

					}

					}

			});

			menu.add(menuItem);

			

		}

	}
		}
	}
		
			
		
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DashBoard frame = new DashBoard();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	
	
	JMenu menu = new JMenu("File");
	JLabel userIDlbl = new JLabel("");
	
	public DashBoard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		menuBar.add(menu);
		
	//	JMenuItem submenu= new JMenuItem("New");
	//	menu.add("New");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		
		
		userIDlbl.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		userIDlbl.setBounds(17, 56, 334, 51);

		contentPane.add(userIDlbl);
	}

}
