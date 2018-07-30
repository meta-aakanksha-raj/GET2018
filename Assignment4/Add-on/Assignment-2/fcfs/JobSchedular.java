package fcfs;

public class JobSchedular {

	/**
	 * To calculate completion time
	 * @param number is number of processes
	 * @param arrivalBurst stores arrival and burst time in 2D array
	 * @return completion time in array type
	 */
	public int[] completion(int number, int[][] arrivalBurst) {
		int[] completionTime = new int[number];
		for (int i = 0; i < number; i++) {
			if (i == 0) {
				completionTime[i] = arrivalBurst[i][0] + arrivalBurst[i][1];
			} else {
				if (arrivalBurst[i][0] > completionTime[i - 1]) {
					completionTime[i] = arrivalBurst[i][0] + arrivalBurst[i][1];
				} else {
					completionTime[i] = completionTime[i - 1]
							+ arrivalBurst[i][1];
				}
			}
		}
		return completionTime;
	}

	/**
	 * To calculate turnaround time
	 * @param number is number of processes
	 * @param arrivalBurst stores arrival and burst time in 2D array
	 * @param completionTime is the completion time of the processes given
	 * @return turnaround time
	 */
	public int[] turnaround(int number, int[][] arrivalBurst, int[] completionTime) {
		int[] turnaroundTime = new int[number];
		for (int i = 0; i < number; i++) {
			turnaroundTime[i] = completionTime[i] - arrivalBurst[i][0];
		}
		return turnaroundTime;
	}

	/**
	 * To calculate waiting time
	 * @param number is number of processes
	 * @param arrivalBurst stores arrival and burst time in 2D array
	 * @param turnaroundTime is turnaround time of the processes given
	 * @return
	 */
	public int[] waiting(int number, int[][] arrivalBurst, int[] turnaroundTime) {
		int[] waitingTime = new int[number];
		for (int i = 0; i < number; i++) {
			waitingTime[i] = turnaroundTime[i] - arrivalBurst[i][1];
		}
		return waitingTime;
	}

	/**
	 * To calculate average waiting time
	 * @param number is number of processes
	 * @param waitingTime stores waiting time of processes
	 * @return average waiting time of processes
	 */
	public double avgWaiting(int number, int[] waitingTime) {
		double sumWaitingTime = 0.0, avgWaitingTime = 0.0;
		for (int i = 0; i < number; i++) {
			sumWaitingTime += waitingTime[i];
		}
		avgWaitingTime = sumWaitingTime / number;
		return avgWaitingTime;
	}

	/**
	 * To calculate maximum waiting time
	 * @param number is number of processes
	 * @param waitingTime stores waiting time of processes
	 * @return maximum waiting time of processes
	 */
	public int maxWait(int number, int[] waitingTime) {
		int maxWaitTime = 0;
		for (int i = 0; i < number; i++) {
			if (waitingTime[i] > maxWaitTime) {
				maxWaitTime = waitingTime[i];
			}
		}
		return maxWaitTime;
	}
}
