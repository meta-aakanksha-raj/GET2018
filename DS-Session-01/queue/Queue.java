package queue;

/**
 * This is interface to implement Queue using Array
 */
public interface Queue {

	public void add(int element);

	public int delete();

	public boolean isEmpty();

	public boolean isFull();
}
