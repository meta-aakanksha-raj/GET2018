package set;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestIntSet {
	int[] set={2,3,5,7,6,9,13};

	@Test
	public void testNumberIsPresentPositive() {
		//int[] setOne={2,3,5,7,6,9,13};
		IntSet object=new IntSet(set);
		boolean result=object.isMember(9);
		assertEquals(true,result);
	}
	
	@Test
	public void testNumberIsNotPresent() {
		//int[] setOne={2,3,5,7,6,9,13};
		IntSet object=new IntSet(set);
		boolean result=object.isMember(1);
		assertEquals(false,result);
	}

	@Test(expected=AssertionError.class)
	public void testEmptySetException() {
		int[] setOne={};
		IntSet object=new IntSet(setOne);
		boolean result=object.isMember(1);
	}
	
	@Test(expected=AssertionError.class)
	public void testInvalidNumberInSet() {
		//int[] setOne={2,3,5,7,6,9,13};
		IntSet object=new IntSet(set);
		boolean result=object.isMember(6);
		assertEquals(false,result);
	}
	
	@Test
	public void testSizeOfSet() {
		//int[] setOne={2,3,5,7,6,9,13};
		IntSet object=new IntSet(set);
		int result=object.size();
		assertEquals(7,result);
	}
	
	@Test
	public void testIsSubsetPositive() {
		IntSet s=new IntSet(set);
		IntSet object=new IntSet(new int[]{3,7,9});
		boolean result=object.isSubSet(s);
		assertEquals(true,result);
	}
	
	@Test
	public void testIsSubsetNegative() {
		IntSet s=new IntSet(set);
		IntSet object=new IntSet(new int[]{3,7,10});
		boolean result=object.isSubSet(s);
		assertEquals(false,result);
	}
	
	@Test
	public void testIsSubset() {
		IntSet s=new IntSet(set);
		IntSet object=new IntSet(new int[]{3,7,10});
		boolean result=object.isSubSet(s);
		assertNotEquals(true,result);
	}
	
	@Test
	public void testComplement() {
		IntSet object=new IntSet(set);
		int[] result=object.getComplement();
		assertArrayEquals(new int[]{1,4,8,10,11,12,14,15},result);			
	}
	
	@Test
	public void testUnionOfSetTypeOne() {
		IntSet s1=new IntSet(set);
		IntSet s2=new IntSet(new int[]{30,40,50});
		int[] result=s1.union(s1,s2);
		assertArrayEquals(new int[]{2,3,5,7,6,9,13,30,40,50},result);
	}
	
	@Test
	public void testUnionOfSetTypeTwo() {
		IntSet s1=new IntSet(set);
		IntSet s2=new IntSet(new int[]{30,40,50});
		int[] result=s1.union(s1,s2);
		assertArrayEquals(new int[]{2,3,5,7,6,9,13,30,40,50},result);
	}
} 
