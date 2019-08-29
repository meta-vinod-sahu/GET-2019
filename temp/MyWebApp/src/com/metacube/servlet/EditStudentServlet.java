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
	        
	        Student student=DatabaseHelper.getStudent(id);
	        display(student,response);
	    }

	 private void display(Student student,HttpServletResponse response) throws IOException
	    {
	        response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
	        out.println("<html>");
	        out.println("<head>");
	        out.println("<title>Edit student Details</title>");
	        out.println("</head>");
	        out.println("<body style=\"background-color:#D8D4CC;\">");
	        out.println("<h1 align=\"center\">Edit student Details!!</h1>");
	        out.println("<form action=\"UpdatestudentServlet\">");
	        out.println("<input type=\"hidden\" name=\"id\" value=\""+student.getId()+"\"/>");
	        out.println("<table align=\"center\" cellpadding=\"6\">");
	        out.println("<tr>");
	        out.println("<td><b>First Name</b></td>");
	        out.println("<td><input type=\"text\" name=\"firstName\" value=\""+student.getFirst_name()+"\"/></td>");
	        out.println("</tr>");
	        out.println("<tr>");
	        out.println("<td><b>Last Name</b></td>");
	        out.println("<td><input type=\"text\" name=\"lastName\" value=\""+student.getLast_name()+"\"/></td>");
	        out.println("</tr>");
	        out.println("<td><b>Father Name</b></td>");
	        out.println("<td><input type=\"text\" name=\"fatherName\" value=\""+student.getFather_name()+"\"/></td>");
	        out.println("</tr>");
	        out.println("<tr>");
	        out.println("<td><b>Email</b></td>");
	        out.println("<td><input type=\"text\" name=\"email\" value=\""+student.getEmail_id()+"\"/></td>");
	        out.println("</tr>");
	        out.println("<tr>");
	        out.println("<td><b>Student Class</b></td>");
	        out.println("<td><input type=\"text\" name=\"class\" value=\""+student.getStudent_class()+"\"/></td>");
	        out.println("</tr>");
	        out.println("<tr>");
	        out.println("<td><b>Age</b></td>");
	        out.println("<td><input type=\"text\" name=\"age\" value=\""+student.getAge()+"\"/></td>");
	        out.println("</tr>");
	        out.println("<tr>");
	        out.println("<td colspan=\"2\" align=\"center\"><input type=\"submit\" value=\"Save Info\"/></td>");
	        out.println("</tr>");
	        out.println("</form>");
	        out.println("</table>");
	        out.println("</body>");
	        out.println("</html>");
	    }

}
