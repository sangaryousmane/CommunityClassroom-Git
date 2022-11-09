package chapter7arrays;

public class Area {

    private double radius;

    public double areaOfCircle() {
        return Math.PI * (radius * radius);
    }

    public double areaOfRectangle(int length, int width) {
        return length * width;
    }

    public double areaOfCylinder(int height) {
        return areaOfCircle() * height;
    }


}
