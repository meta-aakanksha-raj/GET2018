package gradecalculator;

import static org.junit.Assert.assertEquals;

public class TestMarksheet {
	Marksheet object = new Marksheet();

	/**
	 * For all correct values
	 */
	@org.junit.Test
	public void testingAllValuesCorrect() {
		boolean result = object.checking(new double[] { 20.0, 30.0, 40.0 }, 3);
		assertEquals(false, result);
	}

	/**
	 * For n, i.e. number of students is negative
	 */
	@org.junit.Test(expected = AssertionError.class)
	public void testingNumberOfStudentsNegative() {
		boolean result = object.checking(new double[] { 20.0, 30.0, 40.0 }, -3);
	}

	/**
	 * For grades, i.e. if any of grade is negative
	 */
	@org.junit.Test(expected = AssertionError.class)
	public void testingGradeNegative() {
		boolean result = object.checking(new double[] { 20.0, -30.0, 40.0 }, 3);
	}

	/**
	 * To calculate average of all grades
	 */
	@org.junit.Test
	public void testingAverageOfGrades() {
		double result = object.average(new double[] { 20.0, 30.0, 40.0 }, 3);
		assertEquals(30.0, result, 0.1);
	}

	/**
	 * To calculate maximum of all grades
	 */
	@org.junit.Test
	public void testingMaximumOfGrades() {
		double result = object.maximum(new double[] { 20.0, 30.0, 40.0 }, 3);
		assertEquals(40.0, result, 0.1);
	}

	/**
	 * To calculate minimum of all grades
	 */
	@org.junit.Test
	public void testingMinimumOfGrades() {
		double result = object.minimum(new double[] { 20.0, 30.0, 40.0 }, 3);
		assertEquals(20.0, result, 0.1);
	}

	/**
	 * To calculate percentage of students passed
	 */
	@org.junit.Test
	public void testingPassedPercentage() {
		double result = object.percentagePassed(
				new double[] { 20.0, 30.0, 40.0 }, 3);
		assertEquals(33.33, result, 0.1);
	}
}