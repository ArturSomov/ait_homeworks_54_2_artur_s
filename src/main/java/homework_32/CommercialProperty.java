package homework_32;

import java.util.HashMap;
import java.util.Map;

public class CommercialProperty implements Property {

    private String address;
    private double area;
    private String businessType;

    private String officeType = "office";

    private String warehouseType = "warehouse";

    public CommercialProperty(String address, double area, String businessType) {
        this.address = address;
        this.area = area;
        this.businessType = businessType;
    }

    @Override
    public double calculatePrice() {
        Map<String, Double> priceProperty = new HashMap<>();
        priceProperty.put(officeType, Double.valueOf(1500.0));
        priceProperty.put(warehouseType, Double.valueOf(800.0));

        double pricePerSquareMeter = priceProperty.getOrDefault(businessType, Double.valueOf(1000.0));

        return area * pricePerSquareMeter;

        /*
        double totalPrice = 0;
        switch (businessType) {
            case "office" -> {
                totalPrice = area * 1500;
            }
            case "warehouse" -> {
                totalPrice = area * 800;
            }
            default -> {
                totalPrice = area * 1000;
            }
        }
        return totalPrice;
         */

    }

    @Override
    public void printDetails() {
        switch (businessType) {
            case "office" -> {
                System.out.println("= Office = ");
            }
            case "warehouse" -> {
                System.out.println("= Warehouse = ");
            }
            default -> {
                System.out.println("= Other properties = ");
            }
        }
        System.out.println("Address: " + address);
        System.out.println("Area: " + area + " square meters");
    }

    public String getAddress() {
        return address;
    }

    public double getArea() {
        return area;
    }

    public String getBusinessType() {
        return businessType;
    }

    public String getOfficeType() {
        return officeType;
    }

    public String getWarehouseType() {
        return warehouseType;
    }
}
