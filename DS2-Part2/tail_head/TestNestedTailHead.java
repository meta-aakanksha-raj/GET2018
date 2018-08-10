package tail_head;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * This is the class to check the value extracted from the nested list
 */
public class TestNestedTailHead {
	List<Object> listOflist = new ArrayList<>();

	//this is constructor of this class to add values to the list
	public TestNestedTailHead() {
		listOflist.add(1);
		listOflist.add(2);
		listOflist.add(3);
		listOflist.add(4);
		List<Integer> listOne = new ArrayList<Integer>();
		listOne.add(5);
		listOne.add(6);
		listOflist.add(listOne);
		List<Object> listTwo = new ArrayList<Object>();
		listTwo.add(7);
		listTwo.add(8);
		listTwo.add(listOne);
		listOflist.add(listTwo);
	}

	/**
	 * This is to test the value after removing the first element
	 */
	@Test
	public void testGetValueOne() {
		int result = NestedTailHead.getValue("TH", listOflist);
		assertEquals("after removing the first element next head will be:", 2, result);
	}

	/**
	 * This is to test nested list element after removing starting elements
	 */
	@Test
	public void testGetValueTwo() {
		int result = NestedTailHead.getValue("TTTTTHTH", listOflist);
		assertEquals("after removing 5 elements from list and 1 element of nestsed list output will be 8", 8, result);
	}

	/**
	 * To test error when the element is not present at the specified position
	 */
	@Test(expected = AssertionError.class)
	public void testGetValueWhenHeadIsNotPresent() {
		int result = NestedTailHead.getValue("THH", listOflist);
	}
}
