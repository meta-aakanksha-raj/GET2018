package priority_queue;

/**
 * Class to store the properties of a job so that it can be scheduled on processor
 */
public class Job {

	final int value;
	final int priority;

	//constructor
	public Job(int value, int priority) {
		
		this.value = value;
		this.priority = priority;
	}

	public int getValue() {
		return value;
	}

	public int getPriority() {
		return priority;
	}
}