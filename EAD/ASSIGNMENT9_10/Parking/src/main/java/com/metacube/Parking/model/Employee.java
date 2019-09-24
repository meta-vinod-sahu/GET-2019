/*
 * Employee Entity
 */
package com.metacube.Parking.model;

public class Employee {
	
	int employee_id; 
	String full_name ;
	String gender; 
	String email; 
	String password; 
	String repass; 
	String contact_number; 
	String org;

	public Employee() {
		super();
	}

	
	public String getRepass() {
		return repass;
	}


	public void setRepass(String repass) {
		this.repass = repass;
	}


	public int getEmployee_id() {
		return employee_id;
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

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
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

	public Employee(String full_name, String gender,
			String email, String password, String contact_number, String org) {
		super();
		this.full_name = full_name;
		this.gender = gender;
		this.email = email;
		this.password = password;
		this.contact_number = contact_number;
		this.org = org;
	}

	public Employee(int employee_id, String full_name, String gender,
			String email, String password, String contact_number, String org) {
		super();
		this.employee_id = employee_id;
		this.full_name = full_name;
		this.gender = gender;
		this.email = email;
		this.password = password;
		this.contact_number = contact_number;
		this.org = org;
	}
}
