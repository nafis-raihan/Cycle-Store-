package project;


import java.io.*;
import java.util.*;
import java.lang.*;



public class Fileread {
	private Scanner s;


	Cycle c[] = new Cycle[50];
	Customer cust[] = new Customer[50];



	

	

	void openFile(){
		try{
		s = new Scanner(new File("CR1.txt"));
		}
		catch(Exception e){
			System.out.print("File not found\n");
		}
	}
	
	void openCustomerFile(){
		try{
			s = new Scanner(new File("CustomerInfo.txt"));
			}
			catch(Exception e){
				System.out.print("File not found\n");
			}
	}
	
	
	
	

	public Cycle[] readfromFile(){
		
		try{
		int i = 0;
		
		while(s.hasNext()){
			
		
		String brandname ;
		String modelname ;
		String category ;
		String price ;
		
		brandname = s.next();
		modelname = s.next();
		category  = s.next();
		price     = s.next();
		
		
		c[i] = new Cycle(brandname,modelname,category,price);
		
		System.out.println(c[i]);
		
		i++;
		
		
		}
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
			

		return c;
	}
		


	public Customer[] readfromCustomerFile(){
		
		try{
		int i = 0;
		
		while(s.hasNext()){
			
		
		String name ;
		String phone;
		String model;
		
		name = s.next();
		phone = s.next();
		model = s.next();
		
		
		cust[i] = new Customer(name,phone,model);
		
		System.out.println(cust[i]);
		
		i++;
		
		
		}
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
			

		return cust;
	}
		

	
	

}
