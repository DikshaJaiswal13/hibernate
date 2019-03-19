package com.pack.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pack.model.Student;
import com.pack.service.StudentServiceImpl;

/**
 * Servlet implementation class StudentController
 */
/*@WebServlet("/StudentController")*/
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentServiceImpl st=new StudentServiceImpl(); 
		List<Student> list=st.listAllStudent();
		request.setAttribute("listStudent", list);
		RequestDispatcher rd=request.getRequestDispatcher("/ListStudent.jsp");
		rd.forward(request, response);
		}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String id=request.getParameter("stuid");
		String name=request.getParameter("sname");
		String gender=request.getParameter("gen");
		String course=request.getParameter("scourse");
		String addr=request.getParameter("sadd");
		Student s=new Student(id,name,gender,course,addr);
		StudentServiceImpl st=new StudentServiceImpl(); 
		int i=st.insertStudent(s);
		if(i==1){
			List<Student> list=st.listAllStudent();
			request.setAttribute("listStudent", list);
			RequestDispatcher rd=request.getRequestDispatcher("/ListStudent.jsp");
			rd.forward(request, response);
		}
	}

}
