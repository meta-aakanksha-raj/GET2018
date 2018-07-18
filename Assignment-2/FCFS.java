import java.util.*;
class Process
{
	private int n;
	private int pid[];
	private int at[];
	private int bt[];
	private int ct[];
	private int ta[];
	private int wt[];
	private float avgwt=0;
	private int max;
	public Process(int n, int[] pid,int[] at, int[] bt, int[] ct,int[] ta,int[] wt)
	{
		this.n=n;
		this.pid=pid;
		this.at=at;
		this.bt=bt;
		this.ct=ct;
		this.ta=ta;
		this.wt=wt;
	}
	public void completion()
	{
		for(int  i=0 ; i<n; i++)
		{
			if( i==0)
			{	
				ct[i] = at[i] + bt[i];
			}
			else
			{
				if( at[i] > ct[i-1])
				{
					ct[i] = at[i] + bt[i];
				}
				else
					ct[i] = ct[i-1] + bt[i];
			}
		}
	}
	public void turnaround()
	{
		for(int i=0 ; i<n ; i++)
		{
			ta[i] = ct[i] - at[i] ;
		}
	}
	public void waiting()
	{
		for(int i=0 ; i<n ; i++)
		{	
			wt[i] = ta[i] - bt[i] ;	
		}
	}	
	public void avgwaiting()
	{
		for(int i=0 ; i<n ; i++)
		{
			avgwt+=wt[i] ;
		}
	}
	public int maxwait()
	{
		for(int  i = 0 ; i< n;  i++)
		{
			
			if(wt[i]>max)
			{
				max=wt[i];
			}
		}
		return max;
		
	}
	public void display(int max)
	{
		System.out.println("\npid  arrival  burst  complete waiting tat");
		for(int  i = 0 ; i< n;  i++)
		{
			System.out.println(pid[i]+"  \t "+at[i] + "\t" + bt[i] + "\t" + ct[i] + "\t" + wt[i] + "\t"  + ta[i] ) ;
		}
		
		System.out.println("\naverage waiting time: "+ (avgwt/n));  
		System.out.println("maximum waiting time: " + max);
	}
	
		
}	
public class FCFS
{
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);	
		System.out.println("enter no of process: ");
		int n = input.nextInt();
		int pid[]=new int[n];   
		int at[]=new int[n];     
		int bt[]=new int[n];     
		int ct[]=new int[n];    
		int ta[]=new int[n];   
		int wt[]=new int[n];
		int max;
		
		for(int i=0;i<n;i++)
		{
			System.out.println("For process "+(i+1)+" arrival time: ");
			at[i]=input.nextInt();
			System.out.println("For process "+(i+1)+" burst time: ");
			bt[i]=input.nextInt();
			pid[i]=i+1;
		}
		Process obj=new Process(n,pid,at,bt,ct,ta,wt);
		obj.completion();
		obj.turnaround();
		obj.waiting();
		obj.avgwaiting();
		max=obj.maxwait();
		obj.display(max);
		
               
   
		    
	}
}
	
