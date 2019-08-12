/**
 * LinkedList is a class which is used to insert node into list and calculates
 * the size of list
 */
public class LinkedList {

	Node head;

	/**
	 * @param listis list of integers
	 * @param data is a variable of Object type
	 * @return returns list of nodes
	 */
	public static LinkedList insert(LinkedList list, Object data) {
		Node new_node = new Node(data);
		new_node.next = null;
		if (list.head == null) {
			list.head = new_node;
		} else {

			Node last = list.head;
			while (last.next != null) {
				last = last.next;
			}
			last.next = new_node;
		}
		return list;
	}

	/**
	 * @param list is list of integers
	 * @return returns size of list
	 */
	public static int size(LinkedList list) {
		if (list.head == null) {
			System.out.print("Empty list");
			return 0;
		}
		Node temp = new Node();
		temp = list.head;
		int count = 1;
		while (temp.next != null) {
			count++;
			temp = temp.next;
		}
		return count;

	}
}
