package Alexandra_The_Bot;

import java.awt.event.KeyEvent;
import java.awt.AWTException;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.*;

// A class for all the System calls execution (Runtime Class) and invoking KeyPress (Robot Class)
public class RobotActions 
{
	 Runtime runtime; 
	File file = new File("/absolute/path/to/file.vlc");
	static Desktop d= Desktop.getDesktop();
	// constructor
	public RobotActions()
	{
		runtime=Runtime.getRuntime();
	}
	
	public static void main(String[] args)throws  IOException,AWTException, InterruptedException
	{
		//launchNotepad();
		//openFileExplorer();
	}
	// function to launch notepad
	void launchNotepad()
	{try{runtime.exec("notepad");}
	catch(Exception e){}
	}
// a function to open chrome
void openChrome()
{
  try{runtime.exec("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe"); }
  catch(Exception e){}
}

// open file explorer
void openExplorer()
{
  try{ runtime.exec("explorer.exe"); }
  catch(Exception e){}
}
//a funcion to shutdown pc 
void  shutdown()
{
  try{ runtime.exec("shutdown -s -t 3"); System.exit(0);}
  catch(Exception e){}
}
//a funcion to restart pc 
void  restart()
{
  try{ runtime.exec("shutdown -r -t 3"); System.exit(0);}
  catch(Exception e){}
}
	
void openFileExplorer()
	{
		
		try
		{
			Robot rob=new Robot();
			rob.keyPress(KeyEvent.VK_WINDOWS);
			rob.keyPress(KeyEvent.VK_E);
			
		}
		catch(Exception e)
		{
			
		}
	}
}


