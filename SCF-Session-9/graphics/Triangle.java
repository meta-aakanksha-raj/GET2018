package graphics;

public class Triangle implements Shape{

	private Point point;
	private int side3;
	private int side1;
	private int side2;
	private int height;
	
	public Triangle(Point point, int side1, int side2, int side3, int height) {
		this.point = point;
		this.side3 = side3;
		this.side1 = side1;
		this.side2 = side2;
		this.height = height;
	}

	@Override
	public double getPerimeter() {
		
		return (side1 + side2 + side3);
	}

	@Override
	public Point getOrigin() {
		
		return new Point(point.getxCoordinate(), point.getyCoordinate());
	}
	
	@Override
	public ShapeEnum getShapeType() {
		
		return ShapeEnum.TRIANGLE;
	}
}

