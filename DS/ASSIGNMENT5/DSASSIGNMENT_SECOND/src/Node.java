/**
 * define Node class
 *
 */
public class Node {
	public Employee data;
	public Node next;

	/**
	 * @param data constructor
	 */
	public Node(Employee data) {
		this.data = data;
		this.next = null;
	}

	/**
	 * @return data of employee
	 */
	public Employee getData() {
		return data;
	}

	/**
	 * @param data set employee data
	 */
	public void setData(Employee data) {
		this.data = data;
	}

}
