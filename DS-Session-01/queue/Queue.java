package queue;

/**
 * This is interface to implement Queue using Array
 */
public interface Queue {

	public boolean add(int element);

	public int delete();

	public boolean isEmpty();

	public boolean isFull();
}
