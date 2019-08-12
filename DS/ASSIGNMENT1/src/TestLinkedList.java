import static org.junit.Assert.*;

import org.junit.Test;
public class TestLinkedList {
	
	@Test
	public void TestRotateLinkedList() {
		
		LinkedList list = new LinkedList();
		list = LinkedList.insert(list , 2);
		list = LinkedList.insert(list , 3);
		list = LinkedList.insert(list , 4);
		list = LinkedList.insert(list , 5);
		list = LinkedList.insert(list , 6);
		list = LinkedList.insert(list , 7);
		list = RotateList.RotateLinkedList(list,2,5,1);
		LinkedList expectedresult = new LinkedList();
		expectedresult = LinkedList.insert(list , 2);
		expectedresult = LinkedList.insert(list , 4);
		expectedresult = LinkedList.insert(list , 5);
		expectedresult = LinkedList.insert(list , 6);
		expectedresult = LinkedList.insert(list , 3);
		expectedresult = LinkedList.insert(list , 7);
		assertEquals(expectedresult, list);
	}
	
	@Test
	public void TestDetectLoop() {
		
		LinkedList list = new LinkedList();
		list = LinkedList.insert(list , 2);
		list = LinkedList.insert(list , 3);
		list = LinkedList.insert(list , 4);
		list = LinkedList.insert(list , 5);
		list = LinkedList.insert(list , 6);
		list = LinkedList.insert(list , 7);
		int size = LinkedList.size(list);
		list = LoopedList.createLoop(list,3);
		boolean expectedresult = true;
		assertEquals(expectedresult,LoopedList.DetectLoop(list,size));				
	}
	
	@Test
	public void TestMultiVariatePolynomial(){
		MultiVariatePolynomial poly = new MultiVariatePolynomial();
		int degree = poly.maxDegree("xy+x4z+w3y4=0");
		int expectedresult = 7;
		assertEquals(expectedresult,degree);
	}

}
