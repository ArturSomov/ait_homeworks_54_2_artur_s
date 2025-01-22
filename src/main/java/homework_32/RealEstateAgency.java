package homework_32;

import java.util.ArrayList;
import java.util.List;

public class RealEstateAgency {

    private List<Property> properties;

    public RealEstateAgency() {
        this.properties = new ArrayList<>();
    }

    public void addProperty(Property property) {
        properties.add(property);
    }

    public void printAllDetails() {
        for (Property property : properties) {
            property.printDetails();
        }
    }

    public void calculateTotalPrice() {
        double totalPrice = 0;
        for (Property property : properties) {
            totalPrice += property.calculatePrice();
        }
        System.out.println("Total price of all properties: " + totalPrice + " Eur");
    }

    public List<Property> getProperties() {
        return properties;
    }
}
