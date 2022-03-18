package pointtest.handler;

import org.testng.Assert;
import org.testng.annotations.Test;
import point.entity.Point;
import point.exception.BadPointException;
import point.handler.PointHandler;
import point.run.Main;

import static org.testng.Assert.*;

public class PointHandlerTest {

    @Test (description = "positive test for calculating distance between two points", enabled = true)
    public void testGetDistanceBetweenPointsPositive() throws BadPointException {
        Point p1 = new Point(5, 2, 3);
        Point p2 = new Point(3, 6, 2);
        double time = 4;

        double actual = PointHandler.getDistanceBetweenPoints(p1, p2, time);
        double expected = 19.35375;
        double delta = 0.3;
        Assert.assertEquals(actual, expected, delta);
    }

    @Test (description = "negative test for calculating distance between two points", enabled = true)
    public void testGetDistanceBetweenPointsNegative() throws BadPointException {
        Point p1 = new Point(5, 2, 3);
        Point p2 = new Point(3, 5, 2);
        double time = 6;

        double actual = PointHandler.getDistanceBetweenPoints(p1, p2, time);
        double expected = 15.34;
        double delta = 0.3;
        Assert.assertNotEquals(actual, expected, delta);
    }

    @Test (description = "positive test whether two points can intersect", enabled = true)
    public void testCanIntersectPositive() throws BadPointException {
        Point p1 = new Point(3,0,-2, 5, 3);
        Point p2 = new Point(0, 0, 5, 6, 5);

        boolean actual = PointHandler.canIntersect(p1, p2);
        boolean expected = true;
        Assert.assertEquals(actual, expected);
    }

    @Test (description = "negative test whether two points can intersect", enabled = true)
    public void testCanIntersectNegative() throws BadPointException {
        // параллельные прямые
        Point p1 = new Point(3,0,4, 1, 2);
        Point p2 = new Point(3, 2, 4, 3, 5);

        boolean actual = PointHandler.canIntersect(p1, p2);
        boolean expected = true;
        Assert.assertNotEquals(actual, expected);
    }

}