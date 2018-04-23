package Alexandra_The_Bot;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Date;

import javax.swing.*;

import com.ibm.icu.text.SimpleDateFormat;

public class Temporary 
{

	public static void main(String[] args)
    {
		Temporary g = new Temporary();
        g.createTextBox();
    }
    
    
    public void createTextBox()
    {
        
        JFrame frame= new JFrame("Enter Daily  Task ");
         JPanel panel=new JPanel();
         JTextArea jt= new JTextArea("",5,20);
         frame.add(panel);
         frame.getContentPane().setBackground(Color.DARK_GRAY);
         panel.add(jt);
         frame.setSize(250,200);
         frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        // choosing time of the task
        
        JSpinner timeSpinner = new JSpinner( new SpinnerDateModel() );
        JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(timeSpinner, "HH:mm");
        timeSpinner.setEditor(timeEditor);
        timeSpinner.setValue(new Date()); // will only show the current time
        frame.add(timeSpinner,BorderLayout.NORTH);
        
        /*
        Date date = new Date();
        SpinnerDateModel sm = new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
        JSpinner spinner = new JSpinner(sm);
        JSpinner.DateEditor de = new JSpinner.DateEditor(spinner, "hh:mm");
        spinner.setEditor(de);
        */
        
        // get the value of selected time
        
        java.util.Date dd =  (java.util.Date) timeSpinner.getValue();
        System.out.println(dd);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        //java.util.Date dd2=  sdf.format(dd);
        //System.out.println(dd2);
    }
    
    

}
