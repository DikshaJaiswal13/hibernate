package com.pack;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Main1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
try{
	Connection con=JdbcCon.getConnection();
	PreparedStatement ps=con.prepareStatement("insert into employees (id,ename,salary,designation)values(?,?,?,?)");
	ps.setInt(1, 10888);
	ps.setString(2,"aaaa");
	ps.setFloat(3, 20000);
	ps.setString(4, "Member");
	ps.addBatch();
	ps.setInt(1, 268760);
	ps.setString(2,"aaaa");
	ps.setFloat(3, 20000);
	ps.setString(4, "Member");
	ps.addBatch();
	ps.setInt(1, 39860);
	ps.setString(2,"aaaa");
	ps.setFloat(3, 207677);
	ps.setString(4, "Member");
	ps.addBatch();
}
catch(Exception e){
	
}
	}
//rs.absolute(2);
//rs.deleterow();
//RS.ABSOLUTE(1);
//rs.moveTOiNSERTrOW();
//RS.UPDATEINT(1,10000);
//RS.UPDATE(2,6786242);
//RS.INSERTROW();
//RS.MOVETOCURRENTROW(); 
}
