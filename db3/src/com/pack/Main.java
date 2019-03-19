package com.pack;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.pack.model.Employee;
import com.pack.service.EmployeeBO;

public class Main {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
	Scanner s=new Scanner(System.in);
	Random r=new Random();
	
	int ch,num;String name,dob,desg;float sal;
	do{
		System.out.println("#### EMPLOYEE INFO ####");
		System.out.println("Menu");
		System.out.println("1.Add employee");
		System.out.println("2.Update employee");
		System.out.println("3.Delete employee");
		System.out.println("4.View employee");
		System.out.println("Enter choice:");
		ch=Integer.parseInt(s.nextLine());
		switch(ch)
		{
		case 1:
		{
			System.out.println("Enter employee name:");
			name=s.nextLine();
			System.out.println("Enter salary:");
			sal=Float.parseFloat(s.nextLine());
			System.out.println("Enter dob:");
			dob=s.nextLine();
			System.out.println("Enter designation:");
			desg=s.nextLine();
			//Random x=new Random();
			num=r.nextInt(900000)+100000;
			SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
			sdf.setLenient(false);//show exception for wrong date entry
			Date d=null;
			try{
				d=sdf.parse(dob);
			}
			catch(ParseException e)
			{
				System.out.println(e);
			}
			Employee e=new Employee(num,name,sal,d,desg);
			/*int ie=EmployeeBO.insertEmployee(e);
			if(ie==1)
				System.out.println("Employee inserted successfully");*/
			EmployeeBO.insertEmployee(e);
			break;
			
		}
		case 2:
		{	
			System.out.println("Enter employee id:");
			num=Integer.parseInt(s.nextLine());
			System.out.println("Enter salary:");
			sal=Float.parseFloat(s.nextLine());
			System.out.println("Enter designation:");
			desg=s.nextLine();
			Employee e1=new Employee(num,sal,desg);
			/*int i=EmployeeBO.updateEmployee(e1);
			if(i==1)
				System.out.println("updated successfully");*/
			EmployeeBO.updateEmployee(e1);
			break;
		}
		case 3:
		{	
			System.out.println("enter emp id:");
			num=Integer.parseInt(s.nextLine());
			/*
			int i=EmployeeBO.deleteEmployee(num);
			if(i==1)
				System.out.println("deleted successfully");*/
			EmployeeBO.deleteEmployee(num);
			break;
		}
		case 4:
		{
			List<Employee> l=EmployeeBO.fetchEmployee();
			System.out.format("%-10s %-25s %-10s %-10s %-10s\n","EmployeeId","Employee Name","Salary","Date of birth","Designation");
			SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
			for(Employee e:l)
			{
				System.out.format("%-10s %-25s %-10s %-10s %-10s\n",e.getId(),e.getName(),e.getSalary(),sdf.format(e.getDob()),e.getDesignation());
			}
			break;
		}
		default:System.out.println("Wrong choice");
		}
		
	}while(ch<5);
	}

}
