package matrix;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestSparse {

	/**
	 * To test for transpose
	 */
	@Test
	public void testTranspose() {
		int[][] mainMatrix = { { 0, 0, 2 }, { 1, 0, 0 }, { 0, 13, 0 } };
		Sparse objectTranspose = new Sparse(mainMatrix);
		int[][] transpose = objectTranspose.transpose();
		assertArrayEquals(
				new int[][] { { 0, 1, 2 }, { 1, 2, 0 }, { 1, 13, 2 } },
				transpose);
	}

	/**
	 * To test for symmetry if matrix is not symmetric
	 */
	@Test
	public void testSymmetryNegative() {
		int[][] mainMatrix = { { 0, 0, 2 }, { 1, 0, 0 }, { 0, 13, 0 } };
		Sparse objectSymmetry = new Sparse(mainMatrix);
		boolean transpose = objectSymmetry.symmetry();
		assertEquals(false, transpose);
	}

	/**
	 * To test for symmetry is matrix is symmetric
	 */
	@Test
	public void testSymmetryPositive() {
		int[][] mainMatrix = { { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 } };
		Sparse objectSymmetry = new Sparse(mainMatrix);
		boolean transpose = objectSymmetry.symmetry();
		assertEquals(true, transpose);
	}

	/**
	 * To test for addition of matrix
	 */
	@Test
	public void testaddition() {
		int[][] matrixOne = { { 0, 0, 2 }, { 1, 0, 0 }, { 0, 13, 0 } };
		int[][] matrixTwo = { { 0, 0, 6 }, { 4, 3, 0 }, { 0, 0, 0 } };
		Sparse objectOne = new Sparse(matrixOne);
		Sparse objectTwo = new Sparse(matrixTwo);
		Sparse objectAddition = Sparse.addMatrix(objectOne, objectTwo);
		int[][] addtionResult = { { 0, 1, 2, 1 }, { 2, 0, 1, 1 },
				{ 8, 5, 13, 3 } };
		Sparse objectResult = new Sparse(addtionResult);
		assertEquals(true, Sparse.checkEqual(objectResult, objectAddition));
	}

	/**
	 * To test for multiplication of matrix
	 */
	@Test
	public void testMultiplication() {
		int[][] matrixOne = { { 0, 1, 0 }, { 0, 1, 0 }, { 1, 0, 2 } };
		int[][] matrixTwo = { { 2, 0, 0 }, { 0, 0, 0 }, { 1, 0, 0 } };
		Sparse objectOne = new Sparse(matrixOne);
		Sparse objectTwo = new Sparse(matrixTwo);
		Sparse objectThree = new Sparse();		
		int[][] multiplicationResult = objectThree.multiplyMatrix(objectOne,
				objectTwo);
		assertArrayEquals(
				new int[][] { { 0, 0, 0 }, { 0, 0, 0 }, { 4, 0, 0 } },
				multiplicationResult);
	}
}