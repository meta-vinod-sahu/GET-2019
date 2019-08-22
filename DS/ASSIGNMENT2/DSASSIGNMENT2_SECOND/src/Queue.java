
public interface Queue {
	/**
	 * This method add element to the queue if its not full
	 * @param value integer value to be added to queue
	 * @return true if value is added else false
	 * @throws Exception when queue is full
	 */
	public boolean enQueue(int value)throws Exception;
	
	/**
	 * This method remove element from the queue
	 * @return element which is removed
	 * @throws Exception when queue is empty
	 */
	public int deQueue()throws Exception;
	
	/**
	 * This method check if the queue is empty
	 * @return true if queue is empty else false
	 */
	public boolean isEmpty();
	
	/**
	 * This method check if the queue is full
	 * @return true if queue is full else false
	 */
	public boolean isFull();
}
