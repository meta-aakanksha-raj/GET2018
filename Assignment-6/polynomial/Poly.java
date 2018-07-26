package polynomial;
import java.lang.Math;

final class Poly {
	final private int n;
	final private int[][] newArray;
	
	public Poly(int[][]powerCoefficient) {
		int[][] originalArray=Poly.getArray(powerCoefficient);
		newArray=removeCoefficientZero(originalArray);
		n=newArray[0].length;
		checking(newArray);
	}
	
	private static int[][] getArray(int[][] powerCoefficient) {
		int[][] array=new int[2][powerCoefficient[0].length];
		for(int i=0;i<powerCoefficient[0].length;i++) {
			array[0][i]=powerCoefficient[0][i];
			array[1][i]=powerCoefficient[1][i];			
		}
		return array;
	}
	
	private void checking(int[][] newArray) {
		if(n==0) {
			throw new AssertionError("Set is empty");
		}
	}
	
	private int[][] removeCoefficientZero(int[][] originalArray) {
		int[][] copiedArray=getArray(originalArray);
		int length=copiedArray[0].length;
		int count=0;
		for(int i=0;i<length;i++) {
			if(0==copiedArray[1][i]) {
				count++;
			}
		}
		System.out.println(count);
		int arrayLength=length-count;
		int[][] newArray=new int[2][arrayLength];
		for(int i=0,j=0;i<length;i++) {
			if(copiedArray[1][i]!=0) {
				newArray[0][j]=copiedArray[0][i];
				newArray[1][j]=copiedArray[1][i];
				j++;
			}
		}
		return newArray;
	}
	
	public double evaluate(double value) {
		double result=0;
		for(int j=0;j<this.n;j++) {
			int x=newArray[0][j];
			double product=Math.pow(value, x);
			result=result+newArray[1][j]*product;
		}
		return result;
	}
	
	public int degree() {
		int max=0;
		for(int i=0;i<n;i++) {
			if(newArray[0][i]>max) {
				max=newArray[0][i];
			}
		}
		return max;
	}
	
	/*public int[][] addPoly(Poly p1, Poly p2) {
		int k=0;
		boolean flag=false;
		for(int i=0;i<p1.n;i++){
			for(int j=0;j<p2.n;j++) {
				if(p1.newArray[0][i]==p2.newArray[0][j]) {
					array[0][k]=p1.newArray[0][i];
					array[1][k]=p1.newArray[1][i]+p2.newArray[1][i];
					k++;					
					break;
				}
				else {
					array[0][k]=p1.newArray[0][i];
					array[1][k]=p1.newArray[1][i];
					k++;
				}
			}
			
		}
	}*/
}
