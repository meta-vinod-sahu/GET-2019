package com.metacube.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DatabaseHelper;
import pojo.Student;

public class EditStudentServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        int id=Integer.parseInt(request.getParameter("id"));
	        PrintWriter out = response.getWriter();
	        out.print(request.getParameter("id"));
	        Student student = new Student();
	        student =DatabaseHelper.getStudent(id);
	        display(student,response);
	    }

	 private void display(Student student,HttpServletResponse response) throws IOException
	    {
	        response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
	        out.println("<html>");
	        out.println("<head>");
	        out.println("<title>Edit student Detail</title>");
	        out.println("</head>");
	        out.println("<body>");
	        out.println("<h1 align='center'>Edit student Details!!</h1>");
	      
	       
	        out.println("<table align='center' cellpadding='6'>");
	        out.println("<form action='UpdateServlet' method='GET'>");
	        out.println("<tr>");
	       
	        out.println("<td><b>First Name</b></td>");
	        out.println("<td><input type='text' name='firstName' value="+student.getFirst_name()+" required></td>");
	        out.println("</tr>");
	        out.println("<tr>");
	        out.println("<td><b>Last Name</b></td>");
	        out.println("<td><input type='text' name='lastName' value="+student.getLast_name()+"required></td>");
	        out.println("</tr>");
	        out.println("<td><b>Father Name</b></td>");
	        out.println("<td><input type='text' name='fatherName' value="+student.getFather_name()+" required></td>");
	        out.println("</tr>");
	        out.println("<tr>");
	        out.println("<td><b>Email</b></td>");
	        out.println("<td><input type='text' name='email' value="+student.getEmail_id()+" required></td>");
	        out.println("</tr>");
	        out.println("<tr>");
	        out.println("<td><b>Student Class</b></td>");
	        out.println("<td><input type='number' name='class' value="+student.getStudent_class()+" required></td>");
	        out.println("</tr>");
	        out.println("<tr>");
	        out.println("<td><b>Age</b></td>");
	        out.println("<td><input type='text' name='age' value="+student.getAge()+" required></td>");
	        out.println("<input type='hidden' name='myid' value="+student.getId()+">");
	        out.println("</tr>");
	        out.println("<tr>");
	        out.println("<td colspan='2' align='center'><input type='submit' value='check'></td>");
	       
	        out.println("</tr>");
	        out.println("</form>");
	        out.println("</table>");
	        out.println("</body>");
	        out.println("</html>");
	    }

}
