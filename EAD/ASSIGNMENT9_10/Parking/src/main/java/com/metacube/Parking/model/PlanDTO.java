/*
 * Contains Pass Details
 */
package com.metacube.Parking.model;

import javax.validation.constraints.NotBlank;

public class PlanDTO {
	
	@NotBlank
	String plan;
	
	@NotBlank
	String currency;

	public PlanDTO() {
		super();
	}

	public PlanDTO(String plan, String currency) {
		super();
		this.plan = plan;
		this.currency = currency;
	}

	public String getPlan() {
		return plan;
	}
	
	public void setPlan(String plan) {
		this.plan = plan;
	}
	
	public String getCurrency() {
		return currency;
	}
	
	public void setCurrency(String currency) {
		this.currency = currency;
	}
}
