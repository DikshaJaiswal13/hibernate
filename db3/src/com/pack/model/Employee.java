package com.pack.model;
//persistence class OR POJO CLASS using annotation
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="employee200")
public class Employee {
	
	@Id
	private int id;
	private String name;
	private float salary;
	@Temporal(TemporalType.DATE)
	@Column(name="date_of_birth")
	private Date dob;
	
	private String designation;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	public Employee(int id, float salary, String designation) {
		super();
		this.id = id;
		this.salary = salary;
		this.designation = designation;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int id, String name, float salary, Date dob, String designation) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.dob = dob;
		this.designation = designation;
	}
	
	
}

