package com.pack.service;

import java.util.List;

import com.pack.model.Student;

public interface StudentService {
public int insertStudent(Student s);
	public List<Student> listAllStudent();
public Student fetchStudentById(String id);
}
