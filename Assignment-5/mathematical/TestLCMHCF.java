package mathematical;

import static org.junit.Assert.assertEquals;

public class TestLCMHCF {
	Maths object = new Maths();

	/**
	 * For correct values to find HCF
	 */
	@org.junit.Test
	public void testHCFPositiveValues() {
		int result = object.hcf(396, 300);
		assertEquals(12, result);
	}

	/**
	 * For incorrect i.e. negative for HCF
	 */
	@org.junit.Test(expected = AssertionError.class)
	public void testHCFExceptionNegativeValues() {
		int result = object.hcf(-396, 300);
	}

	/**
	 * For correct values to find LCM
	 */
	@org.junit.Test
	public void testLCMPositiveValues() {
		int result = object.lcm(15, 6);
		assertEquals(30, result);
	}

	/**
	 * For incorrect i.e. negative for LCM
	 */
	@org.junit.Test(expected = AssertionError.class)
	public void testLCMExceptionNegativeValues() {
		int result = object.lcm(15, -6);
	}
}
