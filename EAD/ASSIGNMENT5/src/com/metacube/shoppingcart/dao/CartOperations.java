/*
 * Interface for Cart Operations
 */
package com.metacube.shoppingcart.dao;

import java.util.Map;

import com.metacube.shoppingcart.model.Product;
import com.metacube.shoppingcart.model.User;

public interface CartOperations {

	public void addProduct(String productName, int quantity);

	public void deleteProduct(String productName, int quantity);

	public Map<Product, Integer> showCart();

	public double showBill();

	public void setUser(User user);

	public User showUser();
}