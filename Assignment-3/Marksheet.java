import java.util.Scanner;
class Functions {
	private double[] marks;
	private int size;
	
	public Functions(int size) {
		this.size=size;
	}

	/* This function will work for average marks.
	If user has entered wrong values then it  will throw ArithmeticExceptiontic*/	
	public double average(double[] marks ) throws ArithmeticException {
		this.marks=marks;
		double sum=0;
		double average_number;
		for(int i=0;i<size;i++) {
			sum=sum+marks[i];
		}
		return sum/size;
	}

	/* This function will work for finding maximum marks.
	If user has entered wrong values then it  will throw ArithmeticExceptiontic*/	
	public double maximum(double[] marks ) throws ArithmeticException {
		this.marks=marks;
		double max=0;
		for(int i=0;i<size;i++) {
			if(marks[i]>max) {
				max=marks[i];
			}
		}
		return max;
	}
	
	/* This function will work for finding miniimum marks.
	If user has entered wrong values then it  will throw ArithmeticExceptiontic*/	
	public double minimum(double[] marks ) throws ArithmeticException {
		this.marks=marks;
		double min=100;
		for(int i=0;i<size;i++) {
			if(marks[i]<min) {
				min=marks[i];
			}
		}
		return min;
	}

	/* This function will work for finding percentage of students passed.
	If user has entered wrong values then it  will throw ArithmeticExceptiontic*/		
	public double percentage_passed(double[] marks ) throws ArithmeticException {
		this.marks=marks;
		double count=0.0;
		double percentage;
		for(int i=0;i<size;i++) {
			if(marks[i]>=40) { // Passing mark is 40
				count=count+1;
			}		
		}
		percentage=(count/size)*100;
		return percentage;
	}
}

public class Marksheet {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int size;
		System.out.println("Enter size of students"); // Size should be greater than 0(size>0)
		size=input.nextInt();
		Functions object=new Functions(size);
		
		double[] marks=new double[size];//Here array of entered size is created for marks storage
		
		/*Entered marks of each student should be between 0 and 100
		Otherwise it may give wrong output*/
		for(int i=0;i<size;i++) {
			System.out.println("Enter marks for student"+(i+1));
			marks[i]=input.nextDouble();
		}
		
		/*Choose the operation you want to perform
		If you have entered wrong input default will run*/
		while(true) {
			System.out.println("Choose from following operations: \n 1. Average Marks \n 2. Maximum Marks \n 3. Minimum Marks \n 4. Percentage of Student Passed \n 5. Exit ");
			int choice;
			choice=input.nextInt();
			switch(choice) {
				case 1: {
					double output;
					output=object.average(marks);
					System.out.println("Result of Average: "+output);
					break;
				}
				case 2: {
					double output;
					output=object.maximum(marks);
					System.out.println("Maximum Marks : "+output);
					break;
				}
				case 3: {
					double output;
					output=object.minimum(marks);
					System.out.println("Minimum Marks : "+output);
					break;
				}
				case 4: {
					double output;
					output=object.percentage_passed(marks);
					System.out.println(" Percentage passed : "+output);
					break;
				}
				case 5: { //This will take you out of the loop
					System.exit(0);
				}
				default: System.out.println("Wrong input!! Try again!!");
			}
		}
	}
}