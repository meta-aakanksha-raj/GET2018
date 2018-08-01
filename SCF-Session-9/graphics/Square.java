package graphics;

public class Square implements Shape{
	private int width;
	private Point point;
	
	public Square(Point point, int values) {
		this.width = values;
		this.point = point;
	}
	
	@Override
	public double getArea() {
	
		return width * width;
	}

	@Override
	public double getPerimeter() {
		
		return 4 * width;
	}

	@Override
	public Point getOrigin() {
		return new Point(point.getxCoordinate(), point.getyCoordinate());
	}
	
	@Override
	public ShapeEnum getShapeType() {
		
		return ShapeEnum.SQUARE;
	}
}
