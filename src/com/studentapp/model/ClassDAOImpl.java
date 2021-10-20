package com.studentapp.model;
import java.sql.*;
public class ClassDAOImpl {

	private Connection con;
	private Statement stmnt;
	
	

	public void connectDB()  {
				
			try {
				
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_demo_practise", "root", "test");
				stmnt = con.createStatement();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}



	public boolean verifyLoginCredentials(String email, String password) {
		try {
			ResultSet result = stmnt.executeQuery("select * from login where email='"+email+"' and '"+password+"'");
			return result.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

}
