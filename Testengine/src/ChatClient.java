import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChatClient extends JFrame {

	private JPanel contentPane;

	private JTextField textField;

	private Socket socket ;

	private DataInputStream in;

	private DataOutputStream out;

	private final int PORT= 9001;

	private final String SERVER_NAME = "localhost";

 JTextArea textArea = new JTextArea();
 private JLabel lblEnterTheMessage;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChatClient frame = new ChatClient();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private void initialize() throws IOException{

		socket = new Socket(SERVER_NAME,PORT);

		

	    in =new DataInputStream(socket.getInputStream());

	    out = new DataOutputStream(socket.getOutputStream());

	}

	private void recieveServerMessages() throws IOException{

		String messageRecieved = "";

		while(!messageRecieved.equalsIgnoreCase("exit")){

			messageRecieved = in.readUTF();

			textArea.setText(textArea.getText()+"\n Server :: "+messageRecieved);

		}

	}


	
	/**
	 * Create the frame.
	 */
	public ChatClient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 753, 461);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JScrollPane scrollPane = new JScrollPane();

		scrollPane.setBorder(new LineBorder(new Color(0, 0, 255), 3, true));

		scrollPane.setBounds(31, 23, 572, 288);

		contentPane.add(scrollPane);

		

		

		textArea.setFont(new Font("Lucida Grande", Font.BOLD, 16));

		scrollPane.setViewportView(textArea);

		

		textField = new JTextField();

		textField.setFont(new Font("Lucida Grande", Font.BOLD, 16));

		textField.setBounds(10, 370, 614, 52);

		contentPane.add(textField);

		textField.setColumns(10);
		
		JLabel lblEnterTheMessage_1 = new JLabel("Enter The Message");
		lblEnterTheMessage_1.setFont(new Font("Arial", Font.BOLD, 18));
		lblEnterTheMessage_1.setBounds(31, 332, 181, 27);
		contentPane.add(lblEnterTheMessage_1);
		
		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SendMessage();
			}
		});
		btnSend.setFont(new Font("Arial", Font.BOLD, 17));
		btnSend.setBounds(634, 387, 89, 23);
		contentPane.add(btnSend);
		
		//  lblEnterTheMessage = new JLabel("Enter The Message ");
		//lblEnterTheMessage.setFont(new Font("Arial", Font.BOLD, 15));
	}	//contentPane.add(lblEnterTheMessage, BorderLayout.WEST);
		
		private void SendMessage() {
			String message = textField.getText();

			try {

				out.writeUTF(message);

				textArea.setText(textArea.getText()+"\n Client :: "+message);

			} catch (IOException e) {

				// TODO Auto-generated catch block

				e.printStackTrace();

			}
			
		}
		
		
	}
