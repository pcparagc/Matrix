package Alexandra_The_Bot;
import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Client
{
	private JTextArea incoming;
	private JTextField outgoing;
	private PrintWriter writer;
	private BufferedReader reader;
	private Socket sock;
	//              {}
	public void go()
	{
		JFrame frame = new JFrame("Chat");
		JPanel panel = new JPanel();
		incoming=new JTextArea(15,50);
		incoming.setEditable(false);
		outgoing= new JTextField(20);
		JButton sendButton = new JButton("SEND");
		sendButton.addActionListener(new SendText());
		JScrollPane scroller =new JScrollPane(incoming);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panel.add(scroller);
		panel.add(outgoing);
		panel.add(sendButton);
		frame.add(BorderLayout.CENTER,panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 500);
		frame.setVisible(true);
		Thread t = new Thread(new GatherMessages());
		t.start();
	}
	// separate modular method for set up the networking stuff 
	public void setSocket()
	{
		try
		{
			// create a socket object representing the connection to the given address and application of the given port
			sock = new Socket("127.0.0.1",55245);
			// A print writer object to write to the socket 
			writer = new PrintWriter(sock.getOutputStream());
			// An input stream object to read from the socket 
			InputStreamReader inputStream=new InputStreamReader(sock.getInputStream());
			reader=new BufferedReader(inputStream);
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		
		
	}
	
	
	
	public static void main(String[] args)
	{
		Client client = new Client();
		client.setSocket();
		client.go();
		
			
	}
	public class SendText implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			
			writer.println(outgoing.getText());
			// flush will tell the buffer to write to the socket even its not full
			writer.flush();
			outgoing.setText("");
			outgoing.requestFocus();
			
		}
		
	}
	//Making an inner class for the purpose of job of the thread of looking for incoming messages
	public class GatherMessages implements Runnable
	{
		// a string to contain the messages read from the buffered reader 
		private String message;
		// the function containing the code to be run by thread
		public void run()
		{
			// reader.readline() throws IOException so try catch block
			try
			{
				while((message = reader.readLine() )!= null)
				{
					// add the incoming message to the incoming text area
					incoming.append(message);
				}
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
			
		}
		
	 }// end of inner class
}
