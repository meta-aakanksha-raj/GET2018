import java.util.Scanner;
class Functions {
	private double[] marks;
	private int size;
	/**
	 * This constructor for taking number of students
	 * @param size > 0
	 */
	public Functions(int size) {
		this.size=size;
	}
	/**
	 * This function gives average of marks 
	 * @param marks should be between 0 and 100 both
	 * @return average of marks
	 * @throws ArithmeticException, if user has entered wrong values
	 */
	public double average(double[] marks ) throws ArithmeticException {
		this.marks=marks;
		double sum=0.0;
		for(int i=0;i<size;i++) {
			sum=sum+marks[i];
		}
		return sum/size;
	}
	/**
	 * This function gives maximum marks
	 * @param marks should be between 0 and 100 both
	 * @return maximum of marks
	 * @throws ArithmeticException, if user has entered wrong values
	 */
	public double maximum(double[] marks ) throws ArithmeticException {
		this.marks=marks;
		double max=0.0;
		for(int i=0;i<size;i++) {
			if(marks[i]>max) {
				max=marks[i];
			}
		}
		return max;
	}
	/**
	 * This function gives minimum marks
	 * @param marks should be between 0 and 100 both
	 * @return minimum of marks
	 * @throws ArithmeticException, if user has entered wrong values
	 */
	public double minimum(double[] marks ) throws ArithmeticException {
		this.marks=marks;
		double min=100.0;
		for(int i=0;i<size;i++) {
			if(marks[i]<min) {
				min=marks[i];
			}
		}
		return min;
	}
	/**
	 * This function gives percentage of students who have scored marks>=40
	 * @param marks should be between 0 and 100 both
	 * @return percentage of students passed
	 * @throws ArithmeticException, if user has entered wrong values
	 */
	public double percentage_passed(double[] marks ) throws ArithmeticException {
		this.marks=marks;
		double count=0.0;
		double percentage;
		for(int i=0;i<size;i++) {
			if(marks[i]>=40) { 
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
		System.out.println("Enter size of students"); 
		size=input.nextInt();
		Functions object=new Functions(size);
		
		double[] marks=new double[size];
		
		for(int i=0;i<size;i++) {
			System.out.println("Enter marks for student"+(i+1));
			marks[i]=input.nextDouble();
		}
		/**
		 * Choose the operation you want to perform, If you have entered wrong input default will run
		 */
		while(true) {
			System.out.println("Choose from following operations: \n 1. Average Marks \n 2. Maximum Marks \n 3. Minimum Marks \n 4. Percentage of Student Passed \n 5. Exit ");
			int choice;
			choice=input.nextInt();
			switch(choice) {
				case 1: {
					double output;
					output=object.average(marks);
					System.out.printf("Result of Average: %.2f \n", output);
					break;
				}
				case 2: {
					double output;
					output=object.maximum(marks);
					System.out.printf("Maximum Marks : %.2f \n", output);
					break;
				}
				case 3: {
					double output;
					output=object.minimum(marks);
					System.out.printf("Minimum Marks : %.2f \n", output);
					break;
				}
				case 4: {
					double output;
					output=object.percentage_passed(marks);
					System.out.printf(" Percentage passed : %.2f \n", output);
					break;
				}
				case 5: { 
					System.exit(0);
				}
				default: System.out.println("Wrong input!! Try again!!");
			}
		}
	}
}
