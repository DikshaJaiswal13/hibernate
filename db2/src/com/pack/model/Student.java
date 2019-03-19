package com.pack.model;

public class Student {

public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
public Student() {
		super();
	}
private String id,name,gender,course,address;
public Student(String id, String name, String gender, String course, String address) {
	super();
	this.id = id;
	this.name = name;
	this.gender = gender;
	this.course = course;
	this.address = address;
}
}
