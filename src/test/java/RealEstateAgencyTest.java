import homework_32.Apartment;
import homework_32.House;
import homework_32.Property;
import homework_32.RealEstateAgency;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class RealEstateAgencyTest {

    @Test
    void testAddProperty() {
        RealEstateAgency agency = new RealEstateAgency();
        Apartment apartment = new Apartment("Münchener Str. 10, Berlin", 5, 75.0, true);

        agency.addProperty(apartment);

        List<Property> properties = agency.getProperties();
        assertEquals(1, properties.size());
        assertEquals(apartment, properties.get(0));
    }

    @Test
    void testGetProperties() {
        RealEstateAgency agency = new RealEstateAgency();
        Apartment apartment1 = new Apartment("Münchener Str. 10, Berlin", 5, 75.0, true);
        House house = new House("Dresdener Str. 20, Dresden", 120.0, 300.0, true);

        agency.addProperty(apartment1);
        agency.addProperty(house);

        List<Property> properties = agency.getProperties();
        assertEquals(2, properties.size());
        assertTrue(properties.contains(apartment1));
        assertTrue(properties.contains(house));
    }

    @Test
    void testCalculateTotalPrice() {
        RealEstateAgency agency = new RealEstateAgency();
        Apartment apartment = new Apartment("Münchener Str. 10, Berlin", 5, 75.0, true); // 78750.0
        House house = new House("Dresdener Str. 20, Dresden", 120.0, 300.0, true); // 161000.0

        agency.addProperty(apartment);
        agency.addProperty(house);

        double totalPrice = agency.getProperties().stream().mapToDouble(Property::calculatePrice).sum();
        assertEquals(239750.0, totalPrice, 0.01);
    }

    @Test
    void testEmptyAgency() {
        RealEstateAgency agency = new RealEstateAgency();

        List<Property> properties = agency.getProperties();
        assertTrue(properties.isEmpty());
    }
}
