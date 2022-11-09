package oops;

public class Cellphone {
    private String manufacturer;
    private String model;
    private double retailPrice;

    public Cellphone(String manufacturer, String model, double retailPrice) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.retailPrice = retailPrice;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(double retailPrice) {
        this.retailPrice = retailPrice;
    }

    @Override
    public String toString() {
        return "Cellphone{" +
                "manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", retailPrice=" + retailPrice +
                '}';
    }
}
