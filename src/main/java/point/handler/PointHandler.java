package point.handler;

import point.entity.Point;

public class PointHandler {

    static public double getDistanceBetweenPoints(Point p1, Point p2, double time) {
        double speedX1 = (p1.getX() - p1.getX0()) / p1.getTime();  // скорость первого по оси X
        double speedY1 = (p1.getY() - p1.getY0()) / p1.getTime();  // скорость первого по оси Y
        double speedX2 = (p2.getX() - p2.getX0()) / p2.getTime();
        double speedY2 = (p2.getY() - p2.getY0()) / p2.getTime();

        double accelX1 = speedX1 / p1.getTime();
        double accelY1 = speedY1 / p1.getTime();
        double accelX2 = speedX2 / p2.getTime();
        double accelY2 = speedY2 / p2.getTime();

        double x1 = p1.getX0() + speedX1 * time + (accelX1 * Math.pow(time, 2)) / 2;
        double y1 = p1.getY0() + speedY1 * time + (accelY1 * Math.pow(time, 2)) / 2;
        double x2 = p2.getX0() + speedX2 * time + (accelX2 * Math.pow(time, 2)) / 2;
        double y2 = p2.getY0() + speedY2 * time + (accelY2 * Math.pow(time, 2)) / 2;

        double res = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        return res;
    }

    static public boolean canIntersect(Point p1, Point p2) {
        double a1 = p1.getX()-p1.getX0();
        double b1 = p1.getY()-p1.getY0();
        double a2 = p2.getX()-p2.getX0();
        double b2 = p2.getY()-p2.getY0();
        return (a1 / a2) != (b1 / b2);
    }
}

