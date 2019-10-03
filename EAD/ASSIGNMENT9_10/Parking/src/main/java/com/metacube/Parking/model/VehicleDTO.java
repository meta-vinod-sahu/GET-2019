/*
 * Vehicle DTO
 */
package com.metacube.Parking.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class VehicleDTO {
	
	@NotBlank
	String name ;
	
	@NotBlank
	String type ;
	
	@NotBlank
	@Pattern(regexp="[0-9]+")
	String vehicle_number; 
	
	@NotBlank
	@Pattern(regexp="[0-9]+")
	String employee_id ;
	
	@NotBlank
	String identification ;

	public VehicleDTO() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getVehicle_number() {
		return vehicle_number;
	}

	public void setVehicle_number(String vehicle_number) {
		this.vehicle_number = vehicle_number;
	}

	public String getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}

	public String getIdentification() {
		return identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

	public VehicleDTO( String name, String type,
			String vehicle_number, String employee_id, String identification) {
		super();
		this.name = name;
		this.type = type;
		this.vehicle_number = vehicle_number;
		this.employee_id = employee_id;
		this.identification = identification;
	}
}
