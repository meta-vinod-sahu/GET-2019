package com.metacube.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PassServlet
 */
@WebServlet("/PassServlet")
public class PassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PassServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		double price = Double.parseDouble(request.getParameter("plan"));
		String currency = request.getParameter("currency");
		String id = request.getParameter("emp_id");
		if("INR".equals(currency)){}
		else if("USD".equals(currency)){
			price=price*71.73;
		}else{
			price= price*106.27;
		}
		String s="Pass price is : "+price+" and your pass id is E19/"+id;
		out.println(s);
		RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
		//out.println("Pass price is : "+ price+"and your pass id is E19/"+id);
		rd.include(request, response);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
