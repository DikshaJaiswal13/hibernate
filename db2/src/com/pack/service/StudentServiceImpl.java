package com.pack.service;

import java.util.List;

import com.pack.dao.StudentDaoImpl;
import com.pack.model.Student;

public class StudentServiceImpl implements StudentService {

	
	public int insertStudent(Student s) {
		/*int i=StudentDaoImpl.insertStudent(s);*/
		StudentDaoImpl s1= new StudentDaoImpl();
		int i=s1.insertStudent(s);
		return i;
	}

	@Override
	public List<Student> listAllStudent() {
		StudentDaoImpl st=new StudentDaoImpl();
		List<Student> l=st.listAllStudent();
		return l;
	}

	@Override
	public Student fetchStudentById(String id) {
		// TODO Auto-generated method stub
		StudentDaoImpl st=new StudentDaoImpl();
		Student s=st.fetchStudentById(id);
		return s;
		
	}
	public int removeStudentById(String id){
		StudentDaoImpl st=new StudentDaoImpl();
		int s=st.removeStudentById(id);
		return s;
}
}