import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class ChatServer extends JFrame {

	private JPanel contentPane;
	//private JPanel contentPane;

	private JTextField textField;

	private ServerSocket server;

	private DataInputStream in;

	private DataOutputStream out;

	private final int PORT= 9001;

	JTextArea textArea = new JTextArea();
	private JLabel lblEnterTheMessage;
	private JButton btnSend;


	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChatServer frame = new ChatServer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	private void initialize() throws IOException{

		server = new ServerSocket(PORT);

		textArea.setText("Waiting for the Client to Join the Chat.....");

		Socket socket = server.accept();

	    in =new DataInputStream(socket.getInputStream());

	    out = new DataOutputStream(socket.getOutputStream());

	}

	private void recieveClientMessages() throws IOException{

		String messageRecieved = "";

		while(!messageRecieved.equalsIgnoreCase("exit")){

			messageRecieved = in.readUTF();

			textArea.setText(textArea.getText()+"\n Client :: "+messageRecieved);

		}

	}
	/**
	 * Create the frame.
	 */
	public ChatServer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 548);
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

		textField.setBounds(10, 424, 545, 56);

		contentPane.add(textField);

		textField.setColumns(10);
		
		lblEnterTheMessage = new JLabel("Enter The Message");
		lblEnterTheMessage.setFont(new Font("Arial Black", Font.BOLD, 18));
		lblEnterTheMessage.setBounds(10, 376, 281, 26);
		contentPane.add(lblEnterTheMessage);
		
		btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				sendMessage();
			}
		});
		btnSend.setFont(new Font("Arial Black", Font.BOLD, 15));
		btnSend.setBounds(565, 443, 89, 23);
		contentPane.add(btnSend);

	}
	private void sendMessage(){

		String message = textField.getText();

		try {

			out.writeUTF(message);

			textArea.setText(textArea.getText()+"\n Server :: "+message);

		} catch (IOException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();


	//	JButton btnSend = new JButton("Send");

		//btnSend.addActionListener(new ActionListener() {

			//public void actionPerformed(ActionEvent e) {

			//sendMessage();

			//}

		//});

		//btnSend.setFont(new Font("Lucida Grande", Font.BOLD, 16));

		//btnSend.setBounds(473, 443, 117, 29);

		//contentPane.add(btnSend);

	//}

	
		}
	
	
	}

	
}