package pointtest.entity;

import org.testng.Assert;
import org.testng.annotations.Test;
import point.entity.Point;
import point.exception.BadPointException;

public class PointTest {

    @Test (description = "positive test for calculating speed of a point", enabled = true)
    public void testGetSpeedPositive() throws BadPointException {
        Point p1 = new Point(1,2,4,3,3);

        double actual = p1.getSpeed();
        double expected = 1.054;
        double delta = 0.3;
        Assert.assertEquals(actual, expected, delta);
    }

    @Test (description = "negative test for calculating speed of a point", enabled = true)
    public void testGetSpeedNegative() throws BadPointException {
        Point p1 = new Point(1,2,5,2,4);

        double actual = p1.getSpeed();
        double expected = 3.54;
        double delta = 0.3;
        Assert.assertNotEquals(actual, expected, delta);
    }

    @Test (description = "positive test for calculating acceleration of a point", enabled = true)
    public void testGetAccelerationPositive() throws BadPointException {
        Point p1 = new Point(1,2,4,3,3);

        double actual = p1.getAcceleration();
        double expected = 0.351;
        double delta = 0.3;
        Assert.assertEquals(actual, expected, delta);
    }

    @Test (description = "negative test for calculating acceleration of a point", enabled = true)
    public void testGetAccelerationNegative() throws BadPointException {
        Point p1 = new Point(2,2,4,7,2);

        double actual = p1.getAcceleration();
        double expected = 5.7;
        double delta = 0.3;
        Assert.assertNotEquals(actual, expected, delta);
    }

}
