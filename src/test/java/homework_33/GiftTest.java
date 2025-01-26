package homework_33;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GiftTest {

    @Test
    void constructor_ShouldInitializeFieldsCorrectly() {

        Gift gift = new Gift("Laptop", GiftCategory.ELECTRONICS, GiftStatus.AVAILABLE);

        assertEquals("Laptop", gift.getName());
        assertEquals(GiftCategory.ELECTRONICS, gift.getCategory());
        assertEquals(GiftStatus.AVAILABLE, gift.getStatus());
    }

    @Test
    void setStatus_ShouldUpdateStatus() {

        Gift gift = new Gift("Laptop", GiftCategory.ELECTRONICS, GiftStatus.AVAILABLE);

        gift.setStatus(GiftStatus.DELIVERED);

        assertEquals(GiftStatus.DELIVERED, gift.getStatus());
    }

    @Test
    void toString_ShouldReturnCorrectFormat() {

        Gift gift = new Gift("Laptop", GiftCategory.ELECTRONICS, GiftStatus.AVAILABLE);

        String result = gift.toString();

        String expected = "Gift: Laptop, Category: ELECTRONICS, Status: AVAILABLE,";
        assertEquals(expected, result);
    }
}
