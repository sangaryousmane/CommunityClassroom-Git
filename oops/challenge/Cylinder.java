package oops.challenge;

public class Cylinder extends Circle {

    private double height;

    public Cylinder(double radius, double height) {
        super(radius);
        this.height = height;

        if (height < 0) {
            this.height = 0.0;
        }
    }

    public double getHeight() {
        return height;
    }

    // Volume of cylinder = area * height.
    public double getVolume() {
        return getArea() * this.height;
    }
}
