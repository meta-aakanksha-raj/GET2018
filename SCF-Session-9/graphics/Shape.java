package graphics;

public interface Shape {

	public double getArea();

	public double getPerimeter();

	public Point getOrigin();

	public boolean isPointEnclosed();

	public ShapeEnum getShapeType();

}