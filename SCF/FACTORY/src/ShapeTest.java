import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class ShapeTest {

    Screen screen = new Screen(100, 100);
    Shape shape1,shape2,shape3,shape4;
    Double area;
    Point point1,point2;
    int result;
    boolean res;
    public static AssertionError InvalidShapeType = new AssertionError(" Invalid shape type !!!");
    public static AssertionError InvalidCoordinates = new AssertionError("Invalid coordinates!!!");
    public static AssertionError InvalidId = new AssertionError("Invalid id!!!");

    
    @Test
    public void testCreateShapeCircle(){
        shape1 = screen.addShape(1, Shape.ShapeType.CIRCLE, new Point(3, 4), new ArrayList<Double>(Arrays.asList(5.0)));
        area = shape1.getArea();
        assertEquals(Math.PI *25, area, 0);
    }

  
    @Test(expected = AssertionError.class)
    public void testCreateShapeCircleInvalidOrigin(){
        shape1 = screen.addShape(1, Shape.ShapeType.CIRCLE, new Point(-3, -4), new ArrayList<Double>(Arrays.asList(5.0)));
    }


    
    @Test
    public void testCreateShapeSquare(){
        shape1 = screen.addShape(2, Shape.ShapeType.SQUARE, new Point(2, 1), new ArrayList<Double>(Arrays.asList(4.0)));
        area = shape1.getPerimeter();
        assertEquals(16, area, 0);
    }

   
    @Test(expected = AssertionError.class)
    public void testCreateShapeSquareInvalidCoordinates(){
        shape1 = screen.addShape(2, Shape.ShapeType.SQUARE, new Point(2, 1), new ArrayList<Double>(Arrays.asList(140.0)));
    }

   
    @Test
    public void testCreateShapeRectangle(){
        shape1 = screen.addShape(1, Shape.ShapeType.RECTANGLE, new Point(2.0, 2.0),
                new ArrayList<Double>(Arrays.asList(3.0, 4.0)));
        assertEquals(1, shape1.getId());
    }

    
    @Test
    public void testCreateShapeTriangle(){
        shape1 = screen.addShape(1, Shape.ShapeType.TRIANGLE, new Point(0, 0),
                new ArrayList<Double>(Arrays.asList(3.0, 4.0, 5.0, 5.0)));
        area = shape1.getArea();
        assertEquals(6, area, 0);
    }

  
    @Test(expected = AssertionError.class)
    public void testCreateShapeTriangleInvalidId() {
        shape1 = screen.addShape(1, Shape.ShapeType.TRIANGLE, new Point(0, 0),
                new ArrayList<Double>(Arrays.asList(3.0, 4.0, 5.0, 5.0)));
        shape2 = screen.addShape(1, Shape.ShapeType.TRIANGLE, new Point(0, 0),
                new ArrayList<Double>(Arrays.asList(3.0, 4.0, 5.0, 5.0)));
    }

   
    @Test
    public void testDeleteAllShape(){
        shape1 = screen.addShape(1, Shape.ShapeType.RECTANGLE, new Point(2, 1),
                new ArrayList<Double>(Arrays.asList(3.0, 4.0)));
        shape2 = screen.addShape(2, Shape.ShapeType.RECTANGLE, new Point(3, 2),
                new ArrayList<Double>(Arrays.asList(3.0, 4.0)));
        shape3 = screen.addShape(3, Shape.ShapeType.RECTANGLE, new Point(2, 2),
                new ArrayList<Double>(Arrays.asList(3.0, 4.0)));
        shape4 = screen.addShape(4, Shape.ShapeType.SQUARE, new Point(2, 1), new ArrayList<Double>(Arrays.asList(4.0)));
        result = screen.deleteAllShapeType(Shape.ShapeType.RECTANGLE);
        assertEquals(3, result);

    }

 
    @Test
    public void testDeleteShape(){
        shape1 = screen.addShape(1, Shape.ShapeType.RECTANGLE, new Point(2, 1),
                new ArrayList<Double>(Arrays.asList(3.0, 4.0)));
        shape2 = screen.addShape(2, Shape.ShapeType.RECTANGLE, new Point(3, 2),
                new ArrayList<Double>(Arrays.asList(3.0, 4.0)));
        shape3 = screen.addShape(3, Shape.ShapeType.RECTANGLE, new Point(2, 2),
                new ArrayList<Double>(Arrays.asList(3.0, 4.0)));
        shape4 = screen.addShape(4, Shape.ShapeType.SQUARE, new Point(2, 1), 
                new ArrayList<Double>(Arrays.asList(4.0)));
        result = screen.deleteShape(Shape.ShapeType.RECTANGLE, 3);
        assertEquals(3, result);
    }


    @Test(expected = AssertionError.class)
    public void testDeleteShapeInvalidId(){
        shape1 = screen.addShape(1, Shape.ShapeType.RECTANGLE, new Point(2, 1),
                new ArrayList<Double>(Arrays.asList(3.0, 4.0)));
        shape2 = screen.addShape(2, Shape.ShapeType.RECTANGLE, new Point(3, 2),
                new ArrayList<Double>(Arrays.asList(3.0, 4.0)));
        shape3 = screen.addShape(3, Shape.ShapeType.RECTANGLE, new Point(2, 2),
                new ArrayList<Double>(Arrays.asList(3.0, 4.0)));
        shape4 = screen.addShape(4, Shape.ShapeType.SQUARE, new Point(2, 1), new ArrayList<Double>(Arrays.asList(4.0)));
        result = screen.deleteShape(Shape.ShapeType.RECTANGLE, 4);
    }

    
    @Test
    public void testSortByArea() {
        Shape.ShapeType type1 = Shape.ShapeType.CIRCLE;
        Point point1 = new Point(1, 1);
        List<Double> parameters1 = new ArrayList<Double>(Arrays.asList(1.0));
        shape1 = screen.addShape(1, type1, point1, parameters1);
        Shape.ShapeType type2 = Shape.ShapeType.CIRCLE;
        Point point2 = new Point(1, 1);
        List<Double> parameters2 = new ArrayList<Double>(Arrays.asList(2.0));
        shape2 = screen.addShape(2, type2, point2, parameters2);
        List<Shape> expectedresult = new ArrayList<Shape>(Arrays.asList(shape1, shape2));
        List<Shape> actualresult = new ArrayList<Shape>();
        actualresult = screen.sortByArea();
        assertEquals(expectedresult, actualresult);
    }

     
    @Test
    public void testSortByDistance() {

        Shape.ShapeType type1 = Shape.ShapeType.CIRCLE;
        Point point1 = new Point(1, 1);
        List<Double> parameters1 = new ArrayList<Double>(Arrays.asList(1.0));
        shape1 = screen.addShape(1, type1, point1, parameters1);

        Shape.ShapeType type2 = Shape.ShapeType.CIRCLE;
        Point point2 = new Point(2, 2);
        List<Double> parameters2 = new ArrayList<Double>(Arrays.asList(2.0));
        Shape shape2 = screen.addShape(2, type2, point2, parameters2);

        List<Shape> expectedresult = new ArrayList<Shape>(Arrays.asList(shape1, shape2));
        List<Shape> actualresult = new ArrayList<Shape>();
        actualresult = screen.sortByDistance();
        assertEquals(expectedresult, actualresult);
    }

    
    @Test
    public void testSortByPerimeter(){

        Shape.ShapeType type1 = Shape.ShapeType.CIRCLE;
        Point point1 = new Point(1, 1);
        List<Double> parameters1 = new ArrayList<Double>(Arrays.asList(1.0));
        Shape shape1 = screen.addShape(1, type1, point1, parameters1);

        Shape.ShapeType type2 = Shape.ShapeType.CIRCLE;
        Point point2 = new Point(1, 1);
        List<Double> parameters2 = new ArrayList<Double>(Arrays.asList(2.0));
        Shape shape2 = screen.addShape(2, type2, point2, parameters2);

        List<Shape> expectedresult = new ArrayList<Shape>(Arrays.asList(shape1, shape2));
        List<Shape> actualresult = new ArrayList<Shape>();
        actualresult = screen.sortByPerimeter();
        assertEquals(expectedresult, actualresult);
    }

   
    @Test
    public void testSortByTimestamp(){

        Shape.ShapeType type1 = Shape.ShapeType.CIRCLE;
        Point point1 = new Point(1, 1);
        List<Double> parameters1 = new ArrayList<Double>(Arrays.asList(1.0));
        shape1 = screen.addShape(1, type1, point1, parameters1);

        Shape.ShapeType type2 = Shape.ShapeType.CIRCLE;
        Point point2 = new Point(1, 1);
        List<Double> parameters2 = new ArrayList<Double>(Arrays.asList(2.0));
        shape2 = screen.addShape(2, type2, point2, parameters2);

        List<Shape> expectedresult = new ArrayList<Shape>(Arrays.asList(shape1, shape2));
        List<Shape> actualresult = new ArrayList<Shape>();
        actualresult = screen.sortByTime();
        assertEquals(expectedresult, actualresult);
    }

    //  to find the list of shape that have a point enclosed in that shape
    @Test
    public void testShapesEnclosingPoint() {

    shape1 = screen.addShape(1,Shape.ShapeType.RECTANGLE, new Point(50, 50),
            new ArrayList<Double>(Arrays.asList(6.0, 4.0)));
    System.out.println(shape1.getId());
    shape2 = screen.addShape(2,Shape.ShapeType.RECTANGLE, new Point(5, 5),
            new ArrayList<Double>(Arrays.asList(10.0, 14.0)));
    System.out.println(shape2.getId());
    shape3 = screen.addShape(3,Shape.ShapeType.RECTANGLE, new Point(2, 2),
            new ArrayList<Double>(Arrays.asList(3.0, 4.0)));
    System.out.println(shape3.getId());
    shape4 = screen.addShape(4,Shape.ShapeType.SQUARE, new Point(10, 10),
            new ArrayList<Double>(Arrays.asList(4.0)));
    List<Shape> actualResult = new ArrayList<Shape>();
    actualResult = screen.getShapesEnclosingPoint(new Point(3.0, 4.0));
    List<Shape> expectedResult = new ArrayList<Shape>(Arrays.asList(shape3, shape4));
    assertEquals(expectedResult, actualResult);
    }

} 