package matrix;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestSparse {

	int[][] matrixOne = { { 0, 0, 2 }, { 1, 0, 0 }, { 0, 13, 0 } };
	int[][] matrixTwo = { { 0, 0, 6 }, { 4, 3, 0 }, { 0, 0, 0 } };

	/**
	 * To test for transpose
	 */
	@Test
	public void testTranspose() {

		Sparse objectTranspose = new Sparse(matrixOne);
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
		Sparse objectSymmetry = new Sparse(matrixOne);
		boolean transpose = objectSymmetry.symmetry();
		assertEquals(false, transpose);
	}

	/**
	 * To test for symmetry is matrix is symmetric
	 */
	@Test
	public void testSymmetryPositive() {
		int[][] symmetricalMatrix = { { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 } };
		Sparse objectSymmetry = new Sparse(symmetricalMatrix);
		boolean transpose = objectSymmetry.symmetry();
		assertEquals(true, transpose);
	}

	/**
	 * To test for addition of matrix
	 */
	@Test
	public void testaddition() {
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
		Sparse objectOne = new Sparse(matrixOne);
		Sparse objectTwo = new Sparse(matrixTwo);
		Sparse objectThree = new Sparse();
		int[][] multiplicationResult = objectThree.multiplyMatrix(objectOne,
				objectTwo);
		assertArrayEquals(
				new int[][] { { 0, 0, 0 }, { 0, 0, 6 }, { 52, 39, 0 } },
				multiplicationResult);
	}
}
