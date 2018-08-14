package priority_queue;

/**
 * interface for defining the priority queue and its functionalities such as
 * enqueue, dequeue, and to check empty and full
 */
public interface PriorityQueue {

	/**
	 * method to add a job in the queue
	 * 
	 * @param job to be added
	 * @return true if job is added to the queue otherwise false
	 */
	public boolean enqueue(Job job);

	/**
	 * method to remove a job from the queue
	 * @return the removed job
	 */
	public Job dequeue();

	/**
	 * method to check if the queue is empty
	 * @return boolean value true if queue is empty else false
	 */
	public boolean isEmpty();

	/**
	 * method to check if the queue is full
	 * @return boolean value true if queue is full else false
	 */
	public boolean isFull();
}