package com.pack.dao;

//import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.pack.HibernateUtil;
import com.pack.JdbcCon;
import com.pack.model.Employee;

public class EmployeeDAO {
	public static void insertEmployee(Employee e)throws Exception{
		/*Connection con=JdbcCon.getConnection();
		PreparedStatement ps=con.prepareStatement("insert into employee values(?,?,?,?,?)");
		ps.setInt(1, e.getId());
		ps.setString(2,e.getName());
		ps.setFloat(3, e.getSalary());
		java.sql.Date d1=new java.sql.Date(e.getDob().getTime());//convert util date to sql date
		ps.setDate(4, d1);
		ps.setString(5, e.getDesignation());
		int i=ps.executeUpdate();
		con.close();
		return i;*/
		Session s=HibernateUtil.getSessionFactory().openSession();//WILL CREATE A SESSIONfACTORY .using which we will create a session(by openSession)
		Transaction t=null;
		try{
			t=s.beginTransaction();
			s.save(e);
			System.out.println("employee added successfully");
			t.commit();
		}
		catch(HibernateException e1){
			System.out.println(e1);
			t.rollback();
		}
		finally{
			s.close();//closing the session
		}
		
	}

	public static void updateEmployee(Employee e1)throws Exception {
		
		/*Connection con=JdbcCon.getConnection();
		PreparedStatement ps=con.prepareStatement("update employee set salary=?,designation=? where id=?");
		
		
		ps.setFloat(1, e1.getSalary());
		
		ps.setString(2, e1.getDesignation());
		ps.setInt(3, e1.getId());
		int i=ps.executeUpdate();
		con.close();
		return i;*/
		
		Session s=HibernateUtil.getSessionFactory().openSession();//WILL CREATE A SESSIONfACTORY .using which we will create a session(by openSession)
		Transaction t=null;
		
		try{
			/*System.out.println("dao");*/
			t=s.beginTransaction();
			int id=e1.getId();
			Employee e3=(Employee)s.get(Employee.class,id);
			e3.setSalary(e1.getSalary());
			e3.setDesignation(e1.getDesignation());
			s.update(e3);
			System.out.println("employee updated successfully");
			t.commit();
		}
		catch(HibernateException e2){
			System.out.println(e2);
			t.rollback();
		}
		finally{
			s.close();//closing the session
		}
		
		
	}
	
	public static void deleteEmployee(int e)throws Exception {
	
		/*Connection con=JdbcCon.getConnection();
		PreparedStatement ps=con.prepareStatement("delete from employee where id=?");
		
		
		ps.setInt(1, e);
		int i=ps.executeUpdate();
		con.close();
		return i;*/
		Session s=HibernateUtil.getSessionFactory().openSession();//WILL CREATE A SESSIONfACTORY .using which we will create a session(by openSession)
		Transaction t=null;
		try{
			t=s.beginTransaction();
			
			Employee e1=(Employee)s.get(Employee.class, e);
			
			if(e1!=null){
				s.delete(e1);
				
			System.out.println("employee deleted successfully");
			t.commit();
			}
		}
		catch(HibernateException e1){
			System.out.println(e1);
			t.rollback();
		}
		finally{
			s.close();//closing the session
		}
		
}
	public static List<Employee> fetchEmployee()throws Exception
	{
		Connection con=JdbcCon.getConnection();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from employee200");
		List<Employee> l=new ArrayList<>();//dynamic method dispatch
		while(rs.next())
		{
			//System.out.println("hello");
			Employee e=new Employee();
			e.setId(rs.getInt(1));
			e.setName(rs.getString(2));
			e.setSalary(rs.getFloat(3));
			java.util.Date d1=new java.util.Date(rs.getDate(4).getTime());//convert util date to sql date
			e.setDob(d1);
			e.setDesignation(rs.getString(5));
			l.add(e);//storing emp objects to array list
		}
		return l;
	}
}
