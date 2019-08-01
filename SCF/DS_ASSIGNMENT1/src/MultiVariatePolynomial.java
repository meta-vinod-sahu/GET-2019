/**
 * MultiVariatePolynomail is a class which visualise the representation of a
 * multivariate polynomial using a nested list
 */
public class MultiVariatePolynomial {
	LinkedList mainList = new LinkedList();
	LinkedList subList = new LinkedList();

	/**
	 * @param equation represents polynomial in multiple variable
	 * @return returns maximum degree of polynomial
	 */
	public int maxDegree(String equation) {
		for (int i = 0; i < equation.length(); i++) {
			if (Character.isLetter(equation.charAt(i))) {
				subList = LinkedList.insert(subList, 1);
			} else {
				if (Character.isDigit(equation.charAt(i))) {
					subList = LinkedList.insert(subList,Character.digit(equation.charAt(i),16) - 1);
				} else {
					mainList = LinkedList.insert(mainList, subList.head);
					if (equation.charAt(i) != '=') {
						subList = new LinkedList();
					} else {
						break;
					}

				}
			}
		}
		Node mainListHead = mainList.head;
		Node subListHead = null;
		int degree = 0;
		int count = 0;
		while (mainListHead.next != null) {
			count = 0;
			subListHead = (Node) mainListHead.data;
			while (subListHead.next != null) {
				count = count + (int) subListHead.data;
				subListHead = subListHead.next;
			}
			count = count + (int) subListHead.data;
			if (count > degree)
				degree = count;
			mainListHead = mainListHead.next;
		}
		count = 0;
		subListHead = (Node) mainListHead.data;
		while (subListHead.next != null) {
			count = count + (int) subListHead.data;
			subListHead = subListHead.next;
		}
		count = count + (int) subListHead.data;
		if (count > degree)
			degree = count;

		return degree;
	}

	

}