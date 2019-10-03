package com.metacube.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DatabaseHelper;
import pojo.Student;

public class AddStudentServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
		
		   PrintWriter out2 = resp.getWriter();
		   
		   Boolean insert_message;
    	   String first_name = req.getParameter("first_name");
    	   String last_name = req.getParameter("last_name");
    	   String father_name = req.getParameter("father_name");
    	   String email_id = req.getParameter("email_id");
    	   String student_class = req.getParameter("student_class");
    	   int age = Integer.parseInt( req.getParameter("age"));
    	 
    	   Student student = new Student(first_name,last_name,father_name,email_id,student_class,age);
    	  
    	 
    	   insert_message = DatabaseHelper.addStudent(student);
    	   if(insert_message)
    	   {
    		   out2.println("<script>alert('data insert Successfully in database')</script>");
    		   out2.println("<script>window.location = 'index.html'</script>");
    		   
    	   }
    	   else{
    		   out2.println("<script>alert('user already exists')</script>");
    		   out2.println("<script>window.location = 'addstudent.html'</script>");
    	   }
    	
    	  

}
}
