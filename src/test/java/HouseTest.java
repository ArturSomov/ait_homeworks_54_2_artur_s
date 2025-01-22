import homework_32.House;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HouseTest {

    @Test
    void testCalculatePriceWithGarage() {
        House house = new House("Dresdener Str. 20, Dresden", 120.0, 300.0, true);
        double expectedPrice = 120.0 * 800 + 300.0 * 200 + 5000; // 96000 + 60000 + 5000 = 161000
        assertEquals(expectedPrice, house.calculatePrice(), 0.01);
    }

    @Test
    void testCalculatePriceWithoutGarage() {
        House house = new House("Schillerstr. 5, Stuttgart", 150.0, 200.0, false);
        double expectedPrice = 150.0 * 800 + 200.0 * 200; // 120000 + 40000 = 160000
        assertEquals(expectedPrice, house.calculatePrice(), 0.01);
    }

    @Test
    void testGetAddress() {
        House house = new House("Goetheallee 10, Hamburg", 100.0, 150.0, true);
        assertEquals("Goetheallee 10, Hamburg", house.getAddress());
    }

    @Test
    void testGetArea() {
        House house = new House("Goetheallee 10, Hamburg", 100.0, 150.0, true);
        assertEquals(100.0, house.getArea(), 0.01);
    }

    @Test
    void testGetLandArea() {
        House house = new House("Goetheallee 10, Hamburg", 100.0, 150.0, true);
        assertEquals(150.0, house.getLandArea(), 0.01);
    }

    @Test
    void testIsHasGarageTrue() {
        House house = new House("Goetheallee 10, Hamburg", 100.0, 150.0, true);
        assertTrue(house.isHasGarage());
    }

    @Test
    void testIsHasGarageFalse() {
        House house = new House("Schillerstr. 5, Stuttgart", 150.0, 200.0, false);
        assertFalse(house.isHasGarage());
    }
}
