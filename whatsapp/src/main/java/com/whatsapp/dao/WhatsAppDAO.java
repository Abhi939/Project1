package com.whatsapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.whatsapp.dao.WhatsAppDAOInterface;
import com.whatsapp.entity.WhatsappUser;

public class WhatsAppDAO implements WhatsAppDAOInterface {

	public int createProfileDAO(WhatsappUser ws) {
		int i=0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//step 2 create database connection
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/infosys_db","root","abhi");
			//step3
			//create query
			//if dynamic query then PreparedStatement
			PreparedStatement ps=con.prepareStatement("insert into whatsappuser values(?,?,?,?)");
			ps.setString(1, ws.getName());
			ps.setString(2, ws.getPassword());
			ps.setString(3, ws.getEmail());
			ps.setString(4, ws.getAddress());
			//step 4 execute query
			
			i=ps.executeUpdate(); //if query is insert, delete, update then you will use executeUpdate() method and if select then executeQuery()
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return i;
	}

	public WhatsappUser viewProfile(WhatsappUser ws) {
		WhatsappUser ww=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//step 2 create database connection
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/infosys_db","root","abhi");
			//step3
			//create query
			//if dynamic query then PreparedStatement
			PreparedStatement ps=con.prepareStatement("select * from whatsappuser where email=?");
			ps.setString(1, ws.getEmail());
			
			//step 4 execute query
			
			ResultSet res=ps.executeQuery(); //if query is insert, delete, update then you will use executeUpdate() method and if select then executeQuery()
			if(res.next()) {
				ww=new WhatsappUser();
				ww.setName(res.getString(1));
				ww.setPassword(res.getString(2));
				ww.setEmail(res.getString(3));
				ww.setAddress(res.getString(4));
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return ww;
	}

	public List<WhatsappUser> viewAllProfile() {
		List<WhatsappUser> ll=new ArrayList<WhatsappUser>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//step 2 create database connection
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/infosys_db","root","abhi");
			//step3
			//create query
			//if dynamic query then PreparedStatement
			PreparedStatement ps=con.prepareStatement("select * from whatsappuser");
			
			
			//step 4 execute query
			
			ResultSet res=ps.executeQuery(); //if query is insert, delete, update then you will use executeUpdate() method and if select then executeQuery()
			while(res.next()) {
				WhatsappUser ww=new WhatsappUser();
				ww.setName(res.getString(1));
				ww.setPassword(res.getString(2));
				ww.setEmail(res.getString(3));
				ww.setAddress(res.getString(4));
				
				ll.add(ww);
			}
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return ll;
	}
	
	public int deleteProfile(WhatsappUser ws) {
		int i=0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//step 2 create database connection
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/infosys_db","root","abhi");
			//step3
			//create query
			//if dynamic query then PreparedStatement
			PreparedStatement ps=con.prepareStatement("delete from whatsappuser where email=?");
			ps.setString(1, ws.getEmail());
			
			//step 4 execute query
			
			i=ps.executeUpdate(); //if query is insert, delete, update then you will use executeUpdate() method and if select then executeQuery()
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	
	public int editProfile(WhatsappUser ws,int c,String email)
	{
		int i=0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//step 2 create database connection
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/infosys_db","root","abhi");
			//step3
			//create query
			//if dynamic query then PreparedStatement
			PreparedStatement ps = null;
			if(c==1) {
			ps=con.prepareStatement("update whatsappuser set name=? where email=?");
			ps.setString(1, ws.getName());
			ps.setString(2, ws.getEmail());
			}
			if(c==2) {
				ps=con.prepareStatement("update whatsappuser set password=? where email=?");
				ps.setString(1, ws.getPassword());
				ps.setString(2, ws.getEmail());
				}
			if(c==3) {
				ps=con.prepareStatement("update whatsappuser set address=? where email=?");
				ps.setString(1, ws.getAddress());
				ps.setString(2, ws.getEmail());
				}
			//step 4 execute query
			
			i=ps.executeUpdate(); //if query is insert, delete, update then you will use executeUpdate() method and if select then executeQuery()
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return i;
		
	}

}
