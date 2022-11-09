package shapes;

public abstract class Shape {

    protected double length;
    protected double width;

    public Shape(double length, double width){
        this.length=length;
        this.width=width;
    }

    public abstract double getAreaOfRectangle(double length, double width);
    public abstract double getPerimeterOfRectangle(double length, double width);
    public abstract double getAreaOfCircle(double radius);
    public abstract double getPerimeterOfCircle(double radius);
    public abstract double getAreaOfTriangle(double base, double height);
    public abstract double getAreaOfRhombus(double length, double width);
    public abstract double getPerimeterOfRhombus(double length, double width);
    public abstract double getAreaOfParallelogram(double length, double width);
    public abstract double getPerimeterOfParallelogram(double length, double width);
}
