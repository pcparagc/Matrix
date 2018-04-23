package Alexandra_The_Bot;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;

import com.darkprograms.speech.microphone.Microphone;
import com.darkprograms.speech.recognizer.GSpeechDuplex;
import com.darkprograms.speech.recognizer.GSpeechResponseListener;
import com.darkprograms.speech.recognizer.GoogleResponse;
import marytts.TextToSpeech;
import marytts.signalproc.effects.JetPilotEffect;
import net.sourceforge.javaflacencoder.FLACFileWriter;

import java.awt.*;  

import javax.swing.*;  

public class Application 
{
	
	private final TextToSpeech tts = new TextToSpeech();
	private final Microphone mic = new Microphone(FLACFileWriter.FLAC);
	private final GSpeechDuplex duplex = new GSpeechDuplex("AIzaSyBOti4mM-6x9WDnZIjIeyEU21OpBXqWBgw");
	private final RobotActions ra = new RobotActions();
	private final Speech speech =new Speech();
	public static JLabel label;
	public static Client client=new Client();
	public final NetworkConnection nc=new NetworkConnection();
	String oldText = "";
	
	
	// Constructor
	public Application() 
	{
		
		//Duplex Configuration
		duplex.setLanguage("en");
		
		duplex.addResponseListener(new GSpeechResponseListener() 
		{
			
			public void onResponse(GoogleResponse googleResponse) 
			{
				String output = "";
				
				//Get the response from Google Cloud
				output = googleResponse.getResponse();
				
				System.out.println(output);
				if (output != null) 
				{
					if(googleResponse.isFinalResponse())
					{
						makeDecision(output);
					} 
					
				} 
				else
					System.out.println("Output was null");
			}
		});
		
		//---------------MaryTTS Configuration-----------------------------
		
		// Setting the Current Voice
		tts.setVoice("cmu-slt-hsmm");
		
		//JetPilotEffect
		JetPilotEffect jetPilotEffect = new JetPilotEffect(); //epic fun!!!
		jetPilotEffect.setParams("amount:100");
		
		//Apply the effects
		//tts.getMarytts().setAudioEffects(jetPilotEffect.getFullEffectAsString());// + "+" + stadiumEffect.getFullEffectAsString());
		
		//Start the Speech Recognition
		startSpeechRecognition();
		 nc.runConnectionThread();
		
	}
	
	// This method makes a decision based on the given text of the Speech Recognition
	
	 
	public void makeDecision(String output) 
	{
		output = output.trim();
		System.out.println(output.trim());
		label.setText(output);
		//   We don't want duplicate responses
		if (!oldText.equals(output))
			oldText = output;
		else
			return;
		
		if (output.contains("hello")) 
		{
			speech.speak("Hi   I  am  matrix. How can i help you ?");
			
			
		} 
		else if (output.contains("pause")) 
		{		
				ra.pressSpace();
		}
		else if (output.contains("open crome") || output.contains("open chrome ") || output.contains("launch chrome") || output.contains("open browser") ) 
		{		
				ra.openChrome();
		} 
		else if (output.contains("go back") || output.contains("back")) 
		{	
			ra.moveBack();
		} 
		else if (output.contains("go forward") || output.contains("forward") ) 
		{
			ra.moveForward();;
		} 
		else if (output.contains("open my computer  ") || output.contains("my computer") ) 
		{ 	
			speech.speak("Opening my computer   ");
			ra.openFileExplorer();
			
		} 
		else if (output.contains("minimize") || output.contains(" minimize everything")  ) 
		{
			speech.speak("minimized  ");
			ra.minimize();
		}
		else if (output.contains("new tab") || output.contains("tab")) 
		{
			ra.spawnTab();
		} 
		else if (output.contains("close tab")) 
		{
			ra.closeTab();
		} 
		else if (output.contains("turn on caps")|| output.contains("capslock")) 
		{
			ra.capsOn();
		}
		else if (output.contains("open eclipse")|| output.contains("launch eclipse") ) 
		{
			
		} 
		else if (output.contains("open unity") || output.contains("launch unity")) 
		{
			
			
		} 
		else if (output.contains("any messages") || output.contains("check messages") || output.contains(" messages")) 
		{
			
		}
		else if (output.contains("open siphon")|| output.contains(" launch siphon")  ) 
		{
			
		} 
		else if (output.contains("disappear")) 
		{
			
		} 
		else if (output.contains("send message")) 
		{
			client.go();
		} 
		else if (output.contains("battery") || output.contains("battery status") ) 
		{
			Kernel32.SYSTEM_POWER_STATUS batteryStatus = new Kernel32.SYSTEM_POWER_STATUS();
			Kernel32.INSTANCE.GetSystemPowerStatus(batteryStatus);
			speech.speak(batteryStatus.toString()); // Shows result of toString() method.
		} 
		else if (output.contains("stop speech recognition") ||  output.contains("stop hearing")  ) 
		{
			stopSpeechRecognition();
			
		} 
		else if (output.contains("bye") ||  output.contains("bye matrix") ||output.contains("by")   ) 
		{   
			
			stopSpeechRecognition();	
			System.exit(0);
		} 
		else if (output.contains("open notepad")) 
		{
			ra.launchNotepad();
		}
		else if (output.contains("open file explorer")||  output.contains("open files") ||  output.contains("open file") ) 
		{
			ra.openExplorer();
		} 
		else if (output.contains("shutdown") || output.contains("shutdown pc")  ) 
		{
			ra.shutdown();
		} 
		else if (output.contains("restart") ||  output.contains("restart pc")) 
		{
			ra.restart();
		} 
		else 
		{ 
			speech.speak("Sorry    can't understand your command ");
			
		}
		
	}
	
	// a function to wish user on opening of the application 
	public void wishUser()
	{
		
		
	}
	
	 
	 
	 
	// Calls the MaryTTS to say the given text
	public void speak(String text) 
	{
		System.out.println(text);
		//Check if it is already speaking
		if (!tts.isSpeaking())
			new Thread(() -> tts.speak(text, 2.0f, true, false)).start();
		
	}
	
	// Starts the Speech Recognition

	public void startSpeechRecognition() 
	{
		//Start a new Thread so our application don't lags
		new Thread(() -> 
		{
			try 
			{
				duplex.recognize(mic.getTargetDataLine(), mic.getAudioFormat());
			} catch (LineUnavailableException | InterruptedException e) 
			{
				e.printStackTrace();
			}
		}).start();
	}
	
	//Stops the Speech Recognition
	public void stopSpeechRecognition() 
	{
		mic.close();
		System.out.println("Stopping Speech Recognition...." + " , Microphone State is:" + mic.getState());
	}
	
	public static void main(String[] args) 
	{
		new Application();
		JFrame frame = new JFrame();
		JPanel panel = new JPanel(); 
		panel.setLayout(new FlowLayout()); 
		 label = new JLabel("JFrame By Example");  
		panel.add(label);  
		frame.add(panel);  
	    frame.setSize(200, 100);  
	    frame.setLocationRelativeTo(null);  
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	    frame.setVisible(true);   
	 }
	
}
