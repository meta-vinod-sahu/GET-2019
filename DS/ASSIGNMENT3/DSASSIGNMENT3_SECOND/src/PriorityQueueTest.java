import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class PriorityQueueTest {
	PriorityQueue priorityQueue;

	@Before
	public void init() {
		priorityQueue = new PriorityQueue(5);
		priorityQueue.enqueue("Process-1", 2);
		priorityQueue.enqueue("Process-2", 1);
		priorityQueue.enqueue("Process-3", 5);
		priorityQueue.enqueue("Process-4", 6);
	}

	@Test
	public void enqueueTest() {
		assertTrue(priorityQueue.enqueue("Process-5", 3));
	}

	@Test
	public void dequeueTest() {
		assertEquals("Process-4", priorityQueue.dequeue());
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void dequeueEmptyQueueTest() {
		priorityQueue.dequeue();
		priorityQueue.dequeue();
		priorityQueue.dequeue();
		priorityQueue.dequeue();
		priorityQueue.dequeue();
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void enqueueFullqueueTest() {
		assertTrue(priorityQueue.enqueue("Process-5", 3));
		assertTrue(priorityQueue.enqueue("Process-6", 8));
	}

}