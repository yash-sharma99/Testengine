import java.awt.BorderLayout;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

public class calendar extends JFrame {

	private JPanel contentPane;
	JDateChooser dateChooser;

	
	
	//	private JMonthChooser monthChooser;
//    private	JYearChooser yearChooser;
  //  private JCalendar calendar;

	
	
	
	
	public void ok() {
		
	
	//int day= dayChooser.getDay();
		//long month=monthChooser.getMonth();
	//	int year=yearChooser.getYear();
		System.out.println("working100");
         //Calendar Calendar= calendar.getCalendar();
	//	System.out.println();
   
		
		
		
		
		DateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
         Date date= dateChooser.getDate();
         String strDate=sdf.format(date);
         System.out.println("DOB is:"+strDate);
		
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					calendar frame = new calendar();
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
	
	
	//JCalendar calendar = new JCalendar("");

	public calendar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(114, 53, 91, 20);
		contentPane.add(dateChooser);
		
		
		
		
		JButton btnOk = new JButton("ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("working19");

			   ok();
				System.out.println("working17");

			}
		});
		btnOk.setBounds(162, 211, 89, 23);
		contentPane.add(btnOk);
		
		
	}
}
