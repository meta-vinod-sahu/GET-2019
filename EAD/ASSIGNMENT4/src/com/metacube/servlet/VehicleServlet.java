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

import dao.DatabaseHelper;
import pojo.Vehicle;

/**
 * Servlet implementation class VehicleServlet
 */
@WebServlet("/VehicleServlet")
public class VehicleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VehicleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		if(session==null){
			RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
			
			rd.include(request, response);
		}
		else{
			
		}
		PrintWriter out = response.getWriter();
		String name = request.getParameter("vehicle_emp_name");
		String type = request.getParameter("vehicle_type");
		int vehicle_number = Integer.parseInt(request.getParameter("vehicle_number"));
		int employee_id = Integer.parseInt(request.getParameter("vehicle_emp_id"));
		String identification = request.getParameter("vehicle_identification");
		Vehicle v = new Vehicle(name,type,vehicle_number,employee_id,identification);
		if(DatabaseHelper.addVehicle(v)){
			out.println(Output.passDetails(DatabaseHelper.getVehiclePrice(type),employee_id));
			//out.println(Output.passDetails(Helper.getVehiclePrice(type)));
		}else{
			RequestDispatcher rd = request.getRequestDispatcher("/VehiclePage.html");
			out.println("Employee Id doesnt't exist!");
			rd.include(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
