package graphics;

import java.util.Date;

/**
 * this class implements the Shape class to make objects of Shape Type Regular
 * Polygon
 *
 */
public class Polygon implements Shape {
	
	// time at which object is added to screen
	public Date timestamp = null; 
	private int noOfSides;
	private float lengthOfSide;
	private Point origin;

	// Constructor of class
	public Polygon(Point origin, float noOfSides, float lengthOfSide) {
		this.noOfSides = (int) noOfSides;
		this.lengthOfSide = lengthOfSide;
		this.origin = origin;
	}

	@Override
	public float getArea() {
		return (float) ((getPerimeter() * getApothem()) / 2.0);
	}

	@Override
	public float getPerimeter() {
		return lengthOfSide * noOfSides;
	}

	@Override
	public Point getOrigin() {
		return new Point(origin.getXCoordinate(), origin.getYCoordinate());
	}

	@Override
	public boolean isPointEnclosed(Point isEnclosedPoint) {
		return false;
	}

	@Override
	public ShapeEnum getShapeType() {
		return ShapeEnum.REGULARPOLYGON;
	}

	// distance between origin of the shapeand origin of the screen
	@Override
	public float getOriginDistance() { 
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

	private float getApothem() {
		return (float) (lengthOfSide / (2 * Math.tan(180 / noOfSides)));
	}
}
