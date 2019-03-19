package com.pack.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.pack.DBUtility;
import com.pack.model.Student;

public class StudentDaoImpl implements StudentDao {

	public int insertStudent(Student s) {
		Connection con=null;
		PreparedStatement ps=null;
		int i=0;
		
		try{
			/*con=DBUtility.getConnection();*/
			con=DBUtility.getDataSource().getConnection();
			con.setAutoCommit(false);
			ps=con.prepareStatement("insert into student values(?,?,?,?,?)");
			ps.setString(1, s.getId());
			ps.setString(2, s.getName());
			ps.setString(3, s.getGender());
			ps.setString(4, s.getCourse());
			ps.setString(5, s.getAddress());
			i=ps.executeUpdate();
			con.commit();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally{
			
			try{
				if(con!=null){
					con.close();
					ps.close();
				}
			}
				catch(Exception e){
				System.out.println(e);
				}
			}
		
		return i;
	}

	@Override
	public List<Student> listAllStudent() {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement ps=null;
		List<Student> l=null;
		try{
			/*con=DBUtility.getConnection();*/
			con=DBUtility.getDataSource().getConnection();
			con.setAutoCommit(false);
			ps=con.prepareStatement("select stuid,sname,gender,course,address from student");
			ResultSet rs=ps.executeQuery();
			l=new ArrayList<>();
			while(rs.next()){
				Student st=new Student();
				st.setId(rs.getString("stuid"));
				st.setName(rs.getString("sname"));
				st.setGender(rs.getString("gender"));
				st.setCourse(rs.getString("course"));
				st.setAddress(rs.getString("address"));
				l.add(st);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally{
			
			try{
				if(con!=null){
					con.close();
					ps.close();
				}
			}
				catch(Exception e){
				System.out.println(e);
				}
			}
		
	return l;//return list of students
}

	@Override
	public Student fetchStudentById(String id) {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement ps=null;
		Student st=null;
		try{
			/*con=DBUtility.getConnection();*/
			con=DBUtility.getDataSource().getConnection();
			con.setAutoCommit(false);
			ps=con.prepareStatement("select stuid,sname,gender,course,address from student where stuid=?");
			ps.setString(1,id);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()){
				st=new Student();
				st.setId(rs.getString("stuid"));
				st.setName(rs.getString("sname"));
				st.setGender(rs.getString("gender"));
				st.setCourse(rs.getString("course"));
				st.setAddress(rs.getString("address"));
			}
		}
		catch(Exception e){
			System.out.println(e);
			}
finally{
			
			try{
				if(con!=null){
					con.close();
					ps.close();
				}
			}
				catch(Exception e){
				System.out.println(e);
				}
			}
		return st;
	}
	
	public int removeStudentById(String id) {
		Connection con=null;
		PreparedStatement ps=null;
		int i=0;
		try{
		/*	con=DBUtility.getConnection();*/
			con=DBUtility.getDataSource().getConnection();
			con.setAutoCommit(false);
			ps=con.prepareStatement("delete from student where stuid=?");
			ps.setString(1,id);
			i=ps.executeUpdate();
			con.commit();
		}
		catch(Exception e){
			System.out.println(e);
			}
finally{
			
			try{
				if(con!=null){
					con.close();
					ps.close();
				}
			}
				catch(Exception e){
				System.out.println(e);
				}
			}
		return i;
	
	}
}
