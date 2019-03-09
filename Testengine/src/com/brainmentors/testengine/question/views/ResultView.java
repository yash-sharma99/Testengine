package com.brainmentors.testengine.question.views;

import java.awt.BorderLayout;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.brainmentor.testengine.question.dto.MyResultTableModel;
import com.brainmentor.testengine.question.dto.QuestionDTO;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ResultView extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JLabel lblscore;
   // private JLabel lblScore;
	JLabel label = new JLabel();
	/**
	 * Launch the application.
	 */
	//public static void main(String[] args) {
		//EventQueue.invokeLater(new Runnable() {
			//public void run() {
				//try {
					//ResultView frame = new ResultView();
			//		frame.setVisible(true);
	//			} catch (Exception e) {
		//			e.printStackTrace();
			//	}
			//}
		//});
	//}

	/**
	 * Create the frame.
	 * @param i 
	 * @param questions 
	 */
	public ResultView(ArrayList<QuestionDTO> questions, int finalscore) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 535, 341);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblResult = new JLabel("Result");
		lblResult.setFont(new Font("Arial", Font.BOLD, 21));
		lblResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblResult.setBounds(147, 0, 114, 30);
		contentPane.add(lblResult);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 30, 478, 238);
		contentPane.add(scrollPane);
		
		//table = new JTable();
		//table.setBounds(31, 41, 459, 215);
		//table.setModel(new MyResultTableModel(questions));
		//contentPane.add(table);
		table = new JTable();

		table.setModel(new MyResultTableModel(questions));

		scrollPane.setViewportView(table);
		
		
		
	lblscore = new JLabel("Score is "+finalscore);

		lblscore.setFont(new Font("Lucida Grande", Font.PLAIN, 24));	
		

		lblscore.setBounds(78, 382, 175, 35);

		contentPane.add(lblscore);
		
		
		
		
		label.setBounds(175, 286, 46, 14);
		contentPane.add(label);
	
		
	//	JLabel lblScore = new JLabel("Score is" +finalscore);
		//lblScore.setFont(new 21, 2139, 277", Font.BOLD, 15));
		//lblScore.setBounds(	label.setBounds(93, 279, 46, 14);
	//	contentPane.add(label);
	}
}
