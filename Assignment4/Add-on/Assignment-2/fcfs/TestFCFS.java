package fcfs;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class TestFCFS {
	
	JobSchedular object=new JobSchedular();

	/**
	 * To test completion time of processes
	 */
	@org.junit.Test
	public void testingCompletionTime() {
		int result[]=object.completion(3,new int[][]{{0,9},{1,4},{2,9}});
		assertArrayEquals(new int[]{9,13,22}, result);
	}

	/**
	 * To test turnaround time of processes
	 */
	@org.junit.Test
	public void testingTurnaroundTime() {
		int result[]=object.turnaround(3,new int[][]{{0,9},{1,4},{2,9}},new int[]{9,13,22});
		assertArrayEquals(new int[]{9,12,20}, result);
	}

	/**
	 * To test waiting time of processes
	 */
	@org.junit.Test
	public void testingWaitingTime() {
		int result[]=object.waiting(3,new int[][]{{0,9},{1,4},{2,9}},new int[]{9,12,20});
		assertArrayEquals(new int[]{0,8,11}, result);
	}

	/**
	 * To test average waiting time of processes
	 */
	@org.junit.Test
	public void testingAverageWaitingTime() {
		double result=object.avgWaiting(3,new int[]{0,8,11});
		assertEquals(6.33, result,0.1);
	}	

	/**
	 * To test maximum waiting time of processes
	 */
	@org.junit.Test
	public void testingMaximumWaitingTime() {
		int result=object.maxWait(3,new int[]{0,8,11});
		assertEquals(11, result);
	}
}
