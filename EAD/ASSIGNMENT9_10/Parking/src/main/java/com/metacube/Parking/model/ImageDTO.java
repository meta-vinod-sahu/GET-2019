/*
 * Represents Image of Employee
 */
package com.metacube.Parking.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class ImageDTO {
	
	@NotBlank
	String imageURL;
	
	@Email
	String email;

	public ImageDTO() {
		super();
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ImageDTO(@NotBlank String imageURL, @Email String email) {
		super();
		this.imageURL = imageURL;
		this.email = email;
	}
}
