package priority_queue;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestPriorityQueue {

	PriorityQueue queue = new PriorityQueueArray(5);

	@Test
	public void testPriorityQueueEnqueueByAddingTheElementsUntillItIsFull() {
		assertTrue(queue.enqueue(new Job(1, 2)));
		assertTrue(queue.enqueue(new Job(2, 5)));
		assertTrue(queue.enqueue(new Job(3, 4)));
		assertTrue(queue.enqueue(new Job(4, 1)));
		assertTrue(queue.enqueue(new Job(5, 1)));
		assertFalse(queue.enqueue(new Job(6, 5)));
	}

	@Test
	public void testPriorityQueueDequeueByRemovingAJobAfterAddingThreeJobs() {
		assertTrue(queue.enqueue(new Job(1, 2)));
		assertTrue(queue.enqueue(new Job(2, 5)));
		assertTrue(queue.enqueue(new Job(3, 4)));
		assertEquals(2, queue.dequeue().getValue());
	}

	@Test(expected = AssertionError.class)
	public void testPriorityQueueDequeueWhenQueueIsEmpty() {
		assertTrue(queue.enqueue(new Job(3, 4)));
		assertEquals(3, queue.dequeue().getValue());
		queue.dequeue();
	}

	@Test
	public void testPriorityQueueIsEmptyWhenQueueIsNotEmpty() {
		assertTrue(queue.enqueue(new Job(3, 4)));
		assertFalse(queue.isEmpty());
	}

	@Test
	public void testPriorityQueueIsEmptyWhenQueueIsEmpty() {
		assertTrue(queue.isEmpty());
	}

	@Test
	public void testPriorityQueueIsFullWhenQueueIsActuallyFull() {
		assertTrue(queue.enqueue(new Job(1, 2)));
		assertTrue(queue.enqueue(new Job(2, 5)));
		assertTrue(queue.enqueue(new Job(3, 4)));
		assertTrue(queue.enqueue(new Job(4, 1)));
		assertTrue(queue.enqueue(new Job(5, 1)));
		assertTrue(queue.isFull());
	}

	@Test
	public void testPriorityQueueIsFullWhenQueueIsNotFull() {
		assertFalse(queue.isFull());
		assertTrue(queue.enqueue(new Job(1, 2)));
		assertTrue(queue.enqueue(new Job(1, 2)));
		assertFalse(queue.isFull());
	}
}
