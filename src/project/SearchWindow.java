package project;



import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Formatter;
import java.util.Scanner;

import javax.swing.*;

public class SearchWindow implements ActionListener{
	
private JFrame frame;
	
	private JLabel keyL;
	
	private JTextField key;
	
	private JButton back;
	private JButton submit;
	
	
	
	public SearchWindow(){
		
		frame = new JFrame();
		
		keyL = new JLabel("Enter Key Number to Search:");
		key  = new JTextField();
		
		back = new JButton("BACK");
		back.addActionListener(this);
		
		submit = new JButton("SUBMIT");
		submit.addActionListener(this);
		
		GridLayout g = new GridLayout(2,1);
		frame.setLayout(g);
		frame.setSize(500,400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setTitle("BESHI JOSS! Cycle Store");
		
		frame.add(keyL);
		frame.add(key);
		
		frame.add(back);
		frame.add(submit);
		
	
		frame.setLocation(600, 300);
	
		
	}
	
	
	

	
	
	
	
	public String findCycle(String key){
		
		Fileread fr = new Fileread();
		fr.openFile();
		Cycle temp[] =fr.readfromFile();
		
		boolean found = false;
		int i = 0;
		for(i = 0; i < temp.length; i++)
		{
			if(temp[i] != null && temp[i].getModelname().equals(key))
			{
				found = true;
				break;
			}
		}
		
		if(found){
			return temp[i].getPrice();
		}
		else{
		
			String tt = "Not Found";
			return tt;
		}
		
		
	}
	
	
	
	public void actionPerformed(ActionEvent e){
		
		if(e.getSource() == back){
			frame.dispose();
			AdminWindow w = new AdminWindow();
		}
		
		if(e.getSource() == submit){
			String n = key.getText();

			String found = findCycle(n);
			
			if(found != "Not Found"){ // matching record exists
				key.setText(found);
			}
			
			else{
				key.setText("Record not found!");
			}
			
			}

	}
}
