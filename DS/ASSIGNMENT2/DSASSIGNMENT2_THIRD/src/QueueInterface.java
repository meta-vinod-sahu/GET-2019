public interface QueueInterface <T>
{
    void enqueue(T element);
    T dequeue();
    boolean isEmpty();
    boolean isFull();
}