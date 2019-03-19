package com.pack.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pack.model.Student;
import com.pack.service.StudentServiceImpl;


/*@WebServlet("/viewStudentController")*/
public class viewStudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public viewStudentController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String id=request.getParameter("name");
		StudentServiceImpl s=new StudentServiceImpl();
		Student st=s.fetchStudentById(id);
		request.setAttribute("stud", st);
		RequestDispatcher rd=request.getRequestDispatcher("/viewStudent.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
