package polynomial;

import java.util.Scanner;

public class MainPoly {
	public static void main(String args[]){
		Scanner input=new Scanner(System.in);
		
		Poly object=new Poly(new int[][]{{2,1,0},{4,3,1}});
		//Poly object=new Poly(new int[][]{{4,2,1,0},{3,4,2,6}});
		//Poly object=new Poly(0,new int[][]{{},{}});
		//Poly object=new Poly(4,new int[][]{{4,2,1,0},{3,4,0,6}});
		
		System.out.println("Enter the value of variable");
		double value=input.nextDouble();
		double result=object.evaluate(value);
		System.out.println("Result= " +result);
		
		int output=object.degree();
		System.out.println("Degree= " + output);
		/*
		Poly p1=new Poly(4,new int[][]{{4,2,1,0},{3,4,2,6}});
		Poly p2=new Poly(4,new int[][]{{4,2,1,0},{3,4,2,6}});
		int[][] adding=p1.addPoly(p1,p2);*/
	}
}