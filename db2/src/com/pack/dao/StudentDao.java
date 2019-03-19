package com.pack.dao;

import java.util.List;

import com.pack.model.Student;

public interface StudentDao {
public int insertStudent(Student s);

public List<Student> listAllStudent();
public Student fetchStudentById(String id);
public int removeStudentById(String id);
}
