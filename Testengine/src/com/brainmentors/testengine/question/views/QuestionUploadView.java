package com.brainmentors.testengine.question.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.brainmentor.testengine.question.helper.QuestionHelper;

public class QuestionUploadView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuestionUploadView frame = new QuestionUploadView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void Uploadit() {
		JFileChooser jfilechooser = new JFileChooser("C:\\Users\\Yash Sharma\\Documents");	
		jfilechooser.showOpenDialog(this);
		File file = jfilechooser.getSelectedFile();
		System.out.println("Path is "+file.getAbsolutePath());



   QuestionHelper helper =new QuestionHelper();
   try {

		boolean isUploaded = helper.read(file.getAbsolutePath());

		JOptionPane.showMessageDialog(this, isUploaded?"Uploaded Done":"Not Uploaded");

	} catch (IOException e) {

		// TODO Auto-generated catch block

		JOptionPane.showMessageDialog(this,"Can't Upload the File , Contact System Admin") ;

		

		e.printStackTrace();

	}

}	
	/** 
	 * 
	 * 

	 * Create the frame.
	 */
	public QuestionUploadView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JButton btnUpload = new JButton("Upload");
		btnUpload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Uploadit();
			}
		});
		btnUpload.setFont(new Font("Arial Black", Font.BOLD, 25));
		contentPane.add(btnUpload, BorderLayout.NORTH);
	}

}
