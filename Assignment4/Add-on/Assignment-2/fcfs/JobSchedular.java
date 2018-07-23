package fcfs;

public class JobSchedular {
	public void completion(int number, int[][] arrival_burst) {
		for(int  i=0 ; i<size; i++) {
			if( i==0) {	
				completion_time[i] = arrival_burst[i][0] + arrival_burst[i][1];
			}
			else {
				if( arrival_burst[i][0] > completion_time[i-1]) {
					completion_time[i] = arrival_burst[i][0] + arrival_burst[i][1];
				}
				else {
					completion_time[i] = completion_time[i-1] + arrival_burst[i][1];
				}
			}
		}
	}
	public void turnaround() {
		for(int i=0 ; i<size ; i++) {
			turnaround_time[i] = completion_time[i] - arrival_burst[i][0] ;
		}
	}
	
	public void waiting() {
		for(int i=0 ; i<size ; i++) {	
			waiting_time[i] = turnaround_time[i] - arrival_burst[i][1] ;	
		}
	}
	
	public void avgwaiting() {
		for(int i=0 ; i<size ; i++) {
			avgwaiting_time+=waiting_time[i] ;
		}
	}
	
	public int maxwait() {
		for(int  i = 0 ; i< size;  i++) {	
			if(waiting_time[i]>max) {
				max=waiting_time[i];
			}
		}
		return max;	
	}	
	public int Process(int number, int[][] arrival_burst ) {
		completion(number,arrival_burst);
		turnaround();
		waiting();
		avgwaiting();
		max=maxwait();

	}
}
