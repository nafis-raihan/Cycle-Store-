package project;


import java.io.*;
import java.util.*;
import java.lang.*;


public class Filewrite {
	

	private Formatter x;
	
	
	public void openFile(){
		try{
		x = new Formatter("CR1.txt");
		}
		catch(Exception e){
			System.out.print("File not found\n");
		}
	}
	
	
	
	public void openCustomerFile(){
		try{
		x = new Formatter("CustomerInfo.txt");
		}
		catch(Exception e){
			System.out.print("File not found\n");
		}
	}
	
	
	
	
	public void writetoFile(Cycle c){
	
		if(c != null)
		{
		String brandname = c.getBrandname();
		String modelname = c.getModelname();
		String category = c.getCategory();
		String price = c.getPrice();
		System.out.println("in write  "+c);
		System.out.println("in write  "+brandname);
		System.out.println("in write  "+modelname);
		System.out.println("in write  "+category);
		System.out.println("in write  "+price);
		
		x.format("%s\n%s\n%s\n%s\n",brandname,modelname,category,price);
		}
		
		
	}
	
	
	
	

	public void writetoCustomerFile(Customer c){
	
		if(c != null)
		{
		String name = c.getName();
		String phone = c.getPhone();
		String model = c.getModel();
		System.out.println("in Customer write  "+name);
		System.out.println("in Customer write  "+phone);
		System.out.println("in Customer write  "+model);
		
		
		x.format("%s\n%s\n%s\n",name,phone,model);
		}
		
		
	}
	
	
	
	void closeFile(){
		x.close();
	}
	
	
	
}
