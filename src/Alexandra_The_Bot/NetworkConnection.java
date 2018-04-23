package Alexandra_The_Bot;

import java.net.URL;
import java.net.URLConnection; 



public class NetworkConnection
{
    public boolean connected=false;
    public Speech speech=new Speech();
    //  this functions checks whether the device has the access to internet 
    boolean checkConnection()
    {
       try 
        {
            URL url = new URL("http://www.instanceofjava.com");
            URLConnection connection = url.openConnection();
         
            connection.connect();   
            return true;  
        }
        catch (Exception e)
        {
            return false; 
        }  
        
    }
    
    // function starts a thread that check access to internet after  every 60 seconds
    void runConnectionThread()
    {
        Thread connectionThread= new Thread()
        {
            public void run() 
            {
                if(checkConnection() && !connected)
                {
                    connected=true;
                    // say you are online 
                    speech.speak("You are online");
                }
                if(!checkConnection() && connected)
                {
                    connected=false;
                    // say you are  offline
                    speech.speak("You are offline");
                }
                try 
                {
                	Thread.sleep(60000);  
                }
                catch (Exception e)
                {
                    
                }   
                
                run();
            }
        };
        connectionThread.start();
    }
    
    
    
    
}