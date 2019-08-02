class Item{

	private String name;
	private int quantity;
	private double price;

	/**
	 * 
	 * @param name
	 * @param price
	 * @param quantity
	 */
	Item(String name,double price){

		this.name = name;
		this.price = price;
		
	}
    /**
     * @param nothing
     * @return string of name price quantity
     */
	public String toString() {
		return name + "\t" + price+ "\t"+ quantity;
	}

	public double getPrice() {
		return price;
	}

	public String getItemName() {
		return name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void updateQuantity(int quantity) {
		this.quantity += quantity;
	}
	
	

	public void setQuantity(int val) {
		this.quantity = val;
	}
} 