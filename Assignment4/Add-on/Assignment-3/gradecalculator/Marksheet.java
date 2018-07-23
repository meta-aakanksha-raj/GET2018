package gradecalculator;

public class Marksheet {
	/**
	 * For checking the inputs
	 * @param grade, it is array of marks
	 * @param n, it is total number of students
	 * @return exception if array of marks is negative or empty or size is negative 
	 */
	public boolean checking(double[] grade, int n) {
		boolean result=false;
		for(int i=0;i<n;i++) {
			if(grade[i]<0.0) {
				result=true;
				break;
			}
		}
		if(n < 0 || result==true) {
			throw new AssertionError("Wrong Input");
		}
		return result; 			
	}
	
	/**
	 * For calculating the average
	 * @param grade, it is array of marks
	 * @param n, it is total number of students
	 * @return average of all grades in double
	 */
	public double average(double[] grade, int n) {
		double sum=0.0;
		for(int i=0;i<n;i++) {
			sum=sum+grade[i];
		}
		return sum/n;
	}
	
	/**
	 * For finding maximum marks
	 * @param grade, it is array of marks
	 * @param n, it is total number of students
	 * @return maximum of all grades in double
	 */
	public double maximum(double[] grade,int n) {
		double max=0.0;
		for(int i=0;i<n;i++) {
			if(grade[i]>max) {
				max=grade[i];
			}
		}
		return max;
	}
	
	/**
	 * For calculating minimum marks
	 * @param grade, it is array of marks
	 * @param n, it is total number of students
	 * @return minimum of all grades in double
	 */
	public double minimum(double[] grade,int n ) {
		double min=100.0;
		for(int i=0;i<n;i++) {
			if(grade[i]<min) {
				min=grade[i];
			}
		}
		return min;
	}
	
	/**
	 * For calculating passed percentage
	 * @param grade, it is array of marks
	 * @param n, it is total number of students
	 * @return percentage of students passed in double
	 */
	public double percentagePassed(double[] grade,int n ) {
		double count=0.0;
		double percentage;
		for(int i=0;i<n;i++) {
			if(grade[i]>=40) { 
				count=count+1;
			}		
		}
		percentage=(count/n)*100;
		return percentage;
	}
}