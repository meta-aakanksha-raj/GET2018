package queue;

/**
 * This class performs various functions on queue using array
 * 
 * @author Aakanksha
 *
 */
public class QueueArray implements Queue {
	private int[] array;
	private int rear = -1;
	private int front = -1;
	private int number;

	public QueueArray(int number) {
		array = new int[number];
		this.number = number;
	}

	/**
	 * To add element to queue
	 */
	@Override
	public void add(int element) {
		if (rear + 1 >= number) {
			throw new AssertionError("Queue is full");
		} else if (rear == -1 && front == -1) {
			array[++rear] = element;
			front++;
		} else {
			array[++rear] = element;
		}
	}

	/**
	 * To delete element from queue
	 */
	@Override
	public int delete() {

		if (rear < 0 && front < 0) {
			throw new AssertionError("Queue is empty");
		} else if (front == rear) {
			int deletedElement = array[front];
			front = -1;
			rear = -1;
			return deletedElement;
		} else {
			int deletedElement = array[front];
			front++;
			return deletedElement;
		}
	}

	/**
	 * To check if queue is empty or not
	 */
	@Override
	public boolean isEmpty() {
		if (front < 0) {
			return true;
		}
		return false;

	}

	/**
	 * To check if queue is full
	 */
	@Override
	public boolean isFull() {
		if (rear + 1 >= number) {
			return true;
		}
		return false;
	}

	/**
	 * To print values
	 */
	public void display() {
		System.out.print("\nArray = ");
		if (!isEmpty()) {
			for (int i = front; i <= rear; i++) {
				System.out.print(array[i] + " ");
			}
			System.out.println();
		}
	}
}