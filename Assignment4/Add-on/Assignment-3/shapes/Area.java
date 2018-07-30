package shapes;

public class Area {
	/**
	 * To calulate area of triangle
	 * @param width, stores base of triangle
	 * @param height, stores height of triangle
	 * @return exception if width or height is negative else returns area of triangle
	 */
	public double triangleArea(double width,double height) {
		if(width < 0 || height < 0) {
			throw new AssertionError("Width and Height should be greater than zero");
		}
		double area;
		area=0.5* width * height;   
		return area;
	}

	/**
	 * To calulate area of rectangle
	 * @param width, stores length of rectangle
	 * @param height, stores height of rectangle
	 * @return exception if width or height is negative else returns area of rectangle
	 */
	public double rectangleArea(double width,double height) {
		if(width < 0 || height < 0) {
			throw new AssertionError("Width and Height should be greater than zero");
		}
		double area;
		area= width* height ;
		return area;
	}

	/**
	 * To calulate area of square
	 * @param width, stores side of square
	 * @return exception if width is negative else returns area of square
	 */
	public double squareArea(double width) {
		if(width < 0) {
			throw new AssertionError("Width should be greater than zero");
		}
		double area;
		area=width*width;
		return area;
	}

	/**
	 * To calculate area of circle
	 * @param radius, stores radius of circle
	 * @return exception if radius is negative else returns area of circle
	 */
	public double circleArea(double radius) {
		if(radius < 0) {
			throw new AssertionError("Radius should be greater than zero");
		}
		double area;
		area=3.14* radius* radius;
		return area;
	}
}