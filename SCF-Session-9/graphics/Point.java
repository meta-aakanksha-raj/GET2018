package graphics;

/**
 * This class represents coordinates
 *
 */
public class Point {

	private float xCoordinate, yCoordinate; // to store x and y coordinates

	// Constructor of class
	public Point(float xCoordinate, float yCoordinate) {
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
	}

	/**
	 * @return the xCoordinate
	 */
	public float getXCoordinate() {
		return xCoordinate;
	}

	/**
	 * @return the yCoordinate
	 */
	public float getYCoordinate() {
		return yCoordinate;
	}
}
