package com.brainmentors.testengine.question.views;

import java.awt.EventQueue;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import org.apache.commons.collections4.multiset.SynchronizedMultiSet;

import com.brainmentor.testengine.question.dao.QuestionDAO;
import com.brainmentor.testengine.question.dto.QuestionDTO;
import com.brainmentor.testengine.util.contant.CommonConstants;

public class TakeTestViewView extends JFrame {

	private JPanel contentPane;
    private ArrayList<QuestionDTO> questions;
    ButtonGroup bg= new ButtonGroup();
	private int index;
	private int time = 30;
	private Timer timer1;
	
	private void LoadQuestions()
	{
	QuestionDAO questionDAO = new QuestionDAO();

	try {

		questions = questionDAO.getQuestions();

	} catch (ClassNotFoundException e) {

		// TODO Auto-generated catch block

		JOptionPane.showMessageDialog(this, "Can't Load Questions");

		e.printStackTrace();

	} catch (SQLException e) {

		JOptionPane.showMessageDialog(this, "Can't Load Questions");

		// TODO Auto-generated catch block

		e.printStackTrace();

	}

	

}
	
	 public void printquestions()
	 {
			if(index<questions.size()){
            
				
				SelectAns();
				
			QuestionDTO currentQuestion = questions.get(index);

			QNo.setText(String.valueOf(currentQuestion.getId()));

			Question.setText(currentQuestion.getName());

			Ans1.setText(currentQuestion.getAns1());

			Ans2.setText(currentQuestion.getAns2());

			Ans3.setText(currentQuestion.getAns3());

			Ans4.setText(currentQuestion.getAns4());
              
			EnableDisableButton();
	 }
			
			
			
			
			
	
	 }
	
	     private void SelectAns() {
	    	 if(this.questions.get(index).getYourans()!=null) {
	    		 YourAnswer=this.questions.get(index).getYourans();
	    		 if(YourAnswer.equals("a")) {
	    			 Ans1.setSelected(true);
	    		 }
	    		 else
	    			 if(YourAnswer.equals("b")) {
	    				 Ans2.setSelected(true);
	    			 }
	    
	    			 else
		    			 if(YourAnswer.equals("c")) {
		    				 Ans3.setSelected(true);
		    			 }
		    			 else
			    			 if(YourAnswer.equals("d")) {
			    				 Ans4.setSelected(true);
			    			 }
	    	 
			    				else{

			    					bg.clearSelection();

			    				}
	    	 
	    	 
	    	 }
	     }
	 
	   private void  EnableDisableButton(){
			if(questions.size()==1){

				PreviousButton.setEnabled(false);

				NextButton.setEnabled(false);

			}

			else

			if(index==0){

			PreviousButton.setEnabled(false);

			NextButton.setEnabled(true);

			}

			else

				if(index == questions.size()-1){

					NextButton.setEnabled(false);

					PreviousButton.setEnabled(true);

					

				}

			else

			if(index>0 && index<questions.size()){

				PreviousButton.setEnabled(true);

				NextButton.setEnabled(true);

			}

			
	     }
	     
	     
	     
	 private void fetchAns(int index) {
		 
			if(Ans1.isSelected()){

				YourAnswer = "a";

			}

			else

				if(Ans2.isSelected()){

					YourAnswer = "b";

				}

				else

			if(Ans3.isSelected()){

				YourAnswer = "c";

			}

			else

			if(Ans4.isSelected()){

				YourAnswer = "d";

			}

			this.questions.get(index).setYourans(YourAnswer);

			System.out.println("Question is "+this.questions.get(index));

			YourAnswer="";
		 
		 
	 }
	 
	 
	 
	 
	 
	
	private void ShowTimeLeft() {
		timer1 = new Timer(CommonConstants.DELAY, new ActionListener() {

			

			@Override

			public void actionPerformed(ActionEvent e) {

				timer.setText(String.valueOf(time));

				

				if(time==0){

					

					timer1.stop();

					FinishedTest();

				}

				time--;

			}		

		});

		timer1.start();
	}
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TakeTestViewView frame = new TakeTestViewView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	private void FinishedTest() {
		fetchAns(index);

		

		ResultView rv = new ResultView(questions,checkTest());

		rv.setVisible(true);

		this.setVisible(false);

		this.dispose();
	}
	
	
	private int checkTest() {
		int score = 0;

		for(QuestionDTO questionDTO : questions){

			if(!questionDTO.getRans().equals(questionDTO.getYourans())){

				questionDTO.setScore(0);
				//System.out.println("score dont get");

			}

			score += questionDTO.getScore();

		}
//System.out.println("getscore");
		return score;
	}
	
	JLabel Question = new JLabel("");
	JLabel QNo = new JLabel("");
	JRadioButton Ans1 = new JRadioButton("");
	JRadioButton Ans2= new JRadioButton("");
	JRadioButton Ans3= new JRadioButton("");
	JRadioButton Ans4 = new JRadioButton("");
	JButton PreviousButton = new JButton("Previous");
	JButton NextButton = new JButton("Next");
private final	JLabel timer = new JLabel("0");
private final	JLabel lblTimeLeft = new JLabel("Time Left");
private final	JButton btnFinishedTest = new JButton("Finished Test");
private String YourAnswer = "";
	
	
	
	
	
	/**
	 * Create the frame.
	 */
	public TakeTestViewView() {
		bg.add(Ans1);

		bg.add(Ans2);

		bg.add(Ans3);

		bg.add(Ans4);
		LoadQuestions();
		printquestions();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 513, 333);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	
		Question.setBounds(72, 32, 415, 58);
		contentPane.add(Question);
		
		
		QNo.setBounds(10, 43, 52, 32);
		contentPane.add(QNo);
		
		
		
		Ans1.setBounds(28, 105, 171, 32);
		contentPane.add(Ans1);
		
		
		Ans2.setBounds(28, 140, 171, 32);
		contentPane.add(Ans2);
		
		
		Ans3.setBounds(28, 175, 171, 32);
		contentPane.add(Ans3);
		
	
		Ans4.setBounds(28, 210, 171, 32);
		contentPane.add(Ans4);
		PreviousButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				index=index + -1;
				fetchAns(index);
				printquestions();
				
				
				
			}
		});
		
		
		PreviousButton.setBounds(36, 260, 89, 23);
		contentPane.add(PreviousButton);
		NextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (index==0) {
					fetchAns(index);
					index =index+1;
				}
				
				else {
					fetchAns(index);
					index=index+1;
				}
				
				
				printquestions();
			}
		});
		
		
		NextButton.setBounds(235, 260, 89, 23);
		contentPane.add(NextButton);
	
		
		
		timer.setFont(new Font("Tahoma", Font.BOLD, 17));
		timer.setHorizontalAlignment(SwingConstants.RIGHT);
		timer.setBounds(441, 3, 46, 23);
		contentPane.add(timer);
		
		
		lblTimeLeft.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTimeLeft.setBounds(360, 7, 89, 14);
		contentPane.add(lblTimeLeft);
		
		
		
		btnFinishedTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	          FinishedTest();	
			}
		});
		
		
		
		
		btnFinishedTest.setBounds(370, 260, 89, 23);
		contentPane.add(btnFinishedTest);
		
		ShowTimeLeft();
		
		


}
}