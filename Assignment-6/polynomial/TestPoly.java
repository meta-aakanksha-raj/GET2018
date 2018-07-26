package polynomial;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestPoly {
	int[][] poly = { { 2, 1, 0 }, { 4, 3, 1 } };
	int[][] polyOne = { { 2, 0 }, { 4, 2 } };
	int[][] polyTwo = { { 2, 1 }, { 3, 4 } };
	Poly p1 = new Poly(polyOne);
	Poly p2 = new Poly(polyTwo);
	Poly object = new Poly();

	/**
	 * To test for empty array exception
	 */
	@Test(expected = AssertionError.class)
	public void testEmptyPolyException() {
		int[][] polyEmpty = { {}, {} };
		Poly objectEmpty = new Poly(polyEmpty);
		int result = objectEmpty.degree();
	}

	/**
	 * To test for evaluate function
	 */
	@Test
	public void testEvaluate() {
		Poly object = new Poly(poly);
		double result = object.evaluate(2);
		assertEquals(23.0, result, 0.1);
	}

	/**
	 * To test for degree of polynomial
	 */
	@Test
	public void testdegree() {
		Poly object = new Poly(poly);
		int result = object.degree();
		assertEquals(2, result);
	}

	/**
	 * To test for addition of polynomial
	 */
	@Test
	public void testAdditionOfPolynomial() {
		Poly object = new Poly();
		int[][] result = object.addPoly(p1, p2);
		assertArrayEquals(new int[][] { { 2, 1, 0 }, { 7, 4, 2 } }, result);
	}

	/**
	 * To test for multiplication of polynomial
	 */
	@Test
	public void testMultiplicationOfPolynomial() {
		Poly object = new Poly();
		int[][] result = object.multPoly(p1, p2);
		assertArrayEquals(new int[][] { { 4, 3, 2, 1 }, { 12, 16, 6, 8 } },
				result);
	}
}
