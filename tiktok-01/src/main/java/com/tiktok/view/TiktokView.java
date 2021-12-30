package com.tiktok.view;

import java.util.Scanner;

import com.tiktok.controller.TiktokControllerInterface;
import com.tiktok.utility.ControllerFactory;

public class TiktokView {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		String s="y";
		while(s.equals("y")) {
			
			System.out.println("************ WELCOME TO TIKTOK ***********");
			System.out.println("====== MAIN MENU ======");
			System.out.println("press 1 to create profile");
			System.out.println("press 2 to search profile");
			System.out.println("press 3 to view all profiles");
			System.out.println("press 4 to delete profile");
			System.out.println("press 5 to login profile");
			System.out.println("press 6 to edit profile");
			
			int ch=sc.nextInt();
			
		/* note : Always we should use factory design pattern to create object of other layer 
			and should store result inside corresponding interface*/
			
			TiktokControllerInterface lc=ControllerFactory.createObject();
			
			switch(ch) {
			case 1 : int i=lc.createProfileController();
					  if(i>0) {
						  System.out.println("profile created");
					  }
					  else {
						  System.out.println("could not create profile");
					  }
				break;
				
			case 2 : int i1=lc.viewProfileController();
			  if(i1>0) {
				  System.out.println("profile found");
			  }
			  else {
				  System.out.println("could not find profile");
			  }
		break;
			case 3 : int i2=lc.viewAllProfileController();
			  if(i2>0) {
				  System.out.println(i2+ " record found");
			  }
			  else {
				  System.out.println("could not find profile");
			  }
		break;
		
			case 4 : int i3=lc.deleteProfileController();
			  if(i3>0) {
				  System.out.println( " record deleted");
			  }
			  else {
				  System.out.println("could not delete profile");
			  }
		break;
			case 5 : int i4=lc.loginProfileController();
			  if(i4>0) {
				  System.out.println( "profile logged-in successfully");
			  }
			  else {
				  System.out.println("could not login profile");
			  }
		break;
			case 6 : int i5=lc.editProfileController();
			  if(i5>0) {
				  System.out.println( " profile edited successfully");
			  }
			  else {
				  System.out.println("could not edit profile");
			  }
		break;
				default:System.out.println("wrong choice");
			}
			
			System.out.println("............>>>===<<<............");
			System.out.println(" Do you want to continue press y ");
			System.out.println("............>>>===<<<............");
			s=sc.next();
		}

	}

}
