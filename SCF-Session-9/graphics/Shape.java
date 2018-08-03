package graphics;

import java.util.Date;

/**
 * interface for creating shape objects
 *
 */
public interface Shape {

	/**
	 * calculates the area of the shape
	 * 
	 * @return area
	 */
	public float getArea();

	/**
	 * calculates the perimeter of the shape
	 * 
	 * @return perimeter
	 */
	public float getPerimeter();

	/**
	 * @return origin of the shape
	 */
	public Point getOrigin();

	/**
	 * checks if the given point lies inside the shape or not
	 */
	public boolean isPointEnclosed(Point isEnclosedPoint);

	/**
	 * @return ShapeType of the shape
	 */
	public ShapeEnum getShapeType();

	/**
	 * @return originDistance, i.e the distance between origin of the shape and
	 *         origin of the screen
	 */
	public float getOriginDistance();

	/**
	 * @return timestamp of the shape
	 */
	public Date getTimestamp();

	/**
	 * sets the timestamp at which the object is added to the screen
	 * 
	 * @param timestamp
	 */
	public void setTimestamp(Date timestamp);

}
