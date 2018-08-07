package counseling;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * To test the counseling process
 */
public class TestCounseling {

	/**
	 * To test whether a text file containing the result of counseling is made or not
	 */
	@Test
	public void testCounselingResultDisplay() {
		FileHandling object = new FileHandling();
		boolean result = object.displayResult();
		assertEquals(true, result);
	}
}