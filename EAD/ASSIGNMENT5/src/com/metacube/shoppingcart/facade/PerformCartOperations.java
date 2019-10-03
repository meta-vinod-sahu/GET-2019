/*
 * Class to Perform Cart Operations
 */
package com.metacube.shoppingcart.facade;

import java.util.List;
import java.util.Map;

import com.metacube.shoppingcart.dao.CartOperationsImpl;
import com.metacube.shoppingcart.dao.GetProduct;
import com.metacube.shoppingcart.model.Product;
import com.metacube.shoppingcart.model.User;

public class PerformCartOperations {

	/**
	 * Displays Stock
	 * 
	 * @return stock
	 */
	public static List<Product> showStock() {
		return GetProduct.showStock();
	}

	/**
	 * Adds Product to Cart
	 * 
	 * @param productName
	 * @param quantity
	 */
	public static void addProductToCart(String productName, int quantity) {
		CartOperationsImpl.getInstance().addProduct(productName, quantity);
	}

	/**
	 * Deletes product from Cart
	 * 
	 * @param productName
	 * @param quantity
	 */
	public static void deleteProductFromCart(String productName, int quantity) {
		CartOperationsImpl.getInstance().deleteProduct(productName, quantity);
	}

	/**
	 * Displays Cart
	 * 
	 * @return Cart Items
	 */
	public static Map<Product, Integer> showCart() {
		return CartOperationsImpl.getInstance().showCart();
	}

	/**
	 * Displays Bill
	 * 
	 * @return total Bill
	 */
	public static double showBill() {
		return CartOperationsImpl.getInstance().showBill();
	}

	/**
	 * Displays User of a Cart
	 * 
	 * @return user
	 */
	public static User showUser() {
		return CartOperationsImpl.getInstance().showUser();
	}

	/**
	 * Adds User
	 * 
	 * @param user
	 */
	public static void setUser(User user) {
		CartOperationsImpl.getInstance().setUser(user);
	}
}