package Alexandra_The_Bot;
import java.awt.FlowLayout;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Database 
{
	 private static String jdbcDriver = "com.mysql.jdbc.Driver";
    private static String dbName = "MATRIX_THE_ASSISTANT";
    private static boolean first=false;
    Connection conn=null;
    Statement stmt=null;
    
    
    // a function to check if a database named " ASSISTANT" exists
    public void checkIfDatabaseExists() throws Exception
    {
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SHOW DATABASES");
        boolean present=false;
        while ( rs.next() ) 
        { 
            String r = rs.getString(1); 
            if( r.equals("MATRIX_THE_ASSISTANT")) 
            	present=true;
        } 
        
        if(!present)
        	createDatabase();
      
    }
    // function to establish connection to sql database
    public void setupConnectionToDatabse()
    {
        // register the driver
        try
        {
          Class.forName("com.mysql.jdbc.Driver").newInstance();
        //obtain connection
          conn = DriverManager.getConnection("jdbc:mysql://localhost/?user=root&password=Envirused9");
          
        } 
        catch (Exception ex) 
        {}
        
    }  
    // function to create database if not exists
    public void createDatabase() throws Exception
    {
        
       int Result = stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS "+dbName);
       stmt.executeUpdate("use databse MATRIX_THE_ASSISTANT");
       createAllTables();
    }
  
    // function to create all the required tables by assistant
    public void createAllTables()
    {
      try
      {
         stmt = conn.createStatement();
                
        // create a table for storing folder locations frequently used by user
        String sql1 = "CREATE TABLE FILE_LOCATIONS " +
                   "(id INTEGER not NULL  AUTO_INCREMENT, " +
                   " name VARCHAR(255), " + 
                   " location VARCHAR(255), " + 
                   " PRIMARY KEY ( id ))"; 
        // create table for storing users favourite websites
        String sql2 = "CREATE TABLE FAV_SITES " +
                   "(id INTEGER not NULL  AUTO_INCREMENT, " +
                   " name VARCHAR(255), " + 
                   " url VARCHAR(255), "+ 
                   " PRIMARY KEY ( id ))"; 
        // create a table for storing the Daily tasks of a user
        String sql3 = "CREATE TABLE DAILY_ROUTINE " +
                   "(id INTEGER not NULL  AUTO_INCREMENT, " +                                                               //
                   " taskName VARCHAR(255), " + 
                   " taskTime TIME, "+
                  " priority INTEGER, "+ 
                   " PRIMARY KEY ( id ))"; 
        
        // create a table for things on users mind  
        String sql4 = "CREATE TABLE WHATS_ON_MIND " +
                   "(id INTEGER not NULL  AUTO_INCREMENT, " +
                   " detail VARCHAR(255), " + 
                   " taskTime TIME, "+ 
                   " PRIMARY KEY ( id ))"; 
        
        // create a table users contacts
        String sql5 = "CREATE TABLE USER_CONTACTS " +
                   "(id INTEGER not NULL  AUTO_INCREMENT, " +
                   " name VARCHAR(255), " + 
                   " email VARCHAR(255), " + 
                   " category VARCHAR(255), " + 
                   " phoneNo INTEGER, "+ 
                   " PRIMARY KEY ( id ))"; 
        
        // create a table users schedule
        // ask user whether he wants to set schedule or continue with regular one 
        String sql6 = "CREATE TABLE TODAYS_SCHEDULE " +
                    "(id INTEGER not NULL  AUTO_INCREMENT, " +
                   " taskName VARCHAR(255), " + 
                   " taskTime TIME, "+
                  " priority INTEGER, "+ 
                   " PRIMARY KEY ( id ))"; 
        
        // create a table for storing the to do list of a user
        String sql7 = "CREATE TABLE TO_DO_LIST " +
                   "(id INTEGER not NULL  AUTO_INCREMENT, " +
                   " taskName VARCHAR(255), " + 
                   " taskTime TIME, "+
                  " priority INTEGER, "+ 
                   " PRIMARY KEY ( id ))";
                   
        // create a table for storing the reminders
        String sql8 = "CREATE TABLE REMINDERS " +
                   "(id INTEGER not NULL  AUTO_INCREMENT, " +
                   " reminder VARCHAR(255), " + 
                   " reminderTime TIME, "+
                   " reminderDate DATE, "+
                   " PRIMARY KEY ( id ))";
                   
        // create a table for storing the alarms
        String sql9 = "CREATE TABLE ALARMS " +
                   "(id INTEGER not NULL  AUTO_INCREMENT, " +
                   " alarmName VARCHAR(255), " + 
                   " alarmTime TIME, "+
                   " alarmDate DATE, "+
                   " PRIMARY KEY ( id ))";


       stmt.executeUpdate(sql1);
       stmt.executeUpdate(sql2);
       stmt.executeUpdate(sql3);         
        

          
      }
      catch(Exception e)
      {
        
      } 
    }
  
  // functions for inserting data into tables
  
  void insertIntoDAILY_ROUTINE(String task, Time  time , int priority)
  {
        try
        {
          stmt = conn.createStatement();
                        
          String query="INSERT INTO DAILY_ROUTINE(taskName,taskTime,priority) VALUES('"+task+"','"+time+"','"+priority+"')";
          
        }
        catch(Exception e)
        {
          
        }
  }
  
  public static void main(String[] args)
  {
	  try
      {
		  
		  Database db = new Database();
		  db.setupConnectionToDatabse();
		  db.checkIfDatabaseExists();
		  
      }
      catch(Exception e)
      {
        e.printStackTrace();
      }
	 
  }
	
  
	
	
}
