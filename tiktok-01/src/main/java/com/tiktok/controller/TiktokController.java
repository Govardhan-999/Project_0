package com.tiktok.controller;

import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import com.tiktok.entity.TiktokUser;
import com.tiktok.entity.TimeLineEntity;
import com.tiktok.service.TiktokServiceInterface;
import com.tiktok.utility.ServiceFactory;

public class TiktokController implements TiktokControllerInterface {
	
	private static Logger log1 = Logger.getLogger("TiktokController");

	public int createProfileController() {
		log1.info("inside create profile method");
		Scanner sc=new Scanner(System.in);
		System.out.println("enter name");
		String name=sc.next();
		
		System.out.println("enter password");
		String password=sc.next();
		
		System.out.println("enter email");
		String email=sc.next();
		
		System.out.println("enter address");
		String address=sc.next();
		
		TiktokUser lu=new TiktokUser();
		lu.setName(name);
		lu.setPassword(password);
		lu.setEmail(email);
		lu.setAddress(address);
		
		TiktokServiceInterface ls=ServiceFactory.createObject();
		
		
		return ls.createProfileService(lu);
	}

	private static Logger log2 = Logger.getLogger("TiktokController");
	public int viewProfileController() {
		log2.info("inside view profile method");
		int i=0;
		Scanner sc=new Scanner(System.in);
		System.out.println("enter email");
		String email=sc.next();
		
		TiktokUser lu=new TiktokUser();
		lu.setEmail(email);
		
		TiktokServiceInterface ls=ServiceFactory.createObject();
		TiktokUser lu1=ls.viewProfileService(lu);
		
		if(lu1!=null) {
			System.out.println("Name is "+lu1.getName());
			System.out.println("Password is "+lu1.getPassword());
			System.out.println("Email is "+lu1.getEmail());
			System.out.println("Address is "+lu1.getAddress());
			i=1;
		}
		
		return i;
	}

	private static Logger log3 = Logger.getLogger("TiktokController");
	public int viewAllProfileController() {
		log3.info("inside viewAll profile method");
		TiktokServiceInterface ls=ServiceFactory.createObject();
		List<TiktokUser> lu1=ls.viewAllProfileService();
		
		for(TiktokUser lu2:lu1) {
			System.out.println("*****************************");
			System.out.println("Name is "+lu2.getName());
			System.out.println("Password is "+lu2.getPassword());
			System.out.println("Email is "+lu2.getEmail());
			System.out.println("Address is "+lu2.getAddress());
			
		}
		
		return lu1.size();
	}

	private static Logger log4 = Logger.getLogger("TiktokController");
	public int deleteProfileController() {
		log4.info("inside delete profile method");
		Scanner sc=new Scanner(System.in);
		System.out.println("enter email");
		String email=sc.next();
		
		TiktokUser lu=new TiktokUser();
		lu.setEmail(email);
		
		TiktokServiceInterface ls=ServiceFactory.createObject();
		int lu1=ls.deleteProfileService(lu);
		return lu1;
	}

	private static Logger log5 = Logger.getLogger("TiktokController");
	public int loginProfileController() {
		log5.info(" inside login profile method");
		Scanner sc=new Scanner(System.in);
		
		int i=0;
		
		System.out.println("enter email");
		String email=sc.next();
		
		System.out.println("enter password");
		String password=sc.next();
		
		
		TiktokUser lu=new TiktokUser();
	
		lu.setPassword(password);
		lu.setEmail(email);
		
		
		TiktokServiceInterface ls=ServiceFactory.createObject();
		TiktokUser uu=ls.loginProfileService(lu);
		if(uu!=null) {
			i=1;
			String s="s";
			while(s.equals("s")){
			System.out.println("Welcome "+uu.getName());
			System.out.println("press 1 to view timeline");
			System.out.println("press 2 to LogOut");
			
			System.out.println("enter your choice");
			int cc=sc.nextInt();
			TimeLineEntity tl=new TimeLineEntity();
			Scanner sc1=new  Scanner(System.in);
			
			switch(cc) {
			case 1 :
				System.out.println("enter sender name");
				tl.setSender(sc1.nextLine());
				System.out.println("enter recevier name");
				tl.setReceiver(sc1.nextLine());
				System.out.println("enter message");
				tl.setMessage(sc1.nextLine());
				
				System.out.println("===== message sent sucessfully  to "+tl.getReceiver()+ " ====>>");
				System.out.println("===> new message from "+ tl.getSender());
				System.out.println("Message :::"+ tl.getMessage());
				System.out.println(" do you want to continue press s ");
				s=sc.next();
				break;
			case 2 : 
				System.out.println("LogOut Successfully");
				System.out.println("==== Thank you ====");
				int status = 0;
				System.exit(status);
				break;
		  
			}
		}
			
		}
		
		return i;
		
	}

	private static Logger log6 = Logger.getLogger("TiktokController");
	@Override
	
	public int editProfileController() {
		log6.info("  inside edit profile method");
		Scanner sc=new Scanner(System.in);
		
		int i=0;
		
		System.out.println("enter email");
		String email=sc.next();
		
		System.out.println("enter password");
		String password=sc.next();
		
		
		TiktokUser lu=new TiktokUser();
	
		lu.setPassword(password);
		lu.setEmail(email);
		
		
		TiktokServiceInterface ls=ServiceFactory.createObject();
		int tu=ls.editProfileService(lu);
		if(tu!=0) {
			 i=1;
		}
	 
		return i;
	}

}





