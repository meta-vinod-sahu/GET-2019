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
	        out.println("<title>Show Employees</title>");
	        out.println("</head>");
	        out.println("<body style=\"background-color:#D8D4CC;\">");
	        out.println("<h1 align=\"center\">Employee Details:</h1>");
	        out.println("<form action=\"EditEmployeeServlet\">");
	        out.println("<table align=\"center\" cellpadding=\"6\">");
	        out.println("<th>");
	        out.println("<td><b>First Name</b></td>");
	        out.println("<td><b>Last Name</b></td>");
	        out.println("<td><b>Email</b></td>");
	        out.println("<td><b>Age</b></td>");
	        out.println("</th>");
	        int rowCount=1;
	        for(Student student : listOfStudent)
	        {
	            
	            out.println("<tr>");
	            out.println("<form action=\"EditEmployeeServlet\">");
	            out.println("<td>"+rowCount+"</td>");
	            out.println("<td>"+student.getId()+"</td>");
	            out.println("<td>"+student.getFirst_name()+"</td>");
	            out.println("<td>"+student.getLast_name()+"</td>");
	            out.println("<td>"+student.getFather_name()+"</td>");
	            out.println("<td>"+student.getEmail_id()+"</td>");
	            out.println("<td>"+student.getStudent_class()+"</td>");
	            out.println("<td>"+student.getAge()+"</td>");
	            out.println("<td><input type=\"submit\" value=\"update\"/></td>");
	            out.println("<td><input type=\"hidden\" name=\"id\" value=\""+student.getId()+"\"/></td>");
	            out.println("</form>");
	            out.println("</tr>");
	            rowCount++;
	        }
	        out.println("</table>");
	        out.println("</form>");
	        out.println("</body>");
	        out.println("</html>");
	    }
	
}
