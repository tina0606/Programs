package com.capg.app.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class WalletUtil {
public static Connection getConnection() throws ClassNotFoundException,SQLException
{
	Class.forName("com.mysql.jdbc.Driver");
	Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/paymentwallet","root", "Capgemini123");
	return conn;
}
	
}
