package nested_list;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;


public class TestNestedList {

	NestedList object = new NestedList();
	
	@Before
	public void init() {
	    ArrayList<Integer> innerListOne = new ArrayList<Integer>(Arrays.asList(new Integer[] {7, 12, 13, 4}));
	    ArrayList<Integer> innerListTwo = new ArrayList<Integer>(Arrays.asList(new Integer[] {12, 47, 3, 24}));
	    ArrayList<Integer> innerListThree = new ArrayList<Integer>(Arrays.asList(new Integer[] {4, 23, 9, 15}));
	    
	    object.addInnerList(innerListOne);
	    object.addInnerList(innerListTwo);
	    object.addInnerList(innerListThree);
	}

    @Test
    public void testSum() {
        assertEquals(173, object.sum());
    }    

    @Test
    public void testLargestValue() {
        assertEquals(47, object.largest());
    }

    @Test
    public void testSearchIfElementIsFoundReturnTrue() {
        assertEquals(true, object.search(12));
        assertEquals(true, object.search(23));
    }

    @Test
    public void testSearchIfElementIsNotFoundReturnFalse() {
        assertEquals(false, object.search(10));
        assertEquals(false, object.search(29));
    }
}
