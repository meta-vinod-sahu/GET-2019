
public class QueueOperation {
	//size of queue
		private final int QUEUE_SIZE = 10;
		//front index of queue when queue is empty
		private int frontIndex = -1;
		//back index of queue when queue is empty
		private int backIndex = -1;
		//integer array representing queue
		private int queue[] = new int[QUEUE_SIZE];

		/**
		 * This method add element to the queue if its not full
		 * @param value integer value to be added to queue
		 * @return true if value is added else false
		 * @throws Exception when queue is full
		 */
		public boolean enQueue(int value) throws Exception{

			if (this.isFull()) {
				throw new Exception("Queue is full");
			}
			else{
				if (frontIndex == backIndex && frontIndex == -1) {
					frontIndex = 0;
				}

			}
			
			

			backIndex = (backIndex + 1) % QUEUE_SIZE;
			queue[backIndex] = value;
			return true;
		}

		/**
		 * This method remove element from the queue
		 * @return element which is removed
		 * @throws Exception when queue is empty
		 */
		public int deQueue() throws Exception{

			if (this.isEmpty()) {
				throw new Exception("Queue is empty");
			}
			if (frontIndex == backIndex) {
				int value = queue[frontIndex];
				frontIndex = -1;
				backIndex = -1;
				return value;
			}
			if ((frontIndex + 1) == queue.length) {
				int value = queue[frontIndex];
				frontIndex = 0;
				return value;
			}
			int value = queue[frontIndex];
			frontIndex++;
			return value;
		}

		/**
		 * This method find the first element is the queue
		 * @return first element in the queue
		 * @throws Exception when queue is empty
		 */
		public int getFirst() throws Exception{

			if (this.isEmpty()) {
				throw new Exception("Queue is empty");
			}
			return queue[frontIndex];
		}

		/**
		 * This method find the last element in the queue
		 * @return last element in the queue
		 * @throws Exception when queue is empty
		 */
		public int getLast() throws Exception {

			if (this.isEmpty()) {
				throw new Exception("Queue is empty");
			}
			return queue[backIndex];
		}

		/**
		 * This method check if the queue is empty
		 * @return true if queue is empty else false
		 */
		public boolean isEmpty() {
			if (frontIndex == -1 && backIndex == -1) {
				return true;
			}
			return false;
		}

		/**
		 * This method check if the queue is full
		 * @return true if queue is full else false
		 */
		public boolean isFull() {
			if (((backIndex + 1) == queue.length && frontIndex == 0) || (backIndex + 1) == frontIndex) {
				return true;
			}
			return false;
		}
}
