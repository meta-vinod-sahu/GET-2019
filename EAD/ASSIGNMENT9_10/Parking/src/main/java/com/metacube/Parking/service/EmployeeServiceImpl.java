/*
 * Service Class
 */
package com.metacube.Parking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.metacube.Parking.dao.EmployeeDAO;
import com.metacube.Parking.model.Employee;
import com.metacube.Parking.model.PassDTO;
import com.metacube.Parking.model.Vehicle;



public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDAO employeeDAO;

	/**
	 * Adds Employee
	 * @param emp to be added
	 * @return true/false
	 */
	@Override
	public boolean addEmployee(Employee emp) {
		return employeeDAO.addEmployee(emp);
	}

	/**
	 * Gets Employee Id
	 * @return id
	 */
	@Override
	public int getEmployeeId() {
		return employeeDAO.getEmployeeId();
	}

	/**
	 * Authenticates Employee
	 * @param email of employee
	 * @return password
	 */
	@Override
	public String auth(String email) {
		return employeeDAO.auth(email);
	}

	/**
	 * Adds Vehicle
	 * @param v to be added
	 * @return true/false
	 */
	@Override
	public boolean addVehicle(Vehicle v) {
		return employeeDAO.addVehicle(v);
	}

	/**
	 * Gets Pass-Price by type
	 * @param type of vehicle
	 * @return PassDTO 
	 */
	@Override
	public PassDTO getPrice(String type) {
		return employeeDAO.getPrice(type);
	}

	/**
	 * Returns Price by currency
	 * @param plan
	 * @param currency
	 * @return price
	 */
	@Override
	public double getValueByCurrency(String plan, String currency) {
		double price = Double.parseDouble(plan);
		if("USD".equals(currency)){}
		else if("INR".equals(currency)){
			price=price*71.73;
		}else{
			price= price*106.27;
		}
		
		return price;
	}

	/**
	 * Gets Employee By Email
	 * @param email of employee
	 * @return employee
	 */
	@Override
	public Employee getEmployeeByEmail(String email) {
		return employeeDAO.getEmployeeByEmail(email);
	}

	/**
	 * Updates Employee
	 * @param emp
	 * @return true/false
	 */
	@Override
	public boolean updateEmployee(Employee emp) {
		return employeeDAO.updateEmployee(emp);
	}

	/**
	 * Adds Image of Employee
	 * @param imageURL
	 * @param email
	 * @return true/false
	 */
	@Override
	public boolean addImage(String imageURL, String email) {
		return employeeDAO.addImage(imageURL,email);
	}

	/**
	 * Gets Friends of employee
	 * @param email
	 * @return list of friends
	 */
	@Override
	public List<Employee> getFriends(String email) {
		return employeeDAO.getFriends(email);
	}
}
