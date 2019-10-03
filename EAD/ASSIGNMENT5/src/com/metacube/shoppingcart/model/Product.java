/*
 * Represents Product
 */
package com.metacube.shoppingcart.model;

public class Product {
	private int productCode;
	private String type;
	private String name;
	private double price;
	
	public Product(int productCode, String type, String name, double price) {
		this.productCode = productCode;
		this.type = type;
		this.name = name;
		this.price = price;
	}

	public int getProductCode() {
		return productCode;
	}

	public String getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}
	
	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}