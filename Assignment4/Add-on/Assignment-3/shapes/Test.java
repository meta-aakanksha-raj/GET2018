package shapes;

import static org.junit.Assert.assertEquals;

public class Test {
	Area object=new Area();

	/**
	 * For correct inputs for triangle to find area
	 */
	@org.junit.Test
	public void triangleTestPositive() {
		double area=object.triangleArea(4.0,6.0);
		assertEquals(12.0, area, 0.1);
	}

	/**
	 * For negative inputs for triangle to find area
	 */
	@org.junit.Test(expected=AssertionError.class)
	public void triangleTestNegative() {
		double area=object.triangleArea(-6.0,8.5);
	}

	/*
	 * For correct inputs for rectangle to find area
	 */
	@org.junit.Test
	public void rectangleTestPositive() {
		double area=object.rectangleArea(4.0,6.0);
		assertEquals(24.0, area, 0.1);
	}

	/**
	 * For negative inputs for rectangle to find area
	 */
	@org.junit.Test(expected=AssertionError.class)
	public void rectangleTestNegative() {
		double area=object.rectangleArea(-6.0,8.5);
	}

	/*
	 * For correct inputs for square to find area
	 */
	@org.junit.Test
	public void squareTestPositive() {
		double area=object.squareArea(4.0);
		assertEquals(16.0, area, 0.1);
	}

	/**
	 * For negative inputs for square to find area
	 */
	@org.junit.Test(expected=AssertionError.class)
	public void squareTestNegative() {
		double area=object.squareArea(-6.0);
	}
	
	/*
	 * For correct inputs for circle to find area
	 */
	@org.junit.Test
	public void circleTestPositive() {
		double area=object.circleArea(4.0);
		assertEquals(50.24, area, 0.1);
	}

	/*
	 * For negative inputs for circle to find area
	 */
	@org.junit.Test(expected=AssertionError.class)
	public void circleTestNegative() {
		double area=object.circleArea(-6.0);
	}
}