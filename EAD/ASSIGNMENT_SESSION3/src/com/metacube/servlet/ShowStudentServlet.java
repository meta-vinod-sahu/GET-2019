package com.metacube.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.Student;
import dao.DatabaseHelper;


public class ShowStudentServlet extends HttpServlet {
    
	private static final long serialVersionUID = 1L;



		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        ArrayList<Student> listOfStudent = new ArrayList<Student>();
	        listOfStudent = DatabaseHelper.getAllStudent();
	        displayEmployee(listOfStudent, response);
	    }

	    
	    
	    private void displayEmployee(ArrayList<Student> listOfStudent , HttpServletResponse response) throws IOException
	    {
	        response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
	        out.println("<html>");
	        out.println("<head>");
	        out.println("<title>Show Students</title>");
	        out.println("</head>");
	        out.println("<body>");
	        out.println("<table cellpadding=20 cellspacing=10  >");
	        out.print(" <tr>");
	        out.print("<td ><a href='addstudent.html'>AddStudent</a></td>");
	        out.print("<td ><a href='searchstudent.html'>Search Student</a></td>");
	        out.print("<tr>");
	        out.println("</table>");
	        out.println("<h1 align=\"center\">Student Details:</h1>");
	       
	        out.println("<table cellpadding=20 cellspacing=10 align=center >");
	        out.println("<tr>");
	      
	        out.println("<td><b>First Name</b></td>");
	        out.println("<td><b>Last Name</b></td>");
	        out.println("<td><b>Father Name</b></td>");
	        out.println("<td><b>Email Id</b></td>");
	        out.println("<td><b>Class</b></td>");
	        out.println("<td><b>Age</b></td>");
	        out.println("<td><b>Update Detail</b></td>");
	        
	        out.println("</tr>");
	        int buttonid=0;
	      
	        for(Student student : listOfStudent)
	        {
	        	 out.println("<form action=EditStudentServlet method=GET>");
	            out.println("<tr>");
	           
	            out.println("<td>"+student.getFirst_name()+"</td>");
	            out.println("<td>"+student.getLast_name()+"</td>");
	            out.println("<td>"+student.getFather_name()+"</td>");
	            out.println("<td>"+student.getEmail_id()+"</td>");
	            out.println("<td>"+student.getStudent_class()+"</td>");
	            out.println("<td>"+student.getAge()+"</td>");
	            out.println("<td>"+student.getId()+"</td>");
	            out.println("<td><input type=\"hidden\" name=\"id\" value=\""+student.getId()+"\"/></td>");
	            out.println("<td><input type=\"submit\" value=\"update\"/></td>");
	           
	          
	           
	            out.println("</tr>");
	            out.println("</form>");
	        }
	        out.println("</table>");
	       
	        out.println("</body>");
	        out.println("</html>");
	    }
	
}
