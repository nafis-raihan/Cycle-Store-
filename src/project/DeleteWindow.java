package project;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Formatter;
import java.util.Scanner;

import javax.swing.*;

public class DeleteWindow implements ActionListener{
	
	private JFrame frame;
	
	private JLabel positionL;
	
	private JTextField position;
	
	private JButton back;
	private JButton submit;
	
	
	
public DeleteWindow(){
		
		frame = new JFrame();
		
		positionL = new JLabel("Enter Position Number:");
		position  = new JTextField();
		
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
		
		frame.add(positionL);
		frame.add(position);
		
		frame.add(back);
		frame.add(submit);
		
		frame.setLocation(600, 300);        
		
}
	


public void deleteCycle(int pos){

	Fileread fr = new Fileread();
	fr.openFile();
	Cycle temp[] = fr.readfromFile();
	
	
	int i = 0,index = 0;
	for (i = 0; i < temp.length; i++){
		if(temp[i] == null){ // location available
			index = i;
			break;
		}
	}
	System.out.println("In delete "+temp[pos-1]);
	
	
	temp[pos -1] = null;    // deleting Cycle 
	
	Filewrite fw = new Filewrite();
	fw.openFile();
	
	for( i = 0;i <= index;i++)
	{
		
		fw.writetoFile(temp[i]);
	
	}
		
	fw.closeFile();
	
	
	
}



	
public void actionPerformed(ActionEvent e){
		
			if(e.getSource() == back){
				frame.dispose();
				AdminWindow w = new AdminWindow();
			}
			
			if(e.getSource() == submit){
			
				
				int key = 0;
				key =Integer.parseInt( position.getText());
			deleteCycle(key);
			frame.dispose();
			//JOptionPane.showMessageDialog(null,String.format("Cycle %d has been deleted\n",key));
			DeleteWindow dw = new DeleteWindow();
				
				}
			
		}
		
	
}
	


