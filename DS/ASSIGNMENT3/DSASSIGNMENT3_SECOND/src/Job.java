/**
 * job class create a object which has value and its priority
 *
 */
public class Job {
	String value;
	int priority;

	public Job(String value, int priority) {
		this.value = value;
		this.priority = priority;
	}

	public String getValue() {
		return value;
	}

	public int getPriority() {
		return priority;
	}
}