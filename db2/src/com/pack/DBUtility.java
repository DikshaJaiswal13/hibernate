package com.pack;

import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.commons.dbcp.BasicDataSource;

public class DBUtility {
	/*public static Connection getConnection(){//will create the connection
		Connection con=null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","password1$");
		}
		catch(Exception e){
			System.out.println(e);
		}
		return con;
	}*/
	private static BasicDataSource datasource;
	static{
		try{
			datasource=new BasicDataSource();
			datasource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
			datasource.setUsername("system");
			datasource.setPassword("password1$");
			datasource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
			datasource.setMaxIdle(1000);//max connections in the pool
			datasource.setMinIdle(100);//min connection
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public static BasicDataSource getDataSource(){
		return datasource;
	}
	public static void setDataSource(BasicDataSource datasource){
		DBUtility.datasource=datasource;
	}
}
