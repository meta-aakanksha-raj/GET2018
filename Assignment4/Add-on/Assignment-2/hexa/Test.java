package hexa;

import static org.junit.Assert.assertEquals;

public class Test {
	HexCalc object=new HexCalc();

	/**
	 * To convert hexadecimal to decimal
	 */
	@org.junit.Test
	public void hexToDec() {
		int result=object.hexDec("A");
		assertEquals(10,result );
	}

	/**
	 * To convert decimal to hexadecimal
	 */
	@org.junit.Test
	public void decToHex() {
		String result=object.decHex(11);
		assertEquals("B",result );
	}

	/**
	 * To add two hexadecimal number
	 */
	@org.junit.Test
	public void addition() {
		String result=object.addHex("A","B");
		assertEquals("15",result );
	}

	/**
	 * To subtract two hexadecimal number
	 */
	@org.junit.Test
	public void subtraction() {
		String result=object.subHex("B","A");
		assertEquals("1",result );
	}	

	/**
	 * To multiply two hexadecimal number
	 */
	@org.junit.Test
	public void multiplication() {
		String result=object.multHex("A","B");
		assertEquals("6E",result );
	}

	/**
	 * To divide two hexadecimal number
	 */
	@org.junit.Test
	public void division() {
		String result=object.divHex("F","B");
		assertEquals("1",result );
	}	

	/**
	 * For first greater hexadecimal value
	 */
	@org.junit.Test
	public void greaterPositive() {
		boolean result=object.greatHex("BA","AB");
		assertEquals(true,result );
	}	

	/**
	 * For first smaller hexadecimal value
	 */
	@org.junit.Test
	public void greaterNegative() {
		boolean result=object.greatHex("AB","BA");
		assertEquals(false,result );
	}

	/**
	 * For first smaller hexadecimal value
	 */
	@org.junit.Test
	public void smallerPositive() {
		boolean result=object.smallHex("AB","BA");
		assertEquals(true,result );
	}

	/**
	 * For first greater hexadecimal value
	 */
	@org.junit.Test
	public void smallerNegative() {
		boolean result=object.smallHex("BA","AB");
		assertEquals(false,result );
	}	

	/**
	 * For both equal hexadecimal value
	 */
	@org.junit.Test
	public void equalityPositive() {
		boolean result=object.equalHex("BA","BA");
		assertEquals(true,result );
	}
	
	/**
	 * For both unequal hexadecimal value
	 */	
	@org.junit.Test
	public void equalityNegative() {
		boolean result=object.equalHex("BA","AB");
		assertEquals(false,result );
	}	
}