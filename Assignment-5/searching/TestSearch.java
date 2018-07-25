package searching;

import static org.junit.Assert.*;

public class TestSearch {

	Search object = new Search();

	/**
	 * For searching first element through linear search
	 */
	@org.junit.Test
	public void tesingLinearSearchFirstElement() {
		int result = object.linear(new int[] { 1, 2, 9, 8, 5 }, 1, 0);
		assertEquals(0, result);
	}

	/**
	 * For searching last element through linear search
	 */
	@org.junit.Test
	public void tesingLinearSearchLastElement() {
		int result = object.linear(new int[] { 1, 2, 9, 8, 5 }, 5, 0);
		assertEquals(4, result);
	}

	/**
	 * For searching element which is not present through linear search
	 */
	@org.junit.Test
	public void testingLinearSearchElementNotPresent() {
		int result = object.linear(new int[] { 1, 2, 9, 8, 5 }, 4, 0);
		assertEquals(-1, result);
	}	
	
	/**
	 * For empty array for linear search,so throws assertion error
	 */
	@org.junit.Test(expected = AssertionError.class)
	public void linearSearchEmptyArrayException() {
		int count = object.linear(new int[] {}, 5, 0);
	}

	/**
	 * For searching first element through binary search
	 */
	@org.junit.Test
	public void testingBinarySearchFirstElement() {
		int result = object.binary(new int[] { 1, 2, 5, 8, 10, 15 }, 0, 5, 1);
		assertEquals(0, result);
	}

	/**
	 * For searching middle element through binary search
	 */
	@org.junit.Test
	public void testingBinarySearchMiddleElement() {
		int result = object.binary(new int[] { 1, 2, 5, 8, 10, 15 }, 0, 5, 8);
		assertEquals(3, result);
	}

	/**
	 * For searching last element through binary search
	 */
	@org.junit.Test
	public void testingBinarySearchLastElement() {
		int result = object.binary(new int[] { 1, 2, 5, 8, 10, 15 }, 0, 5, 15);
		assertEquals(5, result);
	}

	/**
	 * For searching element which is not present through binary search
	 */
	@org.junit.Test
	public void testingBinarySearchElementNotPresent() {
		int result = object.binary(new int[] { 1, 2, 5, 8, 10, 15 }, 0, 5, 18);
		assertEquals(-1, result);
	}

	/**
	 * For empty array for binary search,so throws assertion error
	 */
	@org.junit.Test(expected = AssertionError.class)
	public void binaryTestEmptyArrayException() {
		int count = object.binary(new int[] {}, 0, 0, 4);
	}
}