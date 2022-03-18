package point.run;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import point.entity.Point;
import point.exception.BadPointException;
import point.handler.PointHandler;


public class Main {
    static Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        try {
            // Point p1 = new Point();
            Point p2 = new Point(3,0,-2, 5, 3);
            logger.log(Level.INFO, p2);
            p2.increment();
            logger.log(Level.INFO, p2);

            Point p3 = new Point(5, 6, 5);
            logger.log(Level.INFO, p3);
            // Point p4 = new Point(3, 2, -2, 7, 3); //parallel to p2
            // logger.log(Level.INFO, p1);

            double t = 4;
            double dist = PointHandler.getDistanceBetweenPoints(p2, p3, t);
            logger.log(Level.INFO,"Distance between points: " + String.format("%.2f", dist));

            boolean res = PointHandler.canIntersect(p2, p3);
            logger.log(Level.INFO, "Tracks of two points can intersect: " + res);

        } catch (BadPointException e) {
            logger.log(Level.ERROR, "Bad Point exception!");
        }

    }
}
