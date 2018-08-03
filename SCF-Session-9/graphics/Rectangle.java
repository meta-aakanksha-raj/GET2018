package graphics;

import java.util.Date;

/**
 * this class implements the Shape class to make objects of Shape Type Rectangle
 *
 */
public class Rectangle implements Shape {

	public Date timestamp = null; // time at which object is added to screen
	private float breadth;
	private float length;
	private Point origin;

	// Constructor of class
	public Rectangle(Point origin, float length, float breadth) {
		this.origin = origin;
		this.length = length;
		this.breadth = breadth;
	}

	@Override
	public float getArea() {

		return length * breadth;
	}

	@Override
	public float getPerimeter() {

		return 2 * (length + breadth);
	}

	@Override
	public Point getOrigin() {

		return new Point(origin.getXCoordinate(), origin.getYCoordinate());
	}

	@Override
	public boolean isPointEnclosed(Point isEnclosedPoint) {

		boolean result = false;
		float xOrigin = origin.getXCoordinate();
		float yOrigin = origin.getYCoordinate();
		float xPoint = isEnclosedPoint.getXCoordinate();
		float yPoint = isEnclosedPoint.getYCoordinate();
		if (xPoint > xOrigin && xPoint < xOrigin + length && yPoint > yOrigin
				&& yPoint < yOrigin + breadth) {
			result = true;
		}
		return result;
	}

	@Override
	public ShapeEnum getShapeType() {

		return ShapeEnum.RECTANGLE;
	}

	@Override
	public float getOriginDistance() // distance between origin of the shape and
										// origin of the screen
	{
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
}
