/*
 * Employee DTO
 */
package com.metacube.Parking.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class EmployeeDTO {
		
	@NotBlank
	String full_name ;
	
	String gender; 
	
	@Email
	String email; 
	
	@NotBlank
	@Size(min = 2, max = 30)
	String password; 
	
	@NotBlank
	@Size(min = 2, max = 30)
	String repass;
	
	@NotBlank
	@Pattern(regexp = "[0-9]{10}")
	String contact_number; 
	
	String org;

	public EmployeeDTO() {
		super();
	}

	public String getFull_name() {
		return full_name;
	}

	public String getGender() {
		return gender;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getContact_number() {
		return contact_number;
	}

	public String getOrg() {
		return org;
	}

	public String getRepass() {
		return repass;
	}

	public void setRepass(String repass) {
		this.repass = repass;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setContact_number(String contact_number) {
		this.contact_number = contact_number;
	}

	public void setOrg(String org) {
		this.org = org;
	}

	public EmployeeDTO( String full_name, String gender,String email, String password, String repass, String contact_number,String org) {
		super();
		this.full_name = full_name;
		this.gender = gender;
		this.email = email;
		this.password = password;
		this.repass = repass;
		this.contact_number = contact_number;
		this.org = org;
	}	
	
	public EmployeeDTO( String full_name, String gender,String email, String password, String contact_number,String org) {
		super();
		this.full_name = full_name;
		this.gender = gender;
		this.email = email;
		this.password = password;
		this.contact_number = contact_number;
		this.org = org;
	}	
}
