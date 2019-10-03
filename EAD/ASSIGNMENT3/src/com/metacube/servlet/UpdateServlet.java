package com.metacube.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DatabaseHelper;

public class UpdateServlet extends HttpServlet{
 
	private static final long serialVersionUID = 102831973239L;
	
	
	public UpdateServlet() {
		super();
		
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 	int id=Integer.parseInt(request.getParameter("myid"));
	        String firstName=request.getParameter("firstName");
	        String lastName = request.getParameter("lastName");
	        String fatherName = request.getParameter("fatherName");
	        String email = request.getParameter("email");
	        String studentClass = request.getParameter("class");
	        int age = Integer.parseInt(request.getParameter("age"));
	        PrintWriter out = response.getWriter();
	         
	        int updatedRows=DatabaseHelper.updateStudent(id,firstName,lastName,fatherName,email,studentClass,age);
	        if(updatedRows==1)
	        {
	            out.println("<script>alert('Data updated successfully!! rows:: "+updatedRows+"')</script>");
	             RequestDispatcher dispatcher=request.getRequestDispatcher("/index.html");
		           dispatcher.include(request, response);
	        } 
	        else
	        {
	            out.println("<script>alert('Data updation failed!!rows:: "+updatedRows+"')</script>");
	         
	        }
	}
}
