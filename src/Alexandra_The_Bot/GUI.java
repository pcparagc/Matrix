package Alexandra_The_Bot;

import groovy.transform.stc.FirstParam.Component;

import javax.media.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Robot;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.MalformedURLException;

public class GUI 
{

	private Player audioPlayer = null;
	
	public GUI(URL url) throws IOException,NoPlayerException,CannotRealizeException 
	{
	        audioPlayer = Manager.createRealizedPlayer(url);
	        System.out.println("Output was ,,,,,,,,,,null");
	}
	 
	@SuppressWarnings("deprecation")
	public GUI(File file) throws IOException,NoPlayerException,CannotRealizeException 
	{
	        this(file.toURL());
	}
	public void play()
	{
		   audioPlayer.start();
	}
		 
	public void stop() 
	{
		   audioPlayer.stop();
		   audioPlayer.close();
	}
	public static void main(String[] args) 
	{
		try
		{
			
			File audioFile = new File("F://Addicted.mp3");
			GUI player = new GUI(audioFile);
			
			player.play();
			
			
			System.out.println("Output was null");
		}
		catch(Exception e){}
		
		/*
		//
		try
		         	{
		            	// create a player to play the media specified in the URL
		            	Player mediaPlayer = Manager.createRealizedPlayer( mediaURL );
		   
		            	// get the components for the video and the playback controls
		            	Component video = mediaPlayer.getVisualComponent();
		            	Component controls = mediaPlayer.getControlPanelComponent();
		            
		           	if ( video != null )
		               	add( video, BorderLayout.CENTER ); // add video component
		   
		            	if ( controls != null )
		              	add( controls, BorderLayout.SOUTH ); // add controls
		  
		            	mediaPlayer.start(); // start playing the media clip
		         	} // end try
		         	catch ( NoPlayerException noPlayerException )
		         	{
		           	System.err.println( "No media player found" );
	        	} // e
		
		 */
	 }
	
}
