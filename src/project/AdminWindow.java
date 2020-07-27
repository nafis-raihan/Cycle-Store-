package project;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Formatter;
import java.util.Scanner;

import javax.swing.*;

public class AdminWindow implements ActionListener {
	
	private JFrame frame;
	
	private JButton add;
	private JButton delete;
	private JButton search;
	private JButton back;
	
	
	
	public AdminWindow(){
		
		frame = new JFrame();
		
		add = new JButton("ADD");
		add.addActionListener(this);
		
		delete = new JButton("DELETE");
		delete.addActionListener(this);
		
		search = new JButton("SEARCH");
		search.addActionListener(this);
		
		back = new JButton("BACK");
		back.addActionListener(this);
		
		GridLayout g = new GridLayout(4,1);
		frame.setLayout(g);
		frame.setSize(500,400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setTitle("BESHI JOSS! Cycle Store");
		
		frame.add(add);
		frame.add(delete);
		frame.add(search);
		frame.add(back);
		
		frame.setLocation(600, 300);
	
	}
	
	
	

	
	
	
	
		public void actionPerformed(ActionEvent e) {

			if(e.getSource() == add){
				
				
				frame.dispose();
				AddWindow obj1 = new AddWindow();
			}
			
			if(e.getSource() == delete){
			
				
				frame.dispose();
				DeleteWindow obj2 = new DeleteWindow();
			
			}
			
			if(e.getSource()==search){
				
				
				frame.dispose();
				SearchWindow obj3 = new SearchWindow();
			}
			
			
			if(e.getSource() == back){
				
				frame.dispose();
				WelcomeWindow w = new WelcomeWindow();
			}
			
		
		
		}
		
}

	