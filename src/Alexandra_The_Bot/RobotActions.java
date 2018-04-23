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
	Robot robot;
	// constructor
	public RobotActions()
	{
		
		try
		{
			runtime=Runtime.getRuntime();
			robot=new Robot();
		}
		catch(Exception e){}
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

//a function to open chrome
void openEclipse()
{
try{runtime.exec("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe"); }
catch(Exception e){}
}
//a function to open chrome
void openUnity()
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
			robot.keyRelease(KeyEvent.VK_WINDOWS);
		    robot.keyRelease(KeyEvent.VK_E);
			
		}
		catch(Exception e)
		{
			
		}
	}
// press space for pausing a video or scrolling
void  pressSpace()
{
  try
  { 
    robot.keyPress(KeyEvent.VK_SPACE);
    robot.keyRelease(KeyEvent.VK_SPACE);
  }
  catch(Exception e)
  {}
}
// move back in video or a web browser
void  moveBack()
{
  try
  { 
    robot.keyPress(KeyEvent.VK_ALT);
    robot.keyPress(KeyEvent.VK_LEFT);
    robot.keyRelease(KeyEvent.VK_ALT);
    robot.keyRelease(KeyEvent.VK_LEFT);
   }
  catch(Exception e)
  {}
}
//  move forward in video or a web browser
void  moveForward()
{
  try
  { 
    robot.keyPress(KeyEvent.VK_ALT);
    robot.keyPress(KeyEvent.VK_RIGHT);
    robot.keyRelease(KeyEvent.VK_ALT);
    robot.keyRelease(KeyEvent.VK_RIGHT);
   }
  catch(Exception e)
  {}
}

//  minimize everything
void  minimize()
{
  try
  { 
    robot.keyPress(KeyEvent.VK_WINDOWS);
    robot.keyPress(KeyEvent.VK_D);
    robot.keyRelease(KeyEvent.VK_WINDOWS);
    robot.keyRelease(KeyEvent.VK_D);
   }
  catch(Exception e)
  {}
}
//  new tab in chrome browser
void  spawnTab()
{
  try
  { 
    robot.keyPress(KeyEvent.VK_CONTROL );
    robot.keyPress(KeyEvent.VK_TAB );
    robot.keyRelease(KeyEvent.VK_TAB);
    robot.keyRelease(KeyEvent.VK_CONTROL);
    
   }
  catch(Exception e)
  {}
}

//  close tab in chrome browser
void  closeTab()
{
  try
  { 
    robot.keyPress(KeyEvent.VK_CONTROL );
    robot.keyPress(KeyEvent.VK_W);
    robot.keyRelease(KeyEvent.VK_CONTROL);
    robot.keyRelease(KeyEvent.VK_W);
   }
  catch(Exception e)
  {}
}


//  Turn on capslock
void  capsOn()
{
  try
  { robot.keyPress(KeyEvent.VK_CAPS_LOCK );
    robot.keyRelease(KeyEvent.VK_CAPS_LOCK);
  }
  catch(Exception e)
  {}
}



}


