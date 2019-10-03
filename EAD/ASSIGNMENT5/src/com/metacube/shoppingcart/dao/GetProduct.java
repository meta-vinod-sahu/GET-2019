/*
 * Contains Product Stock
 */
package com.metacube.shoppingcart.dao;

import java.util.ArrayList;
import java.util.List;

import com.metacube.shoppingcart.model.Product;

public class GetProduct {

	static List<Product> stock = new ArrayList<Product>();

	/**
	 * Adds and Displays Stock
	 * 
	 * @return stock
	 */
	public static List<Product> showStock() {
		stock.add(new Product(1, "Electronics", "Mobile", 15000));
		stock.add(new Product(1, "Electronics", "Laptop", 55000));
		stock.add(new Product(1, "Clothing", "Pant", 1500));
		stock.add(new Product(1, "Clothing", "Jean", 3500));
		stock.add(new Product(1, "Clothing", "Shirt", 1200));
		return stock;
	}

	/**
	 * Returns Product according to name of Product
	 * 
	 * @param name
	 * @return product
	 */
	public static Product getProduct(String name) {

		switch (name) {
		case "Mobile":
			return stock.get(0);
		case "Laptop":
			return stock.get(1);
		case "Pant":
			return stock.get(2);
		case "Jean":
			return stock.get(3);
		case "Shirt":
			return stock.get(4);
		default:
			return null;
		}
	}
}