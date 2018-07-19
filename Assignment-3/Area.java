import java.util.Scanner;
class Shapes {
	private double result;
	/* This function will work for triangle.
	If user has entered wrong values then it  will throw ArithmeticExceptiontic*/
	public double traingle(double base,double height) throws ArithmeticException {
		double base_traingle=base;
		double height_traingle=height;
		double area;
		area=0.5*base_traingle*height_traingle;
		return area;
	}

	/* This function will work for rectangle.
	If user has entered wrong values then it  will throw ArithmeticException*/	
	public double rectangle(double width,double height) throws ArithmeticException {
		double width_rectangle=width;
		double height_rectangle=height;
		double area;
		area=width_rectangle*height_rectangle;
		return area;
	}
	
	/* This function will work for square.
	If user has entered wrong value then it  will throw ArithmeticException*/
	public double square(double width) throws ArithmeticException {
		double width_square=width;
		double area;
		area=width_square*width_square;
		return area;
	}

	/* This function will work for circle.
	If user has entered wrong values then it  will throw ArithmeticException*/	
	public double circle(double radius) throws ArithmeticException {
		double radius_circle=radius;
		double area;
		area=3.14*radius_circle*radius_circle;
		return area;
	}
}

public class Area {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		Shapes object=new Shapes();
		/* Different shapes are provided here.
		Choose what shape you want */
		while(true) {
			System.out.println("\n Choose from following Shapes: \n 1. Triangle \n 2. Rectangle \n 3. Square \n 4. Circle \n 5. Exit ");
			int choice;
			choice=input.nextInt();
			/* Enter values for width, height and radius greater than zero (>0), 
			otherwise it may give incorrect output */
			switch(choice) {
				case 1: {
					double base,height,output;
					System.out.println("Enter base of traingle");
					base=input.nextDouble();
					System.out.println("Enter height of triangle");
					height=input.nextDouble();					
					output=object.traingle(base,height);
					System.out.println("Area of Traingle: "+output);
					break;
				}
				case 2: {
					double width,height,output;
					System.out.println("Enter width of rectangle");
					width=input.nextDouble();
					System.out.println("Enter height of rectangle");
					height=input.nextDouble();					
					output=object.rectangle(width,height);
					System.out.println("Area of Rectangle: "+output);
					break;
				}
				case 3: {
					double width,output;
					System.out.println("Enter width of square");
					width=input.nextDouble();					
					output=object.square(width);
					System.out.println("Area of Square: "+output);
					break;
				}
				case 4: {
					double radius,output;
					System.out.println("Enter radius of circle");
					radius=input.nextDouble();					
					output=object.circle(radius);
					System.out.println("Area of circle: "+output);
					break;
				}
				case 5: {
					System.exit(0);
				}
				default: System.out.println("Wrong input!! Try again!!");//If user has entered wrong input then default case will run 
			}
		}
	}
}