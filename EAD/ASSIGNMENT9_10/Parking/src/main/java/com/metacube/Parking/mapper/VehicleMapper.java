/**
 * Vehicle- Mapper Class
 */
package com.metacube.Parking.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.Parking.model.Vehicle;

public class VehicleMapper implements RowMapper<Vehicle>{

	@Override
	public Vehicle mapRow(ResultSet resultSet, int arg1) throws SQLException {
		Vehicle v = new Vehicle();
		v.setEmployee_id(resultSet.getInt("employee_id"));
		v.setIdentification(resultSet.getString("identification"));
		v.setName(resultSet.getString("name"));
		v.setType(resultSet.getString("type"));
		v.setVehicle_id(resultSet.getInt("vehicle_id"));
		v.setVehicle_number(resultSet.getInt("vehicle_number"));
		return v;
	}
}
