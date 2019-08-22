public interface Queue {
	public boolean enqueue(String newElement, int priority);

	public String dequeue();

	public boolean isFull();

	public boolean isEmpty();
}