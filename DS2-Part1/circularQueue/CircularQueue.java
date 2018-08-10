/**
 * 
 */
package circularQueue;

/**
 * To implement the functionality of circular queue like add, delete, checking full and empty
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
	
	/* (non-Javadoc)
	 * @see circularQueue.Queue#add(int)
	 */
	@Override
	public boolean add(int element) {
		boolean flag = false;
		if (rear == -1 && front == -1) {
			array[++rear] = element;
			front++;
			flag = true;
		} else {
			int temporaryBack = (rear + 1) % capacity;
			if (temporaryBack != front) {
				array[temporaryBack] = element;
				rear = temporaryBack;
				flag = true;
			} 
		}
		return flag;
	}

	/* (non-Javadoc)
	 * @see circularQueue.Queue#delete()
	 */
	@Override
	public boolean delete() {
		boolean flag = false;
		if (rear < 0 && front < 0) {
			System.out.println("The Que is Empty");
		} else {
			int temporaryFront = (front + 1) % capacity;
			if (temporaryFront == (rear+1) % capacity) {
				front=-1;
				rear=-1;
				flag = true;
			} else if( temporaryFront != (rear + 1)%capacity ){
				front=temporaryFront;
				flag = true;
			}
		}
		return flag;
	}

	/* (non-Javadoc)
	 * @see circularQueue.Queue#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		if (front < 0 && rear < 0) {
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see circularQueue.Queue#isFull()
	 */
	@Override
	public boolean isFull() {
		if ((rear + 1) % capacity == front) {
			return true;
		}
		return false;
	}

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
