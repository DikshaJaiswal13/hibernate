package com.pack;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcCon {
public static Connection getConnection(){//will create the connection
	Connection con=null;
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","password1$");
	}
	catch(Exception e){
		System.out.println(e);
	}
	return con;
}
}
