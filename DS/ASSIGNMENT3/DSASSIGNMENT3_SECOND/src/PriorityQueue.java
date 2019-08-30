/**
 * priority queue class implement queue interface and create a queue which is array
 *
 */
public class PriorityQueue implements Queue {
	private Job[] jobArray;
	private int noOfJob = -1;
	private final int size;

	public PriorityQueue(int size) {
		this.jobArray = new Job[size];
		this.size = size;
	}

	/** 
	 * this method insert a object of job class in queue array
	 */
	public boolean enqueue(String value, int priority) {
		if (!isFull()) {
			jobArray[++noOfJob] = new Job(value, priority);
		} else {
			throw new IndexOutOfBoundsException(
					"Queue Array is full, Can't Insert");
		}
		return true;
	}

	/**
	 *  This method delete a object of job class in queue array
	 *  return deleted element
	 */
	public String dequeue() {
		if (isEmpty()) {
			throw new IndexOutOfBoundsException("Queue is empty, Can't Delete");
		}
		Job element = jobArray[getHighestPriority()];
		for (int i = getHighestPriority(); i < noOfJob; i++) {
			jobArray[i] = jobArray[i + 1];
		}
		noOfJob--;
		return element.getValue();
	}

	/**
	 * check queue is empty 
	 * @return boolean value
	 */
	public boolean isEmpty() {
		boolean flag =false;
		if (noOfJob == -1) {
			flag= true;
		}
		return flag;
	}

	/**
	 * Method for check queue is full
	 * @return boolean value 
	 */
	public boolean isFull() {
		boolean flag =false;
		if (noOfJob == size - 1) {
			flag= true;
		}
		return flag;
	}

	/**
	 * This method returns the index of Job having maxPriority
	 * 
	 * @return
	 */
	private int getHighestPriority() {
		int maxPriority = jobArray[0].priority;
		int indexOfHighestPriority = 0;
		for (int i = 0; i < noOfJob + 1; i++) {
			if (jobArray[i].priority > maxPriority) {
				indexOfHighestPriority = i;
				maxPriority = jobArray[i].priority;
			}
		}
		return indexOfHighestPriority;
	}
}