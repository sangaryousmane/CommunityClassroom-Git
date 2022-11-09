package oops;

public class Rectangle {
    private double width;
    private double height;

    public Rectangle(double width, double height){
        this.width=width;
        this.height=height;
    }

    public double area(){
        return this.height * this.width;
    }
    public void setWidth(double width){
        this.width=width;
    }

    public void setHeight(double height){
        this.height=height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }
}
