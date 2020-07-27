package project;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import java.lang.*;


import javax.swing.*;

public class CustomerinfoWindow implements ActionListener {
	
	private String key;
	
	private JFrame frame;
	
	private JLabel nameL;
	private JLabel phoneL;
	
	private JTextField name;
	private JTextField phone;

	
	private JButton submit;
	private JButton back;
	
	public CustomerinfoWindow(String purchasing_model_name){      //purchasing this model(taking as a parameter)
		
		
		key = purchasing_model_name;
		
		frame = new JFrame();
		
		nameL = new JLabel("Customer Name:");
		name = new JTextField();
		
		phoneL = new JLabel("Phone No.");
		phone = new JTextField();

		
		submit = new JButton("Submit");
		submit.addActionListener(this);
		
		back = new JButton("BACK");
		back.addActionListener(this);
		
		GridLayout g = new GridLayout(3,2);
		frame.setLayout(g);
		frame.setSize(500,400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setTitle("BESHI JOSS! Cycle Store");
		
		frame.add(nameL);
		frame.add(name);
		frame.add(phoneL);
		frame.add(phone);
		frame.add(submit);
		frame.add(back);
		
		frame.setLocation(600, 300);    
		
	}

	
	
public void actionPerformed(ActionEvent e){
		
		if(e.getSource() == submit){
			frame.dispose();
			
			String n;
			String p;
			String m;
			
			n = name.getText();
			p = phone.getText();
			m = key;
			
			
			Fileread fr = new Fileread();
			fr.openCustomerFile();
			Customer temp[] = fr.readfromCustomerFile();
			Customer cc = new Customer(n,p,m);
			
			
			int index = 0;
			
			for(int i = 0; i < temp.length; i++){
				if(temp[i] == null){ // location available in Customer File
					index = i;
					break;
				}
			}
			
			if(index < temp.length){
		 		temp[index] = cc;
			}
			
			
			Filewrite fw = new Filewrite();
			
			fw.openCustomerFile();
			for(int i = 0;i <= index;i++){
				
			fw.writetoCustomerFile(temp[i]);
			}
			fw.closeFile();
			
			frame.dispose();
			CustomerWindow cw = new CustomerWindow();
			
		}
		
		
		if(e.getSource() == back){
			frame.dispose();
			CustomerWindow cw = new CustomerWindow();
		}
		
		
			


}

}
