import java.util.Scanner;

class Shapes {

	/**
	 * This function gives area of triangle 
	 * @param width > 0
	 * @param height > 0
	 * @return area of triangle in double
	 * @throws ArithmeticException , if user has entered wrong values
	 */
	public double traingle(double width, double height)
			throws ArithmeticException {
		double baseTriangle = width;
		double heightTriangle = height;
		double area;
		area = 0.5 * baseTriangle * heightTriangle;
		return area;
	}

	/**
	 * This function gives area of rectangle 
	 * @param width > 0
	 * @param height > 0
	 * @return area of rectangle in double
	 * @throws ArithmeticException , if user has entered wrong values
	 */
	public double rectangle(double width, double height)
			throws ArithmeticException {
		double widthRectangle = width;
		double heightRectangle = height;
		double area;
		area = widthRectangle * heightRectangle;
		return area;
	}

	/**
	 * This function gives area of square
	 * @param width > 0
	 * @return area of square in double
	 * @throws ArithmeticException , if user has entered wrong values
	 */
	public double square(double width) throws ArithmeticException {
		double widthSquare = width;
		double area;
		area = widthSquare * widthSquare;
		return area;
	}

	/**
	 * This function gives area of circle
	 * @param radius > 0
	 * @return area of circle in double
	 * @throws ArithmeticException , if user has entered wrong values
	 */
	public double circle(double radius) throws ArithmeticException {
		double radiusCircle = radius;
		double area;
		area = 3.14 * radiusCircle * radiusCircle;
		return area;
	}
}

public class Area {
	
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		Shapes object = new Shapes();
		
		/**
		 * Different shapes are provided here.Choose what shape you want.
		 */
		while (true) {
			System.out
					.println("\n Choose from following Shapes: \n 1. Triangle \n 2. Rectangle \n 3. Square \n 4. Circle \n 5. Exit ");
			int choice;
			choice = input.nextInt();
			
			/**
			 * Enter values for width, height and radius greater than zero
			 * (>0),otherwise it may give incorrect output
			 */
			switch (choice) {
			case 1: {
				double width, height, output;
				System.out.println("Enter base of traingle");
				width = input.nextDouble();
				System.out.println("Enter height of triangle");
				height = input.nextDouble();
				output = object.traingle(width, height);
				System.out.println("Area of Traingle: " + output);
				break;
			}
			case 2: {
				double width, height, output;
				System.out.println("Enter width of rectangle");
				width = input.nextDouble();
				System.out.println("Enter height of rectangle");
				height = input.nextDouble();
				output = object.rectangle(width, height);
				System.out.println("Area of Rectangle: " + output);
				break;
			}
			case 3: {
				double width, output;
				System.out.println("Enter width of square");
				width = input.nextDouble();
				output = object.square(width);
				System.out.println("Area of Square: " + output);
				break;
			}
			case 4: {
				double radius, output;
				System.out.println("Enter radius of circle");
				radius = input.nextDouble();
				output = object.circle(radius);
				System.out.println("Area of circle: " + output);
				break;
			}
			case 5: {
				System.exit(0);
			}
			default:
				System.out.println("Wrong input!! Try again!!");
			}
		}
	}
}
