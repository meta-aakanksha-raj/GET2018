package circularQueue;

/**
 * This class implements circular queue using array
 *
 */
public class CircularQueue implements Queue {
	private int[] array;
	private int rear = -1;
	private int front = -1;
	private int capacity;

	public CircularQueue(int capacity) {
		array = new int[capacity];
		this.capacity = capacity;
	}

	/**
	 * To add element to queue(enqueue)
	 */
	@Override
	public boolean add(int element) {
		if(isEmpty()) {
			array[++rear] = element;
			front++;
			return true;
		}
		else if(!isFull()) {
			rear++;
			//if rear is reached for queue capacity and queue is still non empty then it will now reach at start
			if (rear == front)
				throw new AssertionError("Queue is full, cannot enqueue!!");
			else
				rear = rear % capacity;
				array[rear] = element;
				return true;
		} 
		else {
			return false;
		}	
	}

	/**
	 * To delete element from queue(dequeue)
	 */
	@Override
	public int delete() {
		int value = -1;
		if (front == rear && front != -1) {
			value = array[front];
			front = -1;
			rear = -1;
		} else if (!isEmpty()) {
			value = array[front];
			front++;
			// if front is reached at queue capacity and there are still queue is non empty then it will points to start
			if (front % capacity == 0)
				front = front % capacity;
		} else
			throw new AssertionError("Queue is empty, cannot dequeue!!");
		return value;
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
		if (rear == capacity - 1 && front == 0) {
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
	
	/**
	 * Main class to get the input and check it
	 * @param args
	 */
	public static void main(String args[]) {
		CircularQueue obj = new CircularQueue(3);
		System.out.println(obj.add(1));
		System.out.println(obj.add(5));
		System.out.println(obj.add(1000));
		System.out.println(obj.front);
		System.out.println(obj.rear);
		System.out.println(obj.delete());
		System.out.println(obj.add(1));
		System.out.println(obj.delete());
		System.out.println(obj.delete());
		System.out.println(obj.add(5));
		System.out.println(obj.front);
		System.out.println(obj.rear);
		System.out.println(obj.delete());
		System.out.println(obj.add(1));
		System.out.println(obj.add(5));
		System.out.println(obj.front);
		System.out.println(obj.rear);
		System.out.println(obj.isEmpty());
	}
}
