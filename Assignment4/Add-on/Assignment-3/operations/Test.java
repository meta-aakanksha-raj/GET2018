package operations;

import static org.junit.Assert.*;

public class Test {
	StringOperations object=new StringOperations();

	/**
	 * For equal strings
	 */
	@org.junit.Test
	public void equalityPositive() {
		int result=object.compareTwoStrings("Game of Thrones","Game of Thrones");
		assertEquals(1,result );
	}

	/**
	 * For unequal strings
	 */
	@org.junit.Test
	public void equalityNegative() {
		int result=object.compareTwoStrings("Game of Thrones","Game of thrones");
		assertEquals(0,result );
	}	

	/**
	 * For reversing the string
	 */
	@org.junit.Test
	public void reverse() {
		String result=object.reverseString("Game of Thrones");
		assertEquals("senorhT fo emaG",result );
	}	

	/**
	 * For converting the uppercase to lowercase and vice versa
	 */
	@org.junit.Test
	public void changeCase() {
		String result=object.replaceLowerUpperCase("Game of Thrones");
		assertEquals("gAME OF tHRONES",result );
	}

	/**
	 * For finding largest word 
	 */
	@org.junit.Test
	public void largest() {
		String result=object.largestWordInString("Game of Thrones");
		assertEquals("Thrones",result );
	}

	/**
	 * For two words having same length, returns last word
	 */
	@org.junit.Test
	public void largestFromLast() {
		String result=object.largestWordInString("I live in Pune");
		assertEquals("Pune",result );
	}	
}