package project;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import java.lang.*;


import javax.swing.*;


public class WelcomeWindow implements ActionListener{

	private JFrame frame;
	
	private JButton Admin;
	private JButton Customer;
	private JButton Exit;
	
	
	

	public WelcomeWindow(){  
		
		frame = new JFrame();
		
		Admin = new JButton("Admin");
		Admin.addActionListener(this);
		Admin.setToolTipText("Admin Window");
		
		Customer = new JButton("Customer");
		Customer.addActionListener(this);
		Customer.setToolTipText("Customer Window");
		
		Exit = new JButton("Exit");
		Exit.addActionListener(this);
		Exit.setToolTipText("Exits Program");
		
		GridLayout g = new GridLayout(3,1);
		frame.setLayout(g);
		frame.setSize(500,400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setTitle("BESHI JOSS! Cycle Store");
		
		
		frame.add(Admin);
		frame.add(Customer);
		frame.add(Exit);
		
		frame.setLocation(600, 300);
		
	}
	
	

	

	
	
	public void actionPerformed(ActionEvent e){
		
		if(e.getSource() == Admin){
			
			
			String password = "123";
			String pass = JOptionPane.showInputDialog("Enter Password");
			if(pass == null){          //otherwise will throw a null pointer exception if the Panel is closed forcedfully
				pass = "";
			}
			
			if(pass.equals(password)){
				frame.dispose();
				AdminWindow aw = new AdminWindow();
			}
			else{
				JOptionPane.showMessageDialog(null,"INCORRECT password!!!","ERROR",JOptionPane.PLAIN_MESSAGE);
			}
			
			
		}
		
		if(e.getSource() == Customer){
			frame.dispose();
			CustomerWindow cc = new CustomerWindow();
			
			
			}

		if(e.getSource() == Exit){
			
			
			 
			System.exit(0);
		}


	}

}


