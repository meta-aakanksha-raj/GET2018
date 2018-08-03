package graphics;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;

/**
 * To do the testing for different shapes
 *
 */
public class TestGraphics
{
    /**
     * test case for testing the various methods in Rectangle class
     */
    @Test
    public void rectangleTest()
    {
        Shape rectangle = ShapeFactory.createShape(new Point(1, 1), ShapeEnum.RECTANGLE,  new ArrayList<Float>(){{add((float)(4)); add((float)(2));}});  
        assertEquals(8.0, rectangle.getArea(), 0.1);
        assertEquals(12.0, rectangle.getPerimeter(), 0.1);
        assertTrue(rectangle.isPointEnclosed(new Point(2, 2)));
        assertFalse(rectangle.isPointEnclosed(new Point(5, 5)));
    }
     
    /**
     * test case for testing the various methods in Square class
     */
    @Test
    public void squareTest()
    {
        Shape square = ShapeFactory.createShape(new Point(1, 1), ShapeEnum.SQUARE, new ArrayList<Float>(){{add((float)(4.0));}});
        assertEquals(16.0, square.getArea(), 0.1);
        assertEquals(16.0, square.getPerimeter(), 0.1);
        assertTrue(square.isPointEnclosed(new Point(2, 2)));
        assertFalse(square.isPointEnclosed(new Point(5, 5)));
    }
    
    /**
     * test case for testing the various methods in Triangle class
     */
    @Test
    public void triangleTest()
    {
        Shape triangle = ShapeFactory.createShape(new Point(1, 1), ShapeEnum.TRIANGLE, new ArrayList<Float>(){{add((float)(4.0)); add((float)(3.0)); add((float)(2.0)); add((float)(1.452));}});  
        assertEquals(2.904, triangle.getArea(), 0.1);
        assertEquals(9.0, triangle.getPerimeter(), 0.1);
        assertTrue(triangle.isPointEnclosed(new Point(2, 1)));
        assertFalse(triangle.isPointEnclosed(new Point(5, 5)));
    }
    
    /**
     * test case for testing the various methods in Circle class
     */
    @Test
    public void circleTest()
    {
        Shape circle = ShapeFactory.createShape(new Point(1, 1), ShapeEnum.CIRCLE, new ArrayList<Float>(){{add((float)(4));}});
        assertEquals(50.265, circle.getArea(), 0.1);
        assertEquals(25.133, circle.getPerimeter(), 0.1);
        assertTrue(circle.isPointEnclosed(new Point(2, 1)));
        assertFalse(circle.isPointEnclosed(new Point(10, 5)));
    }
    
    /**
     * test case to add an object to screen
     */
    @Test
    public void addShapeTestFirst()
    {
        Screen objScreen = new Screen(100, 100);
        Shape objShape = ShapeFactory.createShape(new Point(1, 1), ShapeEnum.RECTANGLE,  new ArrayList<Float>(){{add((float)(4)); add((float)(2));}});
        assertTrue(objScreen.addShape(objShape));
    }
    
    /**
     * test case to add an object to screen when object is null
     */
    @Test
    public void addShapeTestSecond()
    {
        Screen objScreen = new Screen(100, 100);
        assertFalse(objScreen.addShape(null));
    }

    /**
     * test case to add an object to screen when shape lies outside the screen
     */
    @Test
    public void addShapeTestThird()
    {    
        Screen objScreen = new Screen(100, 100);
        Shape objShape = ShapeFactory.createShape(new Point(120, 1), ShapeEnum.RECTANGLE, new ArrayList<Float>(){{add((float)(4)); add((float)(2));}});
        assertFalse(objScreen.addShape(objShape));
    }
    
    /**
     * test case to remove a shape from screen when shape is present
     */
    @Test
    public void deleteShapeTestFirst()
    {
        Screen objScreen = new Screen(100, 100);
        Shape objShape = ShapeFactory.createShape(new Point(1, 1), ShapeEnum.RECTANGLE,  new ArrayList<Float>(){{add((float)(4)); add((float)(2));}});
        objScreen.addShape(objShape);
        
        assertTrue(objScreen.deleteShape(objShape));
    }
    
    /**
     * test case to remove a shape from screen when shape is not present
     */
    @Test
    public void deleteShapeTestSecond()
    {
        Shape objShapeFirst, objShapeSecond;
        Screen objScreen = new Screen(100, 100);
        
        objShapeFirst = ShapeFactory.createShape(new Point(1, 1), ShapeEnum.RECTANGLE,  new ArrayList<Float>(){{add((float)(4)); add((float)(2));}});
        objScreen.addShape(objShapeFirst);
        objShapeSecond = ShapeFactory.createShape(new Point(1, 3), ShapeEnum.RECTANGLE, new ArrayList<Float>(){{add((float)(5.0)); add((float)(2.0));}});
        
        assertFalse(objScreen.deleteShape(objShapeSecond));
        assertFalse(objScreen.deleteShape(null));
    }

