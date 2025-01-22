import homework_32.Apartment;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ApartmentTest {

    @Test
    void testCalculatePriceWithElevator() {
        Apartment apartment = new Apartment("Münchener Str. 10, Berlin", 5, 75.0, true);
        assertEquals(78750.0, apartment.calculatePrice(), 0.01);
    }

    @Test
    void testCalculatePriceWithoutElevator() {
        Apartment apartment = new Apartment("Goetheallee 15, Hamburg", 3, 60.0, false);
        assertEquals(60000.0, apartment.calculatePrice(), 0.01);
    }

    @Test
    void testGetters() {
        Apartment apartment = new Apartment("Goetheallee 15, Hamburg", 3, 60.0, false);

        assertEquals("Goetheallee 15, Hamburg", apartment.getAddress());
        assertEquals(3, apartment.getFloor());
        assertEquals(60.0, apartment.getArea(), 0.01);
        assertFalse(apartment.isHasElevator());
    }
}
