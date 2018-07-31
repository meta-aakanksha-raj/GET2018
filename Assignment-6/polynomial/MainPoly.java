package polynomial;

import java.util.Scanner;

public class MainPoly {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the size of polynomial array");
		int size = input.nextInt();
		int[][] poly = new int[2][size];
		System.out.println("Enter all power first ");
		for (int i = 0; i < size; i++) {
			poly[0][i] = input.nextInt();
		}
		System.out.println("Enter all coefficients ");
		for (int i = 0; i < size; i++) {
			poly[1][i] = input.nextInt();
		}

		// Creating object
		Poly object = new Poly(poly);

		// Enter variable value
		System.out.println("Enter the value of variable");
		double value = input.nextDouble();
		double result = object.evaluate(value);
		System.out.println("Result= " + result);

		// To get degree of polynomial
		int output = object.degree();
		System.out.println("Degree= " + output);

		// creating first polynomial for addition and multiplication
		System.out
				.println("Enter the size of polynomial first polynomial array ");
		int sizeFirst = input.nextInt();
		int[][] polyOne = new int[2][sizeFirst];
		System.out.println("Enter all power first ");
		for (int i = 0; i < sizeFirst; i++) {
			polyOne[0][i] = input.nextInt();
		}
		System.out.println("Enter all coefficients ");
		for (int i = 0; i < sizeFirst; i++) {
			polyOne[1][i] = input.nextInt();
		}

		// creating second polynomial for addition and multiplication
		System.out
				.println("Enter the size of polynomial second polynomial array ");
		int sizeSecond = input.nextInt();
		int[][] polyTwo = new int[2][sizeSecond];
		System.out.println("Enter all power first ");
		for (int i = 0; i < sizeSecond; i++) {
			polyTwo[0][i] = input.nextInt();
		}
		System.out.println("Enter all coefficients ");
		for (int i = 0; i < sizeSecond; i++) {
			polyTwo[1][i] = input.nextInt();
		}

		// Creating object
		Poly p1 = new Poly(polyOne);
		Poly p2 = new Poly(polyTwo);
		Poly p3 = new Poly();

		// For addition and multiplication of polynomial
		System.out.println("Addition array of polynomial ");
		int[][] addArray = p3.addPoly(p1, p2);
		System.out.println("Multiplication array of polynomial ");
		int[][] multArray = p3.multPoly(p1, p2);
	}
}