    /**
     * test case to remove all shapes of a particular type from the screen when objects of that type are present
     */
    @Test
    public void deleteShapeTypeTestFirst()
    {
        Shape objShapeFirst, objShapeSecond, objShapeThird;
        
        Screen objScreen = new Screen(100, 100);
        objShapeFirst = ShapeFactory.createShape(new Point(1, 1), ShapeEnum.RECTANGLE,  new ArrayList<Float>(){{add((float)(4)); add((float)(2));}});
        objScreen.addShape(objShapeFirst);
        
        objShapeSecond = ShapeFactory.createShape(new Point(1, 3), ShapeEnum.RECTANGLE, new ArrayList<Float>(){{add((float)(5.0)); add((float)(2.0));}});
        objScreen.addShape(objShapeSecond);
        
        objShapeThird = ShapeFactory.createShape(new Point(1, 1), ShapeEnum.CIRCLE, new ArrayList<Float>(){{add((float)(4.0));}});
        objScreen.addShape(objShapeThird);
        
        assertTrue(objScreen.deleteShapeType(ShapeEnum.RECTANGLE));
    }
    
    /**
     * test case to remove all shapes of a particular type from the screen when no object of that type are present
     */
    @Test
    public void deleteShapeTypeTestSecond()
    {
        Shape shapeFirst, shapeSecond, shapeThird;
        Screen objScreen = new Screen(100, 100);
        
        shapeFirst = ShapeFactory.createShape(new Point(1, 1), ShapeEnum.RECTANGLE, new ArrayList<Float>(){{add((float)(4)); add((float)(2));}});
        objScreen.addShape(shapeFirst);
        
        shapeSecond = ShapeFactory.createShape(new Point(1, 3), ShapeEnum.RECTANGLE, new ArrayList<Float>(){{add((float)(5.0)); add((float)(2.0));}});
        objScreen.addShape(shapeSecond);
        
        shapeThird = ShapeFactory.createShape(new Point(1, 1), ShapeEnum.CIRCLE, new ArrayList<Float>(){{add((float)(4.0));}});
        objScreen.addShape(shapeThird);
        
        assertFalse(objScreen.deleteShapeType(ShapeEnum.SQUARE));
        assertFalse(objScreen.deleteShapeType(null));
    }
    
    /**
     * test case to sort the shapes on screen according to area
     */
    @Test
    public void sortByAreaTestFirst()
    {
        final Shape shapeFirst, shapeSecond;
        ArrayList<Shape> sortedShapeByArea;
        Screen objScreen = new Screen(100, 100);
        
        shapeFirst = ShapeFactory.createShape(new Point(1, 1), ShapeEnum.RECTANGLE,  new ArrayList<Float>(){{add((float)(4)); add((float)(2));}});
        objScreen.addShape(shapeFirst);
        
        shapeSecond = ShapeFactory.createShape(new Point(1, 1), ShapeEnum.SQUARE, new ArrayList<Float>(){{add((float)(2.0));}});
        objScreen.addShape(shapeSecond);
        
        sortedShapeByArea = objScreen.sortByArea();
        assertEquals(sortedShapeByArea, new ArrayList<Shape>(){{add(shapeSecond); add(shapeFirst);}}); 
    }
    
    /**
     * test case to sort the shapes on screen according to area when no object is present on screen
     */
    @Test(expected = AssertionError.class)
    public void sortByAreaTestSecond()
    {
        Screen objScreen = new Screen(100, 100);
        objScreen.sortByArea();
    }
    
    /**
     * test case to sort the shapes on screen according to Perimeter
     */
    @Test
    public void sortByPerimeterTestFirst()
    {
        final Shape shapeFirst, shapeSecond;
        ArrayList<Shape> sortedShapeByPerimeter;
        Screen objScreen = new Screen(100, 100);
        
        shapeFirst = ShapeFactory.createShape(new Point(1, 1), ShapeEnum.RECTANGLE,  new ArrayList<Float>(){{add((float)(4)); add((float)(2));}});
        objScreen.addShape(shapeFirst);
        
        shapeSecond = ShapeFactory.createShape(new Point(1, 1), ShapeEnum.SQUARE, new ArrayList<Float>(){{add((float)(2.0));}});
        objScreen.addShape(shapeSecond);
        
        sortedShapeByPerimeter = objScreen.sortByPerimeter();
        assertEquals(sortedShapeByPerimeter, new ArrayList<Shape>(){{add(shapeSecond); add(shapeFirst);}}); 
    }
    
