import java.util.*;

class Process {
	private int size;
	private int process_id[];
	private int arrival_burst[][];
	private int completion_time[];
	private int turnaround_time[];
	private int waiting_time[];
	private float avgwaiting_time=0;
	private int max;
	
	public Process(int size, int[] process_id,int[][] arrival_burst, int[] completion_time,int[] turnaround_time,int[] waiting_time) {
		this.size=size;
		this.process_id=process_id;
		this.arrival_burst=arrival_burst;
		this.completion_time=completion_time;
		this.turnaround_time=turnaround_time;
		this.waiting_time=waiting_time;
	}
	
	public void completion() {
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
	
	public void display(int max) {
		System.out.println("\nprocess_id  arrival  burst  complete waiting turnaround_timet");
		for(int  i = 0 ; i< size;  i++) {
			System.out.println(process_id[i]+"  \t "+arrival_burst[i][0] + "\t" + arrival_burst[i][1] + "\t" + completion_time[i] + "\t" + waiting_time[i] + "\t"  + turnaround_time[i] ) ;
		}
		
		System.out.println("\naverage waiting time: "+ (avgwaiting_time/size));  
		System.out.println("maximum waiting time: " + max);
	}		
}
	
public class FCFS {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);	
		System.out.println("enter no of process: ");
		int size = input.nextInt();
		int process_id[]=new int[size];   
		int[][] arrival_burst=new int[size][2];         
		int completion_time[]=new int[size];    
		int turnaround_time[]=new int[size];   
		int waiting_time[]=new int[size];
		int max;
		int temp=0;
		for(int i=0;i<size;i++) {
			System.out.println("For process "+(i+1)+" arrival time: ");
			arrival_burst[i][0]=input.nextInt();
			System.out.println("For process "+(i+1)+" burst time: ");
			arrival_burst[i][1]=input.nextInt();
			process_id[i]=i+1;
		}
		Process obj=new Process(size,process_id,arrival_burst,completion_time,turnaround_time,waiting_time);
		obj.completion();
		obj.turnaround();
		obj.waiting();
		obj.avgwaiting();
		max=obj.maxwait();
		obj.display(max);	    
	}
}
