package recursion;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class TestNQueen {

	NQueenRecursion object = new NQueenRecursion();

	/**
	 * To test for correct value for number of queen for which queen can be placed
	 */
	@Test
	public void testNQueenPositive() {
		int[][] output = object.numberOfQueens(4);
		assertArrayEquals(new int[][] { { 0, 1, 0, 0 }, { 0, 0, 0, 1 },
				{ 1, 0, 0, 0 }, { 0, 0, 1, 0 } }, output);
	}

	/**
	 * To test for wrong value of number of queen for which Queen cannot be placed
	 */
	@Test
	public void testNQueenNegative() {
		int[][] output = object.numberOfQueens(3);
		assertArrayEquals(
				new int[][] { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } }, output);
	}
}
