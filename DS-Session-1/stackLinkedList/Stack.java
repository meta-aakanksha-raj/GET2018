package stackLinkedList;

/**
 * This is interface to implement Stack using linkedlist
 */
public interface Stack {

	public void push(int number);

	public int pop();

	public boolean isEmpty();

	public int peek();
}