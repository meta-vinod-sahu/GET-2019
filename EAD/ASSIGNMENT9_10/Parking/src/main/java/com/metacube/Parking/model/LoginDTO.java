/*
 * Contains login details of Employee
 */
package com.metacube.Parking.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class LoginDTO {
	
	@Email
	String email;
	
	public LoginDTO() {
		super();
	}

	@NotBlank
	@Size(min = 2, max = 30)
	String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LoginDTO( String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
}
