package oops.advance;

public class RoomCarpet {
    private RoomDimension roomDimension;
    private double costOfCarpet;

    public RoomCarpet(RoomCarpet carpet) {
        this.costOfCarpet = carpet.costOfCarpet;
    }

    public RoomCarpet(double costOfCarpet) {
        this.costOfCarpet = costOfCarpet;
    }

    public RoomCarpet(RoomDimension roomDimension, double costOfCarpet) {
        this(costOfCarpet);
        this.roomDimension = new RoomDimension(roomDimension);
    }

    public double totalCost() {
        return roomDimension.getArea() * this.costOfCarpet;
    }

    @Override
    public String toString() {
        return "RoomCarpet{" +
                "roomDimension=" + roomDimension +
                ", costOfCarpet=" + costOfCarpet +
                '}';
    }
}
