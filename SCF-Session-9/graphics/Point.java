package graphics;

public class Point {
	
	private int xCoordinate;
	private int yCoordinate;
	
	 public Point(int xCoordinate,int yCoordinate) {
		 this.xCoordinate=xCoordinate;
		 this.yCoordinate=yCoordinate;
	 }

	/**
	 * @return the xCoordinate
	 */
	public int getxCoordinate() {
		return xCoordinate;
	}

	/**
	 * @return the yCoordinate
	 */
	public int getyCoordinate() {
		return yCoordinate;
	}
}
