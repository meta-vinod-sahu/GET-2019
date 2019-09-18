/*
 * Pass Mapper Class
 */
package com.metacube.Parking.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.Parking.model.PassDTO;

public class PassMapper implements RowMapper<PassDTO>{

	@Override
	public PassDTO mapRow(ResultSet resultSet, int arg1) throws SQLException {
		PassDTO p = new PassDTO();
		p.setDaily(resultSet.getDouble("daily"));
		p.setMonthly(resultSet.getDouble("monthly"));
		p.setYearly(resultSet.getDouble("yearly"));
		return p;
	}
}
