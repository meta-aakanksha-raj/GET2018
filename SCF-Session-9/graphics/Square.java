package graphics;

import java.util.Date;

/**
 * this class implements the Shape class to make objects of ShapeType square
 *
 */
public class Square implements Shape {

	public Date timestamp = null; // time at which object is added to screen
	private float width;
	private Point origin;

	// Constructor of class
	public Square(Point origin, float width) {
		this.width = width;
		this.origin = origin;
	}

	@Override
	public float getArea() {

		return width * width;
	}

	@Override
	public float getPerimeter() {

		return 4 * width;
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
		if (xPoint > xOrigin && xPoint < xOrigin + width && yPoint > yOrigin
				&& yPoint < yOrigin + width) {
			result = true;
		}
		return result;
	}

	@Override
	public ShapeEnum getShapeType() {

		return ShapeEnum.SQUARE;
	}

	@Override
	public float getOriginDistance() { // distance between origin of the shape
										// and origin of the screen

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
