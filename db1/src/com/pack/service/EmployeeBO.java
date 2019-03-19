package com.pack.service;

import java.util.List;

import com.pack.dao.EmployeeDAO;
import com.pack.model.Employee;

public class EmployeeBO {
	public static void insertEmployee(Employee e)throws Exception{
		EmployeeDAO.insertEmployee(e);
	/*	return ie;*/
	}

	public static void updateEmployee(Employee e1) throws Exception{
		
		// TODO Auto-generated method stub
		EmployeeDAO.updateEmployee(e1);
		/*return i;*/
	}
	
public static void deleteEmployee(int e) throws Exception{
		
		// TODO Auto-generated method stub
		EmployeeDAO.deleteEmployee(e);
		/*return i;*/
	}
public static List<Employee>fetchEmployee() throws Exception{
	List<Employee> l=EmployeeDAO.fetchEmployee();
	return l;
}
}
