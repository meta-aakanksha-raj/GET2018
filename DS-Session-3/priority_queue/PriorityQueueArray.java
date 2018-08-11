/**
 * 
 */
package priority_queue;

/**
 * To implement priority queue by providing functionality of enqueue, dequeue
 * and checking empty and full
 */
public class PriorityQueueArray implements PriorityQueue {

	private Job[] queue;
	private int rear, front, capacity;

	// constructor
	public PriorityQueueArray(int capacity) {
		this.capacity = capacity;
		queue = new Job[capacity];
		rear = -1;
		front = -1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see priority_queue.PriorityQueue#enqueue(priority_queue.Job)
	 */
	@Override
	public boolean enqueue(Job job) {
		try {
			if (isFull()) {
				throw new AssertionError("The queue is full!");
			} else {
				if (rear == -1) {
					front++;
					rear++;
				} else {
					rear = (rear + 1) % capacity;
				}
				int pos = -1;
				for (int i = front; i <= (rear - 1) % capacity; i++) {
					if (job.getPriority() > queue[i].getPriority()) {
						pos = i;
						break;
					}
				}
				if (pos != -1) {
					for (int i = (rear - 1) % capacity; i >= pos; i--) {
						queue[(i + 1) % capacity] = queue[i];
					}
					queue[pos] = job;
				} else
					queue[rear] = job;
			}
			return true;
		} catch (AssertionError error) {
			return false;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see priority_queue.PriorityQueue#dequeue()
	 */
	@Override
	public Job dequeue() {
		Job job = null;

		if (isEmpty()) {
			throw new AssertionError("The queue is empty!");
		} else {
			if (front == rear) {
				job = queue[front];
				front = -1;
				rear = -1;
			} else {
				job = queue[front];
				front = (front + 1) % capacity;
			}
		}
		return job;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see priority_queue.PriorityQueue#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		boolean result = false;
		if (rear == -1 && front == -1) {
			result = true;
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see priority_queue.PriorityQueue#isFull()
	 */
	@Override
	public boolean isFull() {
		boolean result = false;
		if ((rear + 1) % capacity == front) {
			result = true;
		}
		return result;
	}
}