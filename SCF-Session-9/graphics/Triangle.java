package graphics;

import java.util.Date;

/**
 * this class implements the Shape class to make objects of ShapeType triangle
 *
 */
public class Triangle implements Shape {

	// time at which object is added to screen
	public Date timestamp = null;
	private Point origin;
	private float firstSide, secondSide, thirdSide;

	// Constructor of class
	public Triangle(Point origin, float firstSide, float secondSide,
			float thirdSide) {
		this.origin = origin;
		this.firstSide = firstSide;
		this.secondSide = secondSide;
		this.thirdSide = thirdSide;
	}

	@Override
	public float getArea() {
		double halfPerimeter = getPerimeter() / 2;
		return (float) (Math.sqrt(halfPerimeter * (halfPerimeter - firstSide)
				* (halfPerimeter - secondSide) * (halfPerimeter - thirdSide)));
	}

	@Override
	public float getPerimeter() {
		return (firstSide + secondSide + thirdSide);
	}

	@Override
	public Point getOrigin() {
		return new Point(origin.getXCoordinate(), origin.getYCoordinate());
	}

	@Override
	public ShapeEnum getShapeType() {
		return ShapeEnum.TRIANGLE;
	}

	// distance between origin of the shape and origin of the screen
	@Override
	public float getOriginDistance() {
		return (float) Math.sqrt((Math.pow(origin.getXCoordinate(), 2) + Math
				.pow(origin.getYCoordinate(), 2)));
	}

	@Override
	public Date getTimestamp() {
		return timestamp;
	}

	@Override
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public boolean isPointEnclosed(Point point) {
		boolean enclosed = false;
		float height, base;
		Point secondPoint, thirdPoint;

		height = 2 * getArea() / firstSide;
		base = (float) Math.sqrt(Math.pow(thirdSide, 2) - Math.pow(height, 2));

		secondPoint = new Point(origin.getXCoordinate() + firstSide,
				origin.getYCoordinate());
		thirdPoint = new Point(origin.getXCoordinate() + base,
				origin.getYCoordinate() + height);

		if (Math.abs(getArea()
				- ((getAreaByVertices(point, origin, secondPoint))
						+ getAreaByVertices(point, secondPoint, thirdPoint) + getAreaByVertices(
							point, origin, thirdPoint))) <= 0.001) {
			enclosed = true;
		}
		return enclosed;
	}

	public double getAreaByVertices(Point origin, Point secondPoint,
			Point thirdPoint) {
		return Math
				.abs((origin.getXCoordinate()
						* (secondPoint.getYCoordinate() - thirdPoint
								.getYCoordinate())
						+ secondPoint.getXCoordinate()
						* (thirdPoint.getYCoordinate() - origin
								.getYCoordinate()) + thirdPoint
						.getXCoordinate()
						* (origin.getYCoordinate() - secondPoint
								.getYCoordinate())) / 2.0);
	}
}
