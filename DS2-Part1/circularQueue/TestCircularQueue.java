package circularQueue;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Test cases to check the functionality of circular queue
 *
 */
public class TestCircularQueue {

	/**
	 * To add element to the queue
	 */
	@Test
	public void testAdd() {
		CircularQueue obj = new CircularQueue(3);
		assertEquals(true, (obj.add(1)));
	}

	/**
	 * To add element to the queue
	 */
	@Test
	public void testAddOne() {
		CircularQueue obj = new CircularQueue(3);
		assertEquals(true, (obj.add(1)));
		assertEquals(true, (obj.add(5)));
	}

	/**
	 * To add element to the queue
	 */
	@Test
	public void testAddTwo() {
		CircularQueue obj = new CircularQueue(3);
		assertEquals(true, (obj.add(1)));
		assertEquals(true, (obj.add(5)));
		assertEquals(true, (obj.add(1000)));
	}

	/**
	 * To add element to the queue when queue is full
	 */
	@Test
	public void testAddWhenIsFull() {
		CircularQueue obj = new CircularQueue(3);
		assertEquals(true, (obj.add(1)));
		assertEquals(true, (obj.add(5)));
		assertEquals(true, (obj.add(1000)));
		assertEquals(false, (obj.add(60)));
	}

	/**
	 * To delete element from the queue
	 */
	@Test
	public void testDelete() {
		CircularQueue obj = new CircularQueue(3);
		assertEquals(true, (obj.add(1)));
		assertEquals(true, (obj.add(5)));
		assertEquals(true, (obj.delete()));
	}

	/**
	 * To delete element from the queue when queue is empty
	 */
	@Test
	public void testDeleteWhenempty() {
		CircularQueue obj = new CircularQueue(3);
		obj.add(5);
		assertEquals(true, (obj.delete()));
		assertEquals(false, (obj.delete()));
	}

	/**
	 * To test queue if it is empty
	 */
	@Test
	public void testIsEmptyPositive() {
		CircularQueue obj = new CircularQueue(3);
		assertEquals(true, (obj.add(1)));
		assertEquals(true, (obj.delete()));
		assertEquals(true, (obj.isEmpty()));
	}

	/**
	 * To test queue if it is empty
	 */
	@Test
	public void testIsEmptyNegative() {
		CircularQueue obj = new CircularQueue(3);
		assertEquals(true, (obj.add(1)));
		assertEquals(true, (obj.add(5)));
		assertEquals(true, (obj.add(1000)));
		assertEquals(true, (obj.delete()));
		assertEquals(false, (obj.isEmpty()));
	}

	/**
	 * To test queue if it is full
	 */
	@Test
	public void testIsFullPositive() {
		CircularQueue obj = new CircularQueue(3);
		assertEquals(true, (obj.add(1)));
		assertEquals(true, (obj.add(5)));
		assertEquals(true, (obj.add(1000)));
		assertEquals(true, (obj.isFull()));
	}

	/**
	 * To test queue if it is full
	 */
	@Test
	public void testIsFullNegative() {
		CircularQueue obj = new CircularQueue(3);
		assertEquals(true, (obj.add(1)));
		assertEquals(true, (obj.add(5)));
		assertEquals(false, (obj.isFull()));
	}
}
