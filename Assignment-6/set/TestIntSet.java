package set;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestIntSet {
	int[] set = { 2, 3, 5, 7, 6, 9, 13 };

	/**
	 * To test for the number which is present in set
	 */
	@Test
	public void testNumberIsPresentPositive() {
		IntSet object = new IntSet(set);
		boolean result = object.isMember(9);
		assertEquals(true, result);
	}

	/**
	 * To test for number which is not present in set
	 */
	@Test
	public void testNumberIsNotPresent() {
		IntSet object = new IntSet(set);
		boolean result = object.isMember(1);
		assertEquals(false, result);
	}

	/**
	 * To test for empty array exception
	 */
	@Test(expected = AssertionError.class)
	public void testEmptySetException() {
		int[] setOne = {};
		IntSet object = new IntSet(setOne);
		boolean result = object.isMember(1);
	}

	/**
	 * To test when number is not in valid range
	 */
	@Test(expected = AssertionError.class)
	public void testInvalidNumberInSet() {
		int[] setOne = { 2, 3000, 5, 7, 6, 9, 13 };
		IntSet object = new IntSet(setOne);
	}

	/**
	 * To find the size of set
	 */
	@Test
	public void testSizeOfSet() {
		// int[] setOne={2,3,5,7,6,9,13};
		IntSet object = new IntSet(set);
		int result = object.size();
		assertEquals(7, result);
	}

	/**
	 * To test when given set is subset of original set
	 */
	@Test
	public void testIsSubsetPositive() {
		IntSet s = new IntSet(set);
		IntSet object = new IntSet(new int[] { 3, 7, 9 });
		boolean result = object.isSubSet(s);
		assertEquals(true, result);
	}

	/**
	 * To test when given set is not a subset of original set
	 */
	@Test
	public void testIsSubsetNegative() {
		IntSet s = new IntSet(set);
		IntSet object = new IntSet(new int[] { 3, 7, 10 });
		boolean result = object.isSubSet(s);
		assertEquals(false, result);
	}

	/**
	 * To test for complement of set for array of size 15
	 */
	@Test
	public void testComplement() {
		IntSet object = new IntSet(set);
		int[] result = object.getComplement();
		assertArrayEquals(new int[] { 1, 4, 8, 10, 11, 12, 14, 15 }, result);
	}

	/**
	 * To test for union of two sets
	 */
	@Test
	public void testUnionOfSetType() {
		IntSet s1 = new IntSet(set);
		IntSet s2 = new IntSet(new int[] { 30, 40, 50 });
		int[] result = s1.union(s1, s2);
		assertArrayEquals(new int[] { 2, 3, 5, 7, 6, 9, 13, 30, 40, 50 },
				result);
	}
}
