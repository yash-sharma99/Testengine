package com.brainmentor.testengine.util.common;

import java.sql.Connection;
import java.util.ResourceBundle;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface CommonDAO {
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("org.postgresql.Driver");
		ResourceBundle RB = ResourceBundle.getBundle("config");
		
		String  dbUrl = RB.getString("url");
		String userid = RB.getString("userid");
		String password = RB.getString("password");
		Connection con = DriverManager.getConnection(dbUrl,userid,password);
		return con;
		
		
		
		
		
		
	}

}
