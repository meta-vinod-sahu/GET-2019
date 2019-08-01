/**
 * LoopedList is class which detects loop in a link list
 * 
 * @author Admin
 *
 */
public class LoopedList {
	/**
	 * @param list
	 *            is a list of integer
	 * @param size
	 *            is size of list
	 * @return returns true if loop exits
	 */
	public static boolean DetectLoop(LinkedList list, int size) {
		Node temp = list.head;
		int count = 1;
		while (count != size) {

			if (temp.next == null)
				return false;
			temp = temp.next;
			count++;
		}
		if (temp.next == null) {
			return false;
		}
		return true;

	}

	/**
	 * @param list
	 *            is list of integers
	 * @param loopPosition
	 *            is the position at which loop is created
	 * @return returns list containing list
	 */
	public static LinkedList createLoop(LinkedList list, int loopPosition) {
		Node currentNode = list.head;
		Node temp = null;
		int count = 1;
		while (currentNode.next != null) {
			if (count == loopPosition) {
				temp = currentNode;
			}
			currentNode = currentNode.next;
			count++;
		}
		if (count == loopPosition) {
			temp = currentNode;
		}
		currentNode.next = temp;
		return list;
	}

	public static void main(String[] args) {

		LinkedList list = new LinkedList();
		list = LinkedList.insert(list, 1);
		list = LinkedList.insert(list, 2);
		list = LinkedList.insert(list, 3);
		list = LinkedList.insert(list, 4);
		list = LinkedList.insert(list, 5);
		int size = LinkedList.size(list);
		list = createLoop(list, 3);
		System.out.println(DetectLoop(list, size));
	}

}
