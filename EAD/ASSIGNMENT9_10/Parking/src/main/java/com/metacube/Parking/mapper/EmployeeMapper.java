/*
 * Employee Mapper Class
 */
package com.metacube.Parking.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.Parking.model.Employee;

public class EmployeeMapper implements RowMapper<Employee>{

	@Override
	public Employee mapRow(ResultSet resultSet, int arg1) throws SQLException {
		Employee e = new Employee();
		e.setEmployee_id(resultSet.getInt("employee_id"));
		e.setGender(resultSet.getString("gender"));
		e.setFull_name(resultSet.getString("full_name"));
		e.setEmail(resultSet.getString("email"));
		e.setPassword(resultSet.getString("password"));
		e.setContact_number(resultSet.getString("contact_number"));
		e.setOrg(resultSet.getString("org"));
		return e;	
	}
}
