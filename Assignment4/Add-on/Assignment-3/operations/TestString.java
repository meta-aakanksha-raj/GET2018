package operations;

import static org.junit.Assert.assertEquals;

public class TestString {
	StringOperations object=new StringOperations();

	/**
	 * For equal strings
	 */
	@org.junit.Test
	public void testingStringEqualityPositive() {
		int result=object.compareTwoStrings("Game of Thrones","Game of Thrones");
		assertEquals(1,result );
	}

	/**
	 * For unequal strings
	 */
	@org.junit.Test
	public void testingStringEqualityNegative() {
		int result=object.compareTwoStrings("Game of Thrones","Game of thrones");
		assertEquals(0,result );
	}	

	/**
	 * For reversing the string
	 */
	@org.junit.Test
	public void testingStringReverse() {
		String result=object.reverseString("Game of Thrones");
		assertEquals("senorhT fo emaG",result );
	}	

	/**
	 * For converting the uppercase to lowercase and vice versa
	 */
	@org.junit.Test
	public void testingStringChangeCase() {
		String result=object.replaceLowerUpperCase("Game of Thrones");
		assertEquals("gAME OF tHRONES",result );
	}

	/**
	 * For finding largest word 
	 */
	@org.junit.Test
	public void testingStringLargest() {
		String result=object.largestWordInString("Game of Thrones");
		assertEquals("Thrones",result );
	}

	/**
	 * For two words having same length, returns last word
	 */
	@org.junit.Test
	public void testingStringlargestFromLast() {
		String result=object.largestWordInString("I live in Pune");
		assertEquals("Pune",result );
	}	
}
