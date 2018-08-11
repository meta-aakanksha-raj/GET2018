package cricket;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class TestCricket {

	Map<String, Integer> bowlerListMap;
	
	/**
	 * this test case is used to create and initialize the bowler map
	 */
	@Before
	public void createObject() {
		bowlerListMap = new LinkedHashMap<String, Integer>();
		
		bowlerListMap.put("Chandler", 7);
		bowlerListMap.put("Ross", 9);
		bowlerListMap.put("Joey", 5);
	}

	@Test
	public void testBowlingOrderReturnedByCricketMatchMethod() {
		Cricket cricketMatch = new Cricket(10, bowlerListMap);
		@SuppressWarnings("serial")
		List<String> expectedBowlingOrder = new ArrayList<String>(){{
											add("Ross");
											add("Ross");
											add("Chandler");
											add("Ross");
											add("Chandler");
											add("Ross");
											add("Chandler");
											add("Ross");
											add("Joey");
											add("Chandler");
											}};
		assertEquals(expectedBowlingOrder, cricketMatch.bowlingOrder());
	}

	@Test(expected = AssertionError.class)
	public void testCricketWhenNumberOfballsViratWouldPlayIsGreaterThanTotalNumberOfBallsRemainingOfOppositeTeam() {	
		new Cricket(40, bowlerListMap);
	}

    @Test(expected = AssertionError.class)
    public void testCricketWhenNumberOfballsViratWouldPlayIsNegative() {  
        new Cricket(-20, bowlerListMap);
    }

    @Test(expected = AssertionError.class)
    public void testCricketWhenNumberOfballsViratWouldPlayIsZero() { 
        new Cricket(0, bowlerListMap);
    }

    @Test(expected = AssertionError.class)
    public void testCricketWhenNumberOfballsBowledbyAnyBowlerIsNegative() {
        
        Map<String, Integer> newBowlerMap = new LinkedHashMap<String, Integer>(); 
        newBowlerMap.put("Chandler", 7);
        newBowlerMap.put("Ross", 9);
        newBowlerMap.put("Joey", -2);
        new Cricket(10, newBowlerMap);
    }
}