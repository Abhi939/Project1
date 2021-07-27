package com.whatsapp.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.whatsapp.dao.WhatsAppDAO;
import com.whatsapp.dao.WhatsAppDAOInterface;
import com.whatsapp.entity.WhatsappUser;

public class WhatsappController implements WhatsappControllerinterface {
	
	private BufferedReader br;
	private WhatsAppDAOInterface wdao;
	
	public WhatsappController() {
		br=new BufferedReader(new InputStreamReader(System.in));
		wdao=new WhatsAppDAO();
	}
	

	public void createProfileController()throws Exception {
		System.out.println("enter your name");
		String name=br.readLine();
		
		System.out.println("enter your password");
		String password=br.readLine();
		
		System.out.println("enter your email");
		String email=br.readLine();
		
		System.out.println("enter your address");
		String address=br.readLine();
		
		WhatsappUser ws=new WhatsappUser();
		ws.setName(name);
		ws.setAddress(address);
		ws.setEmail(email);
		ws.setPassword(password);
		
		
		int i=wdao.createProfileDAO(ws);//we shoud transfer data from layer to layer via DTO(data transfer object) design pattern
		
		if(i>0) {
			System.out.println("registration success");
		}
		else {
			System.out.println("registration fail");
		}
		
		
		
		
	}

	public void viewProfileController() throws Exception{
		System.out.println("enter your email to view profile");
		String email=br.readLine();
		
		WhatsappUser ws=new WhatsappUser();
		ws.setEmail(email);
		
		WhatsappUser ww=wdao.viewProfile(ws);
		
		if(ww!=null) {
			System.out.println("Name is "+ww.getName());
			System.out.println("Password is "+ww.getPassword());
			System.out.println("Email is "+ww.getEmail());
			System.out.println("Address is "+ww.getAddress());
		}
		else {
			System.out.println("no profile available for given email");
		}
		
		
		
		
	}

	public void deleteProfileController() throws Exception{
		// TODO Auto-generated method stub
		System.out.println("enter your email to delete profile");
		String email=br.readLine();
		
		WhatsappUser ws=new WhatsappUser();
		ws.setEmail(email);
		
		int i=wdao.deleteProfile(ws);
		if(i>0) {
			System.out.println("Delete success");
		}
		else {
			System.out.println("Delete fail");
		}
		
		
		
		
		
	}

	public void viewAllProfileController() throws Exception{
		
		List<WhatsappUser> ww1=wdao.viewAllProfile();
		
		for(WhatsappUser ww:ww1) {
			System.out.println("******************************");
			System.out.println("Name is "+ww.getName());
			System.out.println("Password is "+ww.getPassword());
			System.out.println("Email is "+ww.getEmail());
			System.out.println("Address is "+ww.getAddress());
			System.out.println("******************************");
		}
		
		
		
		
	}

	public void searchProfileController() throws Exception{
		// TODO Auto-generated method stub
		
	}

	public void editProfileController() throws Exception{
		// TODO Auto-generated method stub
		System.out.println("Enter Email to edit");
		String email=br.readLine();
		System.out.println("PRESS 1 TO Change Name");
		System.out.println("PRESS 2 TO Change Password");
		System.out.println("PRESS 3 TO Change Address");
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int c=Integer.parseInt(br.readLine());
		WhatsappUser ws=new WhatsappUser();
		ws.setEmail(email);
		if(c==1)
		{
		System.out.println("enter your new name to edit profile");
		String name=br.readLine();
		ws.setName(name);
		}
		if(c==2)
		{
			System.out.println("enter your new password to edit profile");
			String name=br.readLine();
			ws.setPassword(name);	
		}
		if(c==3)
		{
			System.out.println("enter your new address to edit profile");
			String name=br.readLine();
			ws.setAddress(name);
		}
		int i=wdao.editProfile(ws,c,email);
		if(i>0) {
			System.out.println("Edit success");
		}
		else {
			System.out.println("Edit fail");
		}
		
		
		
	}

}
