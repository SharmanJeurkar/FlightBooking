package com.FlightBooking.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login_services {
	public boolean check(String name, String password) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Booking","Sharman","1234");
			String sql="select*from admin_login where name=? password=?";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1, name);
			pst.setString(2,password);
			ResultSet rs=pst.executeQuery();
			if(rs.next()) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("Error : "+e);
		}
		return false;
	}
	
}
