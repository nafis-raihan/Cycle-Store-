package project;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import java.lang.*;

import javax.swing.*;

public class AddWindow implements ActionListener {
	
	private JFrame frame;
	
	private JLabel brandL;
	private JLabel modelL;
	private JLabel categoryL;
	private JLabel priceL;
	
	private JTextField brand;
	private JTextField model;
	private JTextField category;
	private JTextField price;
	
	private JButton Back;
	private JButton submit;
	private JButton clear;
	
	
			
	public AddWindow(){
		
		frame = new JFrame();
		
		brandL = new JLabel("Brand Name:");
		brand = new JTextField();
		
		modelL = new JLabel("Model Name:");
		model = new JTextField();
		
		categoryL = new JLabel("Category Name:");
		category = new JTextField();
		
		priceL = new JLabel("Price :");
		price = new JTextField();
		
		
		Back = new JButton("BACK");
		Back.addActionListener(this);
		
		submit = new JButton("SUBMIT");
		submit.addActionListener(this);
		
		clear = new JButton("CLEAR");
		clear.addActionListener(this);
		
		GridLayout g = new GridLayout(6,2);
		frame.setLayout(g);
		frame.setSize(500,400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setTitle("BESHI JOSS! Cycle Store");
		
		frame.add(brandL);
		frame.add(brand);
		
		frame.add(modelL);
		frame.add(model);
		
		frame.add(categoryL);
		frame.add(category);
		
		frame.add(priceL);
		frame.add(price);
		
		frame.add(Back);
		frame.add(submit);
		frame.add(clear);
		
		
		frame.setLocation(600, 300);
		
	}
	

	
	
	
	public void addCycle(Cycle c){ // adds the Cycle object into array
		// find an available index first
		
		Fileread fr = new Fileread();
		fr.openFile();
		Cycle temp[]  = fr.readfromFile();
		
		
		int index = 0;
		
		for(int i = 0; i < temp.length; i++){
			if(temp[i] == null){ // location available
				index = i;
				break;
			}
		}
		
		if(index < temp.length){
	 		temp[index] = c;
		}
		
		
		Filewrite fw = new Filewrite();
		
		fw.openFile();
		for(int i = 0;i <= index;i++){
			
		fw.writetoFile(temp[i]);
		}
		fw.closeFile();
		
	}
	

	  
	  
	  
		public void actionPerformed(ActionEvent e){
			
			if(e.getSource() == clear){
				brand.setText("");
				model.setText("");
				category.setText("");
				price.setText(" ");
			}
			
			
			if(e.getSource() == Back){
				
				
				frame.dispose();
			
				AdminWindow ww = new AdminWindow();
				
			}
			
			
			
			if(e.getSource() == submit){
				
					String bn = brand.getText();
					String mn = model.getText();
					String cat = category.getText();
					String p = price.getText();
					
					
					
					Cycle temp = new Cycle(bn,mn,cat,p);
					System.out.println(temp);
					System.out.println(bn);
					System.out.println(mn);
					System.out.println(cat);
					System.out.println(p);
					addCycle(temp);
				
					
					frame.dispose();
					AddWindow w = new AddWindow();
				}		
					
					

		}
				
				
				
	

}
