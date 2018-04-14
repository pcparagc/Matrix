package Alexandra_The_Bot;

import gov.noaa.pmel.sgt.dm.Annote.Line;

import javax.sound.sampled.*;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;
import javax.sound.sampled.Line.Info;;
public class VolumeControl 
{

	public static void main(String[] args) 
	{
		/*
		Port lineIn=null;
		FloatControl volCtrl=null; 
		Mixer mixer;
		try 
		{
			 mixer = AudioSystem.getMixer(null);
			  lineIn = (Port)mixer.getLine(Port.Info.LINE_IN);
			  lineIn.open();
			  volCtrl = (FloatControl) lineIn.getControl(FloatControl.Type.VOLUME);
         }
		catch (Exception e) 
		{
			  System.out.println("Failed trying to find LINE_IN"
			    + " VOLUME control: exception = " + e);
		}
		//FloatControl gainControl = (FloatControl) lineIn.getControl(FloatControl.Type.MASTER_GAIN);
		volCtrl.setValue(-10.0f); // Reduce volume by 10 decibels.
		*/
		System.out.println("heu");
		Mixer.Info[] mixers = AudioSystem.getMixerInfo();
	    //System.out.println("There are " + mixers.length + " mixer info objects");
	    for (Mixer.Info mixerInfo : mixers) 
	    {
	        //System.out.println("mixer name: " + mixerInfo.getName());
	        Mixer mixer = AudioSystem.getMixer(mixerInfo);
	        Info[] lineInfos = mixer.getTargetLineInfo(); // target, not source  
	        //changes all the volumes

	        for (Info lineInfo : lineInfos) 
	        {
	            //System.out.println("  Line.Info: " + lineInfo);
	            javax.sound.sampled.Line line = null;
	            boolean opened = true;
	            try {
	                line = mixer.getLine(lineInfo);
	                opened = line.isOpen() || line instanceof Clip;
	                if (!opened) 
	                {
	                    line.open();
	                }
	                FloatControl volCtrl = (FloatControl) line.getControl(FloatControl.Type.VOLUME);
	                float volume= 100;
					//System.out.println(volCtrl.getMinimum());
	                volCtrl.setValue((float) volume);
	                //System.out.println("    volCtrl.getValue() = " + volCtrl.getValue());
	            } 
	            catch (LineUnavailableException e)
	            {
	                e.printStackTrace();
	            } 
	            catch (IllegalArgumentException iaEx) 
	            {
	                //System.out.println("  -!-  " + iaEx);
	            } 
	            finally 
	            {
	                if (line != null && !opened) 
	                {
	                    line.close();
	                }
	            }
	        }
	    }
	
	}
	

	
}
