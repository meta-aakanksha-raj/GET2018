package hexa;

import static org.junit.Assert.assertEquals;

public class TestHexadecimal {
	HexCalc object=new HexCalc();

	/**
	 * To convert hexadecimal to decimal
	 */
	@org.junit.Test
	public void testingHexToDecCoversion() {
		int result=object.hexDec("A");
		assertEquals(10,result );
	}

	/**
	 * To convert decimal to hexadecimal
	 */
	@org.junit.Test
	public void testingDecToHexConversion() {
		String result=object.decHex(11);
		assertEquals("B",result );
	}

	/**
	 * To add two hexadecimal number
	 */
	@org.junit.Test
	public void testingHexadecimalAddition() {
		String result=object.addHex("A","B");
		assertEquals("15",result );
	}

	/**
	 * To subtract two hexadecimal number
	 */
	@org.junit.Test
	public void testingHexadecimalSubtraction() {
		String result=object.subHex("B","A");
		assertEquals("1",result );
	}	

	/**
	 * To multiply two hexadecimal number
	 */
	@org.junit.Test
	public void testingHexadecimalMultiplication() {
		String result=object.multHex("A","B");
		assertEquals("6E",result );
	}

	/**
	 * To divide two hexadecimal number
	 */
	@org.junit.Test
	public void testingHexadecimalDivision() {
		String result=object.divHex("F","B");
		assertEquals("1",result );
	}	

	/**
	 * For first greater hexadecimal value
	 */
	@org.junit.Test
	public void testingFirstHexadecimalGreaterPositive() {
		boolean result=object.greatHex("BA","AB");
		assertEquals(true,result );
	}	

	/**
	 * For first smaller hexadecimal value
	 */
	@org.junit.Test
	public void testingFirstHexadecimalGreaterNegative() {
		boolean result=object.greatHex("AB","BA");
		assertEquals(false,result );
	}

	/**
	 * For first smaller hexadecimal value
	 */
	@org.junit.Test
	public void testingFirstHexadecimalSmallerPositive() {
		boolean result=object.smallHex("AB","BA");
		assertEquals(true,result );
	}

	/**
	 * For first greater hexadecimal value
	 */
	@org.junit.Test
	public void testingFirstHexadecimalSmallerNegative() {
		boolean result=object.smallHex("BA","AB");
		assertEquals(false,result );
	}	

	/**
	 * For both equal hexadecimal value
	 */
	@org.junit.Test
	public void TestingBothHexadecimalEqualPositive() {
		boolean result=object.equalHex("BA","BA");
		assertEquals(true,result );
	}
	
	/**
	 * For unequal hexadecimal value
	 */	
	@org.junit.Test
	public void TestingBothHexadecimalEqualNegative() {
		boolean result=object.equalHex("BA","AB");
		assertEquals(false,result );
	}	
}