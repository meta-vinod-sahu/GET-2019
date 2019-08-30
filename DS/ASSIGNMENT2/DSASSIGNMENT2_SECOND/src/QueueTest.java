import static org.junit.Assert.*;

import org.junit.Test;


public class QueueTest {
	
	QueueOperation queue = new QueueOperation();
	
	
	/**
	 * This test method test positive cases on enQueue method of QueueOperation Class
	 * @throws Exception when queue is full
	 */
	
	@Test
	public void enQueueMethodPositiveCasesTest() throws Exception{
		
		
		assertTrue(queue.enQueue(1));
		assertTrue(queue.enQueue(2));
		assertTrue(queue.enQueue(3));
		assertTrue(queue.enQueue(4));
		assertTrue(queue.enQueue(5));
		assertTrue(queue.enQueue(6));
		assertTrue(queue.enQueue(7));
		assertTrue(queue.enQueue(8));
		assertTrue(queue.enQueue(9));
		assertTrue(queue.enQueue(10));	
	}

	/**
	 * This test method test positive cases on deQueue method of QueueOperation Class
	 * @throws Exception when queue is empty
	 */
	@Test
	public void deQueueMethodPositiveCasesTest() throws Exception {
		
		
		
		queue.enQueue(1);
		queue.enQueue(2);
		queue.enQueue(3);
		queue.enQueue(4);
		queue.enQueue(5);
		queue.enQueue(6);
		queue.enQueue(7);
		queue.enQueue(8);
		queue.enQueue(9);
		queue.enQueue(10);
		
		assertEquals(1,queue.deQueue());
		assertEquals(2,queue.deQueue());
		assertEquals(3,queue.deQueue());
		assertEquals(4,queue.deQueue());
		assertEquals(5,queue.deQueue());
		assertEquals(6,queue.deQueue());
		assertEquals(7,queue.deQueue());
		assertEquals(8,queue.deQueue());
		assertEquals(9,queue.deQueue());
		assertEquals(10,queue.deQueue());
		
	}

	/**
	 * This test method test positive cases on isEmpty method of QueueOperation Class
	 */
	@Test
	public void isEmptyMethodPositiveCasesTest() {
		
		assertTrue(queue.isEmpty());
	}

	/**
	 * This test method test Positive cases on isFull method of CustomQueue Class
	 */
	@Test
	public void isFullMethodPositiveCasesTest(){
		
		
		try{
			assertTrue(queue.enQueue(1));
			assertTrue(queue.enQueue(2));
			assertTrue(queue.enQueue(3));
			assertTrue(queue.enQueue(4));
			assertTrue(queue.enQueue(5));
			assertTrue(queue.enQueue(6));
			assertTrue(queue.enQueue(7));
			assertTrue(queue.enQueue(8));
			assertTrue(queue.enQueue(9));
			assertTrue(queue.enQueue(10));
		}catch(Exception e){
			System.out.println(e);
		}
		
		assertTrue(queue.isFull());
		
	}
	
	/**
	 * This test method test negative cases on enQueue method of CustomQueue Class
	 * @throws Exception when queue is full
	 */
	@Test(expected = Exception.class)
	public void enQueueMethodNegativeCasesTest() throws Exception{
		
		
		assertTrue(queue.enQueue(1));
		assertTrue(queue.enQueue(2));
		assertTrue(queue.enQueue(3));
		assertTrue(queue.enQueue(4));
		assertTrue(queue.enQueue(5));
		assertTrue(queue.enQueue(6));
		assertTrue(queue.enQueue(7));
		assertTrue(queue.enQueue(8));
		assertTrue(queue.enQueue(9));
		assertTrue(queue.enQueue(10));	
		
		assertTrue(queue.enQueue(11));
	}

	/**
	 * This test method test negative cases on deQueue method of QueueOperation queue = new QueueOperation(); Class
	 * @throws Exception when queue is empty
	 */
	@Test(expected = Exception.class)
	public void deQueueMethodNegativeCasesTest() throws Exception {
		
		
		assertEquals(11,queue.deQueue());
		
	}

	/**
	 * This test method test negative cases on isEmpty method of CustomQueue Class
	 */
	@Test
	public void isEmptyMethodNegativeCasesTest() throws Exception {
		
	
		assertFalse(queue.isEmpty());
	}

	/**
	 * This test method test negative cases on isFull method of QueueOperation Class
	 */
	@Test
	public void isFullMethodNegativeCasesTest() throws Exception{
		
		
		assertFalse(queue.isFull());
	}
}
