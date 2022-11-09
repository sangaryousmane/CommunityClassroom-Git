package oops.challenge;

public class Point {
    private int x;
    private int y;

    public Point(){}

    public Point(int x, int y){
        this.x=x;
        this.y=y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double distance(int x2, int y2){
       return Math.sqrt((x2-x) *(x2-x) + (y2-y)*(y2-y));
    }

    public double distance(Point p1, Point p2){
        return Math.sqrt((p2.x - p1.x) * (p2.x- p1.x) + (p2.y-p1.y) * (p2.y-p2.x));
    }
}
