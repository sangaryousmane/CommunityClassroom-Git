package oops.advance;

public class RoomDimension {
    private double length;
    private double width;

    public RoomDimension(double length, double width) {
        this.length = length;
        this.width = width;
    }
    public RoomDimension(RoomDimension roomDimension){
        this.width=roomDimension.width;
        this.length=roomDimension.length;
    }

    public double getArea(){
        return length * width;
    }

    @Override
    public String toString() {
        return "RoomDimension{" +
                "length=" + length +
                ", width=" + width +
                '}';
    }
}

