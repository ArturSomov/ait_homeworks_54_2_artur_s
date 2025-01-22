import homework_32.CommercialProperty;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CommercialPropertyTest {

    @Test
    void testCalculatePriceForOffice() {
        CommercialProperty office = new CommercialProperty("Königsallee 23, Düsseldorf", 200.0, "office");
        assertEquals(300000.0, office.calculatePrice(), 0.01);
    }

    @Test
    void testCalculatePriceForWarehouse() {
        CommercialProperty warehouse = new CommercialProperty("Industriestr. 50, Köln", 500.0, "warehouse");
        assertEquals(400000.0, warehouse.calculatePrice(), 0.01);
    }

    @Test
    void testCalculatePriceForRetail() {
        CommercialProperty retail = new CommercialProperty("Friedrichstr. 100, Berlin", 300.0, "retail");
        assertEquals(300000.0, retail.calculatePrice(), 0.01);
    }

    @Test
    void testCalculatePriceForUnknownBusinessType() {
        CommercialProperty unknown = new CommercialProperty("Unknown St. 1, Berlin", 150.0, "unknown");
        assertEquals(150000.0, unknown.calculatePrice(), 0.01); // Default price per m²: 1000
    }

    @Test
    void testGetters() {
        CommercialProperty property = new CommercialProperty("Königsallee 23, Düsseldorf", 200.0, "office");

        assertEquals("Königsallee 23, Düsseldorf", property.getAddress());
        assertEquals(200.0, property.getArea(), 0.01);
    }
}