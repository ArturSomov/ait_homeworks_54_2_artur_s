package homework_32;

public class Apartment implements Property {

    private String address;
    private int floor;
    private double area;
    private boolean hasElevator;

    public Apartment(String address, int floor, double area, boolean hasElevator) {
        this.address = address;
        this.floor = floor;
        this.area = area;
        this.hasElevator = hasElevator;
    }

    @Override
    public double calculatePrice() {
        double basePrice = area * 1000;
        if (hasElevator) {
            basePrice *= 1.05;
        }
        return basePrice;
    }

    @Override
    public void printDetails() {
        System.out.println("Apartment at " + address + ", Floor: " + floor + ", Area: " + area + " m2, Elevator: " + (hasElevator ? "Yes" : "No") + ", Price: " + calculatePrice() + " Euro");
    }

    public String getAddress() {
        return address;
    }

    public int getFloor() {
        return floor;
    }

    public double getArea() {
        return area;
    }

    public boolean isHasElevator() {
        return hasElevator;
    }
}
