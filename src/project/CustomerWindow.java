package project;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import java.lang.*;


import javax.swing.*;



public class CustomerWindow implements ActionListener{
	
	private JFrame frame;
	
	private JLabel brandL;
	private JLabel modelL;
	private JLabel categoryL;
	private JLabel priceL;
	private JLabel searchL;
	
	private JTextField brand;
	private JTextField model;
	private JTextField category;
	private JTextField price;
	private JTextField searchT;
	
	private JButton back;
	
	private JButton search;
	
	
	
	
	
	public CustomerWindow(){
		
		frame = new JFrame();
		
		brandL = new JLabel("Brand Name:");
		brand = new JTextField();
		
		modelL = new JLabel("Model Name:");
		model = new JTextField();
		
		categoryL = new JLabel("Category Name:");
		category = new JTextField();
		
		priceL = new JLabel("Price :");
		price = new JTextField();
		
		searchL = new JLabel("Search Model:");
		searchT = new JTextField();
		
		back = new JButton("BACK");
		back.addActionListener(this);
		
		search = new JButton("SEARCH");
		search.addActionListener(this);
	
		
	
		
		
		
		GridLayout g = new GridLayout(7,2);
		frame.setLayout(g);
		frame.setSize(500,400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setTitle("BESHI JOSS! Cycle Store");
		
		frame.add(searchL);
		frame.add(searchT);
		frame.add(brandL);
		frame.add(brand);
		frame.add(modelL);
		frame.add(model);
		frame.add(categoryL);
		frame.add(category);
		frame.add(priceL);
		frame.add(price);
		
		
		frame.add(back);
		frame.add(search);
		
		
		frame.setLocation(600, 300);
		
	
	}
	
	
		
	
	public void actionPerformed(ActionEvent e){
		
		if(e.getSource() == back){
			frame.dispose();
			WelcomeWindow w = new WelcomeWindow();
		}
		
		
		
		
		if(e.getSource()==search){
			
			
			Fileread fr = new Fileread();
			fr.openFile();
			Cycle temp[] = fr.readfromFile();
			
			String key = searchT.getText();
			
			int found = 0;
			int i=0,j = 0;
			
			String modelname = null;
			for(i =0 ;i<temp.length; i++)
			{
				if(temp[i] != null && temp[i].getModelname().equals(key))
				{
					found = 1;
					j = i;
					break;
					
					
				}
			}
			
			
			
			
			
			if(found == 0)
			{
				brand.setText("Sorry!! Not Found!! ");
				model.setText("Sorry!! Not Found");
				category.setText("Sorry!! Not Found");
				price.setText("Sorry!! Not Found");
				
			}
			else{
			
			brand.setText(temp[i].getBrandname());
			model.setText(temp[i].getModelname());
			category.setText(temp[i].getCategory());
			price.setText(temp[i].getPrice());
			modelname = temp[i].getModelname();
			frame.dispose();
			CustomerinfoWindow w = new CustomerinfoWindow(modelname);
			
			}
			
			
			
			
		}
		
	
	}
}

