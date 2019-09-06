/*
 * Implements Cart Operation Interface
 * Singleton Class
 */
package com.metacube.shoppingcart.dao;

import java.util.Map;

import com.metacube.shoppingcart.model.Cart;
import com.metacube.shoppingcart.model.Product;
import com.metacube.shoppingcart.model.User;

public class CartOperationsImpl implements CartOperations {

	private static CartOperationsImpl c = new CartOperationsImpl();

	private CartOperationsImpl() {
	}

	/**
	 * Returns singleton instance of class
	 * 
	 * @return instance
	 */
	public static CartOperationsImpl getInstance() {
		return c;
	}

	/**
	 * Adds Product to Cart
	 * 
	 * @param productName
	 * @param quantity
	 */
	@Override
	public void addProduct(String productName, int quantity) {
		Product product = GetProduct.getProduct(productName);
		Cart.getInstance().getProducts().put(product, quantity);
	}

	/**
	 * Deletes product from Cart
	 * 
	 * @param productName
	 * @param quantity
	 */
	@Override
	public void deleteProduct(String productName, int quantity) {
		Product product = GetProduct.getProduct(productName);
		Map<Product, Integer> products = Cart.getInstance().getProducts();
		if (quantity == 0) {
			products.remove(product);
		} else {
			products.replace(product, quantity);
		}
	}

	/**
	 * Displays Cart
	 * 
	 * @return Cart Items
	 */
	@Override
	public Map<Product, Integer> showCart() {
		return Cart.getInstance().getProducts();
	}

	/**
	 * Displays Bill
	 * 
	 * @return total Bill
	 */
	@Override
	public double showBill() {
		double totalBill = 0;
		Map<Product, Integer> products = Cart.getInstance().getProducts();
		for (Map.Entry<Product, Integer> map : products.entrySet()) {
			totalBill += map.getKey().getPrice() * map.getValue();
		}

		return totalBill;
	}

	/**
	 * Displays User of a Cart
	 * 
	 * @return user
	 */
	@Override
	public User showUser() {
		return Cart.getInstance().getUser();
	}

	/**
	 * Adds User
	 * 
	 * @param user
	 */
	@Override
	public void setUser(User user) {
		Cart.getInstance().setUser(user);
	}
}