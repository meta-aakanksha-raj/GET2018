package graphics;

/**
 * This is main class for graphics
 * 
 * @author aakan
 *
 */
public class GraphicsMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Circle circle = new Circle(new Point(10, 10), 10);
		System.out.println();
		System.out.println("For Circle :-");
		System.out.println("Area= " + circle.getArea());
		System.out.println("Perimeter= " + circle.getPerimeter());
		System.out.println("is point enclosed? "
				+ circle.isPointEnclosed(new Point(10, 15)));
		Point point = circle.getOrigin();
		System.out.println("X origin= " + point.getXCoordinate());
		System.out.println("Y origin= " + point.getYCoordinate());

		System.out.println();
		System.out.println("For Square :-");
		Square square = new Square(new Point(10, 10), 10);
		System.out.println("Area= " + square.getArea());
		System.out.println("Perimeter= " + square.getPerimeter());
		System.out.println("is point enclosed? "
				+ square.isPointEnclosed(new Point(10, 50)));
		Point point1 = square.getOrigin();
		System.out.println("X origin= " + point1.getXCoordinate());
		System.out.println("Y origin= " + point1.getYCoordinate());

		System.out.println();
		System.out.println("For Rectangle :-");
		Rectangle rectangle = new Rectangle(new Point(10, 10), 40, 20);
		System.out.println("Area= " + rectangle.getArea());
		System.out.println("Perimeter= " + rectangle.getPerimeter());
		System.out.println("is point enclosed? "
				+ rectangle.isPointEnclosed(new Point(30, 15)));
		Point point2 = rectangle.getOrigin();
		System.out.println("X origin= " + point2.getXCoordinate());
		System.out.println("Y origin= " + point2.getYCoordinate());

		System.out.println();
		System.out.println("For Triangle :-");
		Triangle triangle = new Triangle(new Point(10, 10), 40, 20, 30);
		System.out.println("Area= " + triangle.getArea());
		System.out.println("Perimeter= " + triangle.getPerimeter());
		System.out.println("is point enclosed? "
				+ rectangle.isPointEnclosed(new Point(10, 50)));
		Point point3 = triangle.getOrigin();
		System.out.println("X origin= " + point3.getXCoordinate());
		System.out.println("Y origin= " + point3.getYCoordinate());

		System.out.println();
		System.out.println("For RegularPolygon :-");
		Polygon polygon = new Polygon(new Point(10, 10), 4, 20);
		System.out.println("Area= " + polygon.getArea());
		System.out.println("Perimeter= " + polygon.getPerimeter());
		System.out.println("is point enclosed? "
				+ polygon.isPointEnclosed(new Point(10, 50)));
		Point point4 = triangle.getOrigin();
		System.out.println("X origin= " + point4.getXCoordinate());
		System.out.println("Y origin= " + point4.getYCoordinate());
	}
}