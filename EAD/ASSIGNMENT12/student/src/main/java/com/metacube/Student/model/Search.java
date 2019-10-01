/**
 * Search data transfer object
 */
package com.metacube.Student.model;

import javax.validation.constraints.NotBlank;

public class Search {
	
	@NotBlank
	String key;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Search(@NotBlank String key) {
		super();
		this.key = key;
	}

	public Search() {
		super();
	}
}
