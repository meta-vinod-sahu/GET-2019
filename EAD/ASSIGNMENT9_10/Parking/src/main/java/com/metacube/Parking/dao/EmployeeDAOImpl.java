/*
 * Repository
 */
package com.metacube.Parking.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.metacube.Parking.mapper.EmployeeMapper;
import com.metacube.Parking.mapper.PassMapper;
import com.metacube.Parking.model.Employee;
import com.metacube.Parking.model.PassDTO;
import com.metacube.Parking.model.Vehicle;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	
	
	private JdbcTemplate jdbcTemplate;
	
	private final String ADD_EMP = "Insert into employee(full_name,gender,email,password,contact_number,org) values(?,?,?,?,?,?)";
	private final String GET_EMP_ID =  "Select last_insert_id() as employee_id";
	private final String AUTH = "Select password from employee where email=?";
	private final String ADD_VEH = "Insert into vehicle(name,type,vehicle_number,employee_id,identification) values(?,?,?,?,?)";
	private final String GET_PRICE = "select daily,monthly,yearly from pass where type=?";
	private final String GET_EMP = "Select * from employee where email =?";
	private final String UPD_EMP = "Update employee set full_name=?,gender=?,password=?,contact_number=?,org=? WHERE email=?";
	private final String ADD_IMG = "Insert into image(imageURL,email) values(?,?)";
	private final String GET_FRND = "Select * from employee where org=(select org from employee where email=?)and email !=?";
	
	@Autowired
	public EmployeeDAOImpl(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/**
	 * Adds Employee
	 * @param emp to be added
	 * @return true/false
	 */
	@Override
	public boolean addEmployee(Employee emp) {
		return jdbcTemplate.update(ADD_EMP, emp.getFull_name(), emp.getGender(), emp.getEmail(), emp.getPassword()
				,emp.getContact_number(), emp.getOrg() ) > 0;
	}

	/**
	 * Gets Employee Id
	 * @return id
	 */
	@Override
	public int getEmployeeId() {
		return jdbcTemplate.queryForObject(GET_EMP_ID,Integer.class);
	}

	/**
	 * Authenticates Employee
	 * @param email of employee
	 * @return password
	 */
	@Override
	public String auth(String email) {
		return (String) jdbcTemplate.queryForObject(AUTH, new Object[] { email }, String.class);
	}

	/**
	 * Adds Vehicle
	 * @param v to be added
	 * @return true/false
	 */
	@Override
	public boolean addVehicle(Vehicle v) {
		return jdbcTemplate.update(ADD_VEH, v.getName(), v.getType(), v.getVehicle_number(), v.getEmployee_id(), v.getIdentification()) > 0;
	}

	/**
	 * Gets Pass-Price by type
	 * @param type of vehicle
	 * @return PassDTO 
	 */
	@Override
	public PassDTO getPrice(String type) {
		return jdbcTemplate.queryForObject(GET_PRICE,new Object[] {type}, new PassMapper());
	}

	/**
	 * Gets Employee By Email
	 * @param email of employee
	 * @return employee
	 */
	@Override
	public Employee getEmployeeByEmail(String email) {
		return jdbcTemplate.queryForObject(GET_EMP, new Object[] {email}, new EmployeeMapper()); 
	}

	/**
	 * Updates Employee
	 * @param emp
	 * @return true/false
	 */
	@Override
	public boolean updateEmployee(Employee emp) {
		return jdbcTemplate.update(UPD_EMP, emp.getFull_name(), emp.getGender(), emp.getPassword(), emp.getContact_number()
				, emp.getOrg(), emp.getEmail()) > 0;
	}

	/**
	 * Adds Image of Employee
	 * @param imageURL
	 * @param email
	 * @return true/false
	 */
	@Override
	public boolean addImage(String imageURL, String email) {
		return jdbcTemplate.update(ADD_IMG, imageURL, email) > 0;
	}

	/**
	 * Gets Friends of employee
	 * @param email
	 * @return list of friends
	 */
	@Override
	public List<Employee> getFriends(String email) {
		return jdbcTemplate.query(GET_FRND,new Object[] {email, email}, new EmployeeMapper());
	}
}
