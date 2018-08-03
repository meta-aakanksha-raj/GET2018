package graphics;

import java.util.Date;

/**
 * this class implements the Shape class to make objects of Shape Type Circle
 */
public class Circle implements Shape {

	public Date timestamp = null; // time at which object is added to screen
	private float radius;
	private Point origin;

	// Constructor of class
	public Circle(Point origin, float radius) {
		this.origin = origin;
		this.radius = radius;
	}

	@Override
	public float getArea() {

		return (float) (3.14 * radius * radius);
	}

	@Override
	public float getPerimeter() {

		return (float) (2 * 3.14 * radius);
	}

	@Override
	public Point getOrigin() {

		return new Point(origin.getXCoordinate(), origin.getYCoordinate());
	}

	@Override
	public boolean isPointEnclosed(Point pointToBeChecked) {
		boolean enclosed = false;
		float centerXCoordinate, centerYCoordinate, distanceOfPointFromCenter;

		centerXCoordinate = origin.getXCoordinate()
				+ radius
				/ (float) Math.sqrt(1 + origin.getYCoordinate()
						/ origin.getXCoordinate());
		centerYCoordinate = origin.getYCoordinate()
				+ radius
				/ (float) Math.sqrt(1 + origin.getYCoordinate()
						/ origin.getXCoordinate());
		distanceOfPointFromCenter = (float) Math.sqrt(Math.pow(
				centerXCoordinate - pointToBeChecked.getXCoordinate(), 2)
				+ Math.pow(
						centerYCoordinate - pointToBeChecked.getYCoordinate(),
						2));

		if (distanceOfPointFromCenter <= radius)
			enclosed = true;

		return enclosed;
	}

	@Override
	public ShapeEnum getShapeType() {

		return ShapeEnum.CIRCLE;
	}

	@Override
	public float getOriginDistance() {// distance between origin of the shape
										// and origin of the screen

		return (float) Math.sqrt(Math.pow(origin.getXCoordinate(), 2)
				+ Math.pow(origin.getYCoordinate(), 2));
	}

	@Override
	public Date getTimestamp() {

		return timestamp;
	}

	@Override
	public void setTimestamp(Date timestamp) {

		this.timestamp = timestamp;
	}
}
