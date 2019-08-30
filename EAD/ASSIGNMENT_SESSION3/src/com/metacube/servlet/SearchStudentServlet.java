package com.metacube.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.Student;
import dao.DatabaseHelper;

public class SearchStudentServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SearchStudentServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String searchname = request.getParameter("searchname");

		ArrayList<Student> listOfStudent = new ArrayList<Student>();

		listOfStudent = DatabaseHelper.searchStudents(searchname);

		displayStudent(listOfStudent,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	private void displayStudent(ArrayList<Student> listOfStudent,
			HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("<title>Show Employees</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1 align=\"center\">Employee Details:</h1>");
		out.println("<h3 align=\"center\">" + listOfStudent.size()
				+ " Employees matched</h3>");
		out.println("<table align=\"center\" cellpadding=\"6\">");
		out.println("<th>");
		out.println("<td><b>First Name</b></td>");
		out.println("<td><b>Last Name</b></td>");
		out.println("<td><b>Father Name</b></td>");
		out.println("<td><b>Email id</b></td>");
		out.println("<td><b>class</b></td>");
		out.println("<td><b>Age</b></td>");
		out.println("</th>");
		int rowCount = 1;
		for (Student student : listOfStudent) {
			out.println("<tr>");
			out.println("<td>" + rowCount + "</td>");
			out.println("<td>" + student.getFirst_name() + "</td>");
			out.println("<td>" + student.getLast_name() + "</td>");
			out.println("<td>" + student.getFather_name() + "</td>");
			out.println("<td>" + student.getEmail_id() + "</td>");
			out.println("<td>" + student.getStudent_class() + "</td>");
			out.println("<td>" + student.getAge() + "</td>");
			out.println("</tr>");
			rowCount++;
		}
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
	}

}
