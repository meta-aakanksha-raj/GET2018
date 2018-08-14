package cricket;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * This class provides a way for minimizing the number of runs scored by Virat Kohli.
 * It assumes that Virat scores maximum runs on the ball of the bowler
 * with minimum number of balls left to bowl.
 */
public class Cricket {

	// used to store no. of balls per bowler
	Map<String, Integer> bowlerListMap;
	int ballsViratPlays, totalBowlers;

	// constructor
	public Cricket(int noOfBallsViratPlay, Map<String, Integer> bowlerMap)
			throws AssertionError {
		if (noOfBallsViratPlay <= 0)
			throw new AssertionError("Number of balls should be more than zero");

		for (String bowler : bowlerMap.keySet()) {
			if (bowlerMap.get(bowler) < 0)
				throw new AssertionError("Number of balls cannot be negative");
		}

		if (sum(bowlerMap) >= noOfBallsViratPlay) {
			this.ballsViratPlays = noOfBallsViratPlay;
			this.bowlerListMap = bowlerMap;
			this.totalBowlers = bowlerMap.size();
		} else
			throw new AssertionError("Insufficient bowlers!!");
	}

	/**
	 * Calculates the bowling order in order to minimize the runs scored by Virat Kohli
	 * @return bowlingOrder
	 */
	public List<String> bowlingOrder() {
		List<String> bowlingOrder = new ArrayList<>();

		for (int i = 0; i < ballsViratPlays; i++) {
			String bowler = findBowler();
			bowlingOrder.add(bowler);
			bowlerListMap.put(bowler, bowlerListMap.get(bowler) - 1);
		}
		return bowlingOrder;
	}

	/**
	 * Method to find the bowler with the maximum number of balls left to bowl 
	 * @return the bowler with the maximum number of balls left to bowl
	 */
	private String findBowler() {
		int maxBalls = 0;
		String bowler = null;

		for (String bowlerName : bowlerListMap.keySet()) {
			int balls = bowlerListMap.get(bowlerName);
			if (maxBalls < balls) {
				maxBalls = balls;
				bowler = bowlerName;
			}
		}
		return bowler;
	}

	/**
	 * Method to add the total number of balls of all the bowlers
	 * @param bowlerMap
	 * @return sum of balls of all the bowlers
	 */
	private int sum(Map<String, Integer> bowlerMap) {
		int sum = 0;
		for (String bowler : bowlerMap.keySet())
			sum += bowlerMap.get(bowler);
		return sum;
	}
}