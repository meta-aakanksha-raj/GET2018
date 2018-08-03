package graphics;

import java.util.ArrayList;

/**
 * this class creates objects of various shape types
 */
public class ShapeFactory {
	/**
	 * method to create the object of specified shape type
	 * 
	 * @param shapeType
	 * @param origin
	 * @param parameters
	 *            , list of parameters vary according to shape type
	 */
	public static Shape createShape(Point origin, ShapeEnum shapeType,
			ArrayList<Float> parameterList) {
		switch (shapeType) {
		// parameters contains radius
		case CIRCLE:
			return new Circle(origin, parameterList.get(0));

			// parameters contains width, height
		case RECTANGLE:
			return new Rectangle(origin, parameterList.get(0),
					parameterList.get(1));

			// parameters contains side
		case SQUARE:
			return new Square(origin, parameterList.get(0));

			// parameters contains length of firstSide, length of secondSide,
			// length of thirdSide
		case TRIANGLE:
			return new Triangle(origin, parameterList.get(0),
					parameterList.get(1), parameterList.get(2));

			// parameters contains no. of sides, length of side
		case REGULARPOLYGON:
			return new Polygon(origin, parameterList.get(0),
					parameterList.get(1));

		default:
			throw new AssertionError("No such shape found");
		}
	}
}
