/*
 * Service Interface
 */
package com.metacube.Parking.service;

import java.util.List;

import com.metacube.Parking.model.Employee;
import com.metacube.Parking.model.PassDTO;
import com.metacube.Parking.model.Vehicle;

public interface EmployeeService {

	public boolean addEmployee(Employee emp);

	public int getEmployeeId();
	
	public String auth(String email);

	public boolean addVehicle(Vehicle v);

	public PassDTO getPrice(String type);

	public double getValueByCurrency(String plan, String currency);

	public Employee getEmployeeByEmail(String email);

	public boolean updateEmployee(Employee emp);

	public boolean addImage(String imageURL, String email);

	public List<Employee> getFriends(String email);
}
