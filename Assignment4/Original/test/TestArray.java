package test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class TestArray {
	ArrOperation object=new ArrOperation();

	/**
	 * For clumps which are present in array, type 1
	 */
	@org.junit.Test
	public void clumpTestOnePositive() {
		int count=object.countClumps(new int[]{1,2,2,3,4,4});
		assertEquals(2, count);
	}

	/**
	 * For clumps which are present in array, type 2
	 */
	@org.junit.Test
	public void ClumpTestTwoPositive() {
		int count=object.countClumps(new int[]{1,1,1,1,1});
		assertEquals(1, count);
	}

	/**
	 * Here clumps are not present in array
	 */
	@org.junit.Test
	public void ClumpTestNegative() {
		int count=object.countClumps(new int[]{1,2,3,4,5});
		assertEquals(0, count);
	}

	/**
	 * For empty array for finding clump,so throws assertion error
	 */
	@org.junit.Test(expected=AssertionError.class)
	public void clumpTestException() {
		int count=object.countClumps(new int[]{});
	}

	/**
	 * split possible
	 */
	@org.junit.Test
	public void splitTestPositive() {
		int indexSplit=object.split(new int[]{1,1,1,2,1});
		assertEquals(3, indexSplit);
	}
	
	/**
	 * split impossible,so throws assertion error
	 */	
	@org.junit.Test
	public void splitTestNegative() {
		int indexSplit=object.split(new int[]{2,1,1,2,1});
		assertEquals(-1, indexSplit);
	}	

	/**
	 * For empty array for splitting,so throws assertion error
	 */
	@org.junit.Test(expected=AssertionError.class)
	public void splitTestException() {
		int indexSplit=object.split(new int[]{});
	}

	/**
	 * For mirror section present, type 1
	 */
	@org.junit.Test
	public void mirrorTestOnePositive() {
		int count=object.maxMirror (new int[]{1,2,3,8,9,3,2,1});
		assertEquals(3, count);
	}

	/**
	 * For mirror section present, type 2
	 */
	@org.junit.Test
	public void mirrorTestTwoPositive() {
		int count=object.maxMirror (new int[]{1,4,5,3,5,4,1});
		assertEquals(7, count);
	}

	/**
	 * For empty array for finding mirror section,so throws assertion error
	 */
	@org.junit.Test(expected=AssertionError.class)
	public void mirrorArrayEmptyException() {
		int count=object.maxMirror (new int[]{});
	}	

	/**
	 * For correct array passed for fixing x and y, type 1
	 */
	@org.junit.Test
	public void fixTestOnePositive() {
		int result[]=object.interchange(new int[]{5,4,9,4,9,5},4,5);
		int[] expected=(new int[]{9,4,5,4,5,9});
		assertArrayEquals(expected, result);
	}

	/**
	 * For correct array passed for fixing x and y, type 2
	 */
	@org.junit.Test
	public void fixTestTwoPositive() {
		int result[]=object.interchange(new int[]{1,4,1,5},4,5);
		assertArrayEquals(new int[]{1,4,5,1}, result);
	}	

	/**
	 * For correct array passed for fixing x and y, type 3
	 */
	@org.junit.Test
	public void fixTestThreePositive() {
		int result[]=object.interchange(new int[]{1,4,1,5,5,4,1},4,5);
		assertArrayEquals(new int[]{1,4,5,1,1,4,5}, result);
	}	

	/**
	 * For empty array for fixing x and y,so throws assertion error
	 */
	@org.junit.Test(expected=AssertionError.class)
	public void fixArrayEmptyException() {
		int result[]=object.interchange(new int[]{},4,5);
	}

	/**
	 * For x at last index in array,so throws assertion error
	 */
	@org.junit.Test(expected=AssertionError.class)
	public void fixArrayXAtLast() {
		int result[]=object.interchange(new int[]{1,5,3,4},4,5);
	}

	/**
	 * For unequal x and y in array,so throws assertion error
	 */
	@org.junit.Test(expected=AssertionError.class)
	public void fixArrayUnequalXY() {
		int result[]=object.interchange(new int[]{1,5,5,4},4,5);
	}

	/**
	 * For adjacent x and y in array,so throws assertion error
	 */
	@org.junit.Test(expected=AssertionError.class)
	public void fixArrayAdjacentX() {
		int result[]=object.interchange(new int[]{5,4,4,9,1,5},4,5);
	}	
}
