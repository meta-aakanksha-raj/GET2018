package graphics;

public class Rectangle implements Shape{

	private int breadth;
	private int length;
	private Point point;
	
	public Rectangle(Point point, int length, int breadth) {
		this.point = point;
		this.length = length;
		this.breadth = breadth;
	}
	
	@Override
	public double getArea() {
		
		return length * breadth;
	}

	@Override
	public double getPerimeter() {
		
		return 2 * (length + breadth);
	}

	@Override
	public Point getOrigin() {
		
		return new Point(point.getxCoordinate(), point.getyCoordinate());
	}
	@Override
	public ShapeEnum getShapeType() {
		
		return ShapeEnum.RECTANGLE;
	}	
}