    /**
     * test case to sort the shapes on screen according to Perimeter when no object is present on screen
     */
    @Test(expected = AssertionError.class)
    public void sortByPerimeterTestSecond()
    {
        Screen objScreen = new Screen(100, 100);
        objScreen.sortByPerimeter();
    }
    
    /**
     * test case to sort the shapes on screen according to OriginDistance
     */
    @Test
    public void sortByOriginDistanceTestFirst()
    {
        final Shape shapeFirst, shapeSecond, shapeThird;
        ArrayList<Shape> sortedShapeByOriginDistance;
        Screen objScreen = new Screen(100, 100);
        
        shapeFirst = ShapeFactory.createShape(new Point(1, 1), ShapeEnum.RECTANGLE,  new ArrayList<Float>(){{add((float)(4)); add((float)(2));}});
        objScreen.addShape(shapeFirst);
        
        shapeSecond = ShapeFactory.createShape(new Point(2, 1), ShapeEnum.SQUARE, new ArrayList<Float>(){{add((float)(2.0));}});
        objScreen.addShape(shapeSecond);
        
        shapeThird = ShapeFactory.createShape(new Point(0, 0), ShapeEnum.CIRCLE, new ArrayList<Float>(){{add((float)(4.0));}});
        objScreen.addShape(shapeThird);
        
        sortedShapeByOriginDistance = objScreen.sortByOriginDistance();
        assertEquals(sortedShapeByOriginDistance, new ArrayList<Shape>(){{add(shapeThird); add(shapeFirst); add(shapeSecond);}}); 
    }
    
    /**
     * test case to sort the shapes on screen according to OriginDistance when no object is present on screen
     */
    @Test(expected = AssertionError.class)
    public void sortByOriginDistanceTestSecond()
    {
        Screen objScreen = new Screen(100, 100);
        objScreen.sortByOriginDistance();
    }
    
    /**
     * test case to sort the shapes on screen according to Timestamp
     */
    @Test
    public void sortByTimestampTestFirst()
    {
        final Shape shapeFirst, shapeSecond, shapeThird;
        ArrayList<Shape> sortedShapeByTimestamp;
        Screen objScreen = new Screen(100, 100);
        
        shapeFirst = ShapeFactory.createShape(new Point(1, 1), ShapeEnum.RECTANGLE, new ArrayList<Float>(){{add((float)(4)); add((float)(2));}});
        objScreen.addShape(shapeFirst);
        
        shapeSecond = ShapeFactory.createShape(new Point(2, 1), ShapeEnum.SQUARE, new ArrayList<Float>(){{add((float)(2.0));}});
        objScreen.addShape(shapeSecond);
        
        shapeThird = ShapeFactory.createShape(new Point(0, 0), ShapeEnum.CIRCLE, new ArrayList<Float>(){{add((float)(4.0));}});
        objScreen.addShape(shapeThird);
        
        sortedShapeByTimestamp = objScreen.sortByTimestamp();
        assertEquals(sortedShapeByTimestamp, new ArrayList<Shape>(){{add(shapeFirst); add(shapeSecond); add(shapeThird);}}); 
    }
    
    /**
     * test case to sort the shapes on screen according to Timestamp when no object is present on screen
     */
    @Test(expected = AssertionError.class)
    public void sortByTimestampTestSecond()
    {
        Screen objScreen = new Screen(100, 100);
        objScreen.sortByTimestamp();
    }
    
    /**
     * test case for shapesEnclosingPoint 
     */
   @Test
    public void shapesEnclosingPointTestFirst()
    {
        final Shape shapeFirst, shapeSecond, shapeThird;
        ArrayList<Shape> shapesEnclosingPoint;
        Screen objScreen = new Screen(100, 100);

        shapeFirst = ShapeFactory.createShape(new Point(1, 1), ShapeEnum.RECTANGLE, new ArrayList<Float>(){{add((float)(4)); add((float)(2));}});
        objScreen.addShape(shapeFirst);
        
        shapeSecond = ShapeFactory.createShape(new Point(2, 1), ShapeEnum.SQUARE, new ArrayList<Float>(){{add((float)(2));}});
        objScreen.addShape(shapeSecond);
        
        shapeThird = ShapeFactory.createShape(new Point(0, 0), ShapeEnum.CIRCLE, new ArrayList<Float>(){{add((float)(2));}});
        objScreen.addShape(shapeThird);
        
        shapesEnclosingPoint = objScreen.shapesEnclosingPoint(new Point(3, 2));
        assertEquals(shapesEnclosingPoint, new ArrayList<Shape>(){{add(shapeFirst); add(shapeSecond);}}); 
    }
    
    /**
     * test case for shapesEnclosingPoint when list of shapes is empty 
     */
    @Test
    public void shapesEnclosingPointTestSecond()
    {
        Screen objScreen = new Screen(100, 100);
        objScreen.shapesEnclosingPoint(new Point(2, 1));
    }
}