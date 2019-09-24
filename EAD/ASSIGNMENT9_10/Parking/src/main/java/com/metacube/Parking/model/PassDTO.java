/*
 * Contains Plan Details
 */
package com.metacube.Parking.model;

public class PassDTO {
	
	double daily;
	double monthly;
	double yearly;
	
	public PassDTO() {
		super();
	}

	public double getDaily() {
		return daily;
	}

	public void setDaily(double daily) {
		this.daily = daily;
	}

	public double getMonthly() {
		return monthly;
	}

	public void setMonthly(double monthly) {
		this.monthly = monthly;
	}

	public double getYearly() {
		return yearly;
	}

	public void setYearly(double yearly) {
		this.yearly = yearly;
	}

	public PassDTO(double daily, double monthly, double yearly) {
		super();
		this.daily = daily;
		this.monthly = monthly;
		this.yearly = yearly;
	}
}
