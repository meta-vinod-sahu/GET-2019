/**
 * Node is class which creates a node for list which contains data and pointer
 * to next node
 */
public class Node {
	Object data;
	Node next;

	/**
	 * parameterised Constructor
	 */
	Node(Object d) {
		this.data = d;
		this.next = null;
	}

	/**
	 * Constructor
	 */
	public Node() {
	}
}
