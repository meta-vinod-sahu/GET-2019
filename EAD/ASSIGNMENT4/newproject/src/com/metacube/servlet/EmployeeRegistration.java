package com.metacube.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojo.Employee;
import dao.DatabaseHelper;

/**
 * Servlet implementation class EmployeeRegistration
 */
@WebServlet("/EmployeeRegistration")
public class EmployeeRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeRegistration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int id =0;
		String employee_name = request.getParameter("employee_name");
		String employee_confirm_password = request.getParameter("employee_confirm_password");
		String organization_type = request.getParameter("organization_type");
		String employee_emailid = request.getParameter("employee_emailid");
		String employee_contact = request.getParameter("employee_contact");
		String employee_gender = request.getParameter("employee_gender");
		String message="";
		
		Employee employee = new Employee(employee_name,employee_confirm_password,employee_emailid,employee_contact,organization_type,employee_gender);
		 id = DatabaseHelper.addEmployee(employee);
		
		/*
		 * if(result){ RequestDispatcher rd =
		 * getServletContext().getRequestDispatcher("/index.jsp");
		 * request.setAttribute("msg","Thank You!"); rd.forward(request,response);
		 * 
		 * 
		 * } else{ RequestDispatcher rd =
		 * getServletContext().getRequestDispatcher("/index.jsp");
		 * 
		 * request.setAttribute("msg","Sorry we could not collect your request!");
		 * rd.forward(request,response); }
		 */
		
		 if(id!=0) {
			 response.setContentType("text/html");
			 PrintWriter pw=response.getWriter();
			 pw.println("<script type=\"text/javascript\">");
			 pw.println("alert('Successfully Registered');");
			 pw.println("</script>");
			 request.setAttribute("id", id);
			 RequestDispatcher rd=request.getRequestDispatcher("vehicle.jsp");
			 rd.include(request, response);
			 HttpSession session = request.getSession(true);
			 session.setAttribute("emailid",employee_emailid);
			 //out.print("<script>var ii=confirm('Successfully Registered! Your Employee Id is'++); if(ii){window.location.href ='vehicle.jsp'}</script>");
			 //RequestDispatcher rd = request.getRequestDispatcher("vehicle.jsp");
				//out.println("Successfully Registered! Your Employee Id is :" +employee_emailid+"");
				//rd.include(request, response);
			 //response.sendRedirect("index.jsp");
			// RequestDispatcher rd = request.getRequestDispatcher("/vehicle.jsp");
				//rd.forward(request, response);
			 
			// session.setMaxInactiveInterval(1*60);
		  //response.sendRedirect("vehicle.jsp"); 
		  }
		 else { 
			 response.sendRedirect("index.jsp?message=<p style='color:red'>User already exist</p>"
		  ); }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
