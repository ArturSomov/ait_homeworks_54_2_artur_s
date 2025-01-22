package homework_32;

public class Main {
    public static void main(String[] args) {

        Apartment apartment1 = new Apartment("Münchener Str. 10, Berlin", 5, 75.0, true);
        Apartment apartment2 = new Apartment("Goetheallee 15, Hamburg", 3, 60.0, false);

        House house1 = new House("Dresdener Str. 20, Dresden", 120.0, 300.0, true);
        House house2 = new House("Schillerstr. 5, Stuttgart", 150.0, 200.0, false);

        CommercialProperty office = new CommercialProperty("Königsallee 23, Düsseldorf", 200.0, "office");
        CommercialProperty warehouse = new CommercialProperty("Industriestr. 50, Köln", 500.0, "warehouse");
        CommercialProperty retail = new CommercialProperty("Friedrichstr. 100, Berlin", 300.0, "retail");


        RealEstateAgency agency = new RealEstateAgency();


        agency.addProperty(apartment1);
        agency.addProperty(apartment2);
        agency.addProperty(house1);
        agency.addProperty(house2);
        agency.addProperty(office);
        agency.addProperty(warehouse);
        agency.addProperty(retail);


        System.out.println("=== Details of All Properties ===");
        agency.printAllDetails();


        System.out.println("\n=== Total Price of All Properties ===");
        agency.calculateTotalPrice();
    }
}
