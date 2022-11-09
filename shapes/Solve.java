package shapes;

public class Solve extends Shape{


    public Solve(double length, double width) {
        super(length, width);
    }

    @Override
    public double getAreaOfRectangle(double length, double width) {
        return length * width;
    }

    @Override
    public double getPerimeterOfRectangle(double length, double width) {
        return  (2*length) + (2*width);
    }

    @Override
    public double getAreaOfCircle(double radius) {
        return Math.PI * (radius*radius);
    }

    @Override
    public double getPerimeterOfCircle(double radius) {
        return 2 * (Math.PI * radius);
    }

    @Override
    public double getAreaOfTriangle(double base, double height) {
        return 1/2.0 * (base*height);
    }

    @Override
    public double getAreaOfRhombus(double length, double width) {
        return length+width/2.0;
    }

    @Override
    public double getPerimeterOfRhombus(double length, double width) {
        return length+width;
    }

    // Area of Rectangle
    @Override
    public double getAreaOfParallelogram(double base, double height) {
        return base*height;
    }

    @Override
    public double getPerimeterOfParallelogram(double base, double height) {
        return 2 * (base+height)/Math.cos(base);
    }
}
