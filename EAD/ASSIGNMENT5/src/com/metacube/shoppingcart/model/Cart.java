/*
 * Represents Cart
 */
package com.metacube.shoppingcart.model;

import java.util.HashMap;
import java.util.Map;


public class Cart {
	private Map<Product,Integer> products = new HashMap<Product,Integer>();
    private User user = new User();
	private static Cart cart = new Cart();
    
	private Cart(){}
	
	public static Cart getInstance(){
    	return cart;
    }
	
    public void setProducts(Map<Product,Integer>  products) {
		this.products = products;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Map<Product,Integer>  getProducts() {
		return products;
	}

	public User getUser() {
		return user;
	}
}