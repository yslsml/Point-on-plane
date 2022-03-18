package point.entity;

import point.exception.BadPointException;
import point.valid.ValidTime;

import java.util.Objects;

public class Point {

    private double x0;  //initial state (t=0)
    private double y0;  //initial state (t=0)
    private double x;   //curr state
    private double y;   //curr state
    private double time;   //time in curr state

    {
        x0 = 0;
        y0 = 0;
        x = 1;
        y = 1;
        time = 0.1;
    }

    public Point() {}

    public void increment() throws BadPointException {
        double newX = getX() + 1;
        this.setX(newX);
        double newY = getY() + 1;
        this.setY(newY);
        double newTime = getTime() + 1;
        this.setTime(newTime);
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point(double x0, double y0, double x, double y) {
        this(x,y);
        this.x0 = x0;
        this.y0 = y0;
    }

    public Point(double x, double y, double time) throws BadPointException {
        this(x,y);
        setTime(time);
    }

    public Point(double x0, double y0, double x, double y, double time) throws BadPointException{
        this(x,y, time);
        this.x0 = x0;
        this.y0 = y0;
    }

    //setters
    public void setX0(double x0) {
        this.x0 = x0;
    }

    public void setY0(double y0) {
        this.y0 = y0;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setTime(double time) throws BadPointException {
        if (ValidTime.isValidTime(time)) {
            this.time = time;
        }
        else throw new BadPointException("Bad time exception!");
    }

    //getters
    public double getX0() {
        return x0;
    }

    public double getY0() {
        return y0;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getTime() {
        return time;
    }

    private double getDistance() {
        return Math.sqrt(Math.pow((x - x0), 2) + Math.pow((y - y0), 2));
    }

    public double getSpeed() {
        double s = getDistance();
        return s/time;
    }

    public double getAcceleration() {
        double speed = getSpeed();
        return speed/time;
    }

    @Override
    public String toString() {
        return "\nPoint { " +
                "\ninitial coordinates: " +
                "\nx0 = " + x0 +
                "\ny0 = " + y0 +
                "\ncurrent coordinates and time: " +
                "\nx = " + x +
                "\ny = " + y +
                "\ntime = " + time +
                "\ncalculated characteristics of point: " +
                "\nspeed = " + String.format("%.2f", getSpeed()) +
                "\nacceleration = " + String.format("%.2f", getAcceleration())+
                "\n}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Double.compare(point.getX0(), getX0()) == 0
                && Double.compare(point.getY0(), getY0()) == 0
                && Double.compare(point.getX(), getX()) == 0
                && Double.compare(point.getY(), getY()) == 0
                && Double.compare(point.getTime(), getTime()) == 0;
    }

    @Override
    protected Point clone() throws CloneNotSupportedException {
        return (Point)super.clone();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX0(), getY0(), getX(), getY(), getTime());
    }
}
