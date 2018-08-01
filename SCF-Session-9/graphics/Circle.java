package graphics;

public class Circle implements Shape{
	
	private int radius;
	private Point point;
	
	public Circle(Point point, int values)
	{
		this.point = point;
		this.radius = values;
	}
	
	@Override
	public double getArea() {
		
		return 3.14 * radius * radius;
	}

	@Override
	public double getPerimeter() {
		
		return 2 * 3.14 * radius;
	}
	
	@Override
	public ShapeEnum getShapeType() {
		
		return ShapeEnum.CIRCLE;
	}
}
