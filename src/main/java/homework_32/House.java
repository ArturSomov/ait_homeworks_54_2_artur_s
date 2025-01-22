package homework_32;

public class House implements Property {

    private String address;
    private double area;
    private double landArea;
    private boolean hasGarage;

    public House (String address, double area, double landArea, boolean hasGarage) {
        this.address = address;
        this.area = area;
        this.landArea = landArea;
        this.hasGarage = hasGarage;
    }

    @Override
    public double calculatePrice() {

        double basePrice = area * 800 + landArea * 200;
        if (hasGarage) {
            basePrice += 5000;
        }
        return basePrice;
    }

    @Override
    public void printDetails() {
        System.out.println("House at " + address + ", Area: " + area + "m², Land Area: " +
                landArea + " m², Garage: " + (hasGarage ? "Yes" : "No") +
                ", Price: " + calculatePrice() + " EUR");
    }

    public String getAddress() {
        return address;
    }

    public double getArea() {
        return area;
    }

    public double getLandArea() {
        return landArea;
    }

    public boolean isHasGarage() {
        return hasGarage;
    }
}
