import java.util.*;
public class ShoppingCart {

	static ShoppingCart cart;
	static Item item;
	private static List<Object> cartItemsList; 
	private static List<Object> allItemsList;  
	private int choice;                        
	static Scanner sc = new Scanner(System.in);
	/**
	 * add items into amazon card
	 */
	ShoppingCart(){

		allItemsList = new ArrayList<>();
		cartItemsList = new ArrayList<>();

		allItemsList.add(new Item("Shoe",500));
		allItemsList.add(new Item("Shirt",300));
		allItemsList.add(new Item("Jeans",700));
		allItemsList.add(new Item("Bag",400));
		allItemsList.add(new Item("Wallet",50));

	}

	public static void main(String args[]) {

		cart = new ShoppingCart();

		while(true) {

			cart.menu();        
		}

	}
	/**
	 * @param nothing
	 * Shows all functionality of cart and we can chose any operation 
	 * @return nothing
	 */
	public void menu() {

		showAllItems();

		System.out.println(" 1.Add Item to cart \n 2.Remove Item from cart \n 3.See Items present in cart \n 4.Update cart items quantity \n 5.Billing of cart Items \n");
		System.out.println("Enter your choice : ");
		choice = sc.nextInt();

		switch(choice) {
		case 1:
			addCartItem();
			
			break;
		case 2:
			removeCartItem();
			break;
		case 3:
			showCartItems();
			break;
		case 4:
			updateCartItem();
			break;
		case 5:
			billingCartItems();
			break;
		default:
			System.out.println("Wrong Input! Try Again...");
		}
	}
	

	/**
	 * @param nothing
	 * calculate the total bill of items in cart 
	 * @return nothing
	 */
	public void billingCartItems() {
		double bill = 0;

		Iterator itr = cartItemsList.iterator();
		while(itr.hasNext()){
			Item i = (Item)itr.next();
			bill += i.getPrice() * i.getQuantity();      
		}
		System.out.println("Final bill for following items : ");
		showCartItems();
		System.out.println("\nTotal bill : "+ bill + "Rupees");
		System.exit(0);
	}
	/**
	 * @param nothing 
	 * shows all cart item present in cartItemlist 
	 * @return nothing
	 */

	public void showCartItems() {

		if(cartItemsList.isEmpty()) {                          
			System.out.println("\nCart is Empty");
		}
		else {
			System.out.println("\nCart Items given with their price are :");
			System.out.println("Product\tPrice\tQuantity");
			Iterator itr = cartItemsList.iterator();
			while(itr.hasNext()) {
				System.out.println(itr.next());
			}
		}
	}
	/**
	 * @param nothing
	 * update quantity of item if present in cart otherwise return 
	 * @return nothing
	 */
	public void updateCartItem() {

		if(cartItemsList.isEmpty()) {                                       

			System.out.println("Cart is already Empty");
		}
		else {

			String itemName;
			int quant;
			System.out.println("Enter item name to change its quantity : ");
			itemName = sc.next();

			if(checkIfPresent(itemName)) {

				if(cartItemsList.contains(item)) {
					System.out.println("Set quantity to : ");
					quant = sc.nextInt();
					if(quant <= 0)
					{
						cartItemsList.remove(item);
						item.setQuantity(0);
					}	
					item.setQuantity(quant);
				}
				else{
					System.out.println("This item is not present in your cart.");
				}
			}
			else {
				System.out.println("No product with such name.");
			}
		}
	}
	/**
	 * @param nothing
	 * add items into cart and if u already have that item then add one more quantity of that item in cart
	 * @return nothing
	 */
	public void addCartItem() {

		String itemName;
		System.out.println("Enter item name to add it to cart : ");
		itemName = sc.next();

		if(checkIfPresent(itemName)) {                             

			if(cartItemsList.isEmpty()) {                       

				cartItemsList.add(item);
				item.updateQuantity(1);
			}
			else {
				if(cartItemsList.contains(item)) {
					item.updateQuantity(1);
				}
				else
				{
					cartItemsList.add(item);
					item.updateQuantity(1);
				}
			}
		}
		else {
			System.out.println("No product with such name.");
		}
	}
	/**
	 * @param nothing
	 *remove item from card if cart have that item
	 * @return nothing
	 */
	public void removeCartItem() {

		if(cartItemsList.isEmpty()) {                                         
			System.out.println("Cart is already Empty");
		}
		else {
		    String itemName;
			System.out.println("Enter item name to remove it from cart : ");
			itemName = sc.next();                                             

			if(checkIfPresent(itemName)) {                                    

				if(cartItemsList.contains(item)) {

					cartItemsList.remove(item);
					item.setQuantity(0);
				}
				else{
					System.out.println("This item is not present in your cart.");
				}
			}
			else {
				System.out.println("No product with such name.");
			}
		}
	}
	/**
	 * @param nothing
	 * shows all items in amazon app
	 * @return nothing
	 */
	public void showAllItems() {

		System.out.println("\nItems present on our site with the prices are :");

		System.out.println("Product\tPrice\tQuantity");

		Iterator<Object> itr = allItemsList.iterator(); 
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}

	}
	/**
	 * @param name
	 * checks if the string name is persent in the amazon app or not
	 * @return true if item is persent in amazon app otherwise false
	 */

	public Boolean checkIfPresent(String name) {

		Iterator itr = allItemsList.iterator();
		while(itr.hasNext()) {
			item = (Item)itr.next();

			if(item.getItemName().equalsIgnoreCase(name)) {
				return true;
			}
		}
		return false;
	}

}  
