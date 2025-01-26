package homework_33;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GiftManagerTest {

    private GiftManager giftManager;

    @BeforeEach
    void setUp() {
        giftManager = new GiftManager();
    }

    @Test
    public void addGift_ShouldAddGiftToList() {
        Gift gift = new Gift("Laptop", GiftCategory.ELECTRONICS, GiftStatus.AVAILABLE);
        giftManager.addGift(gift);

        List<Gift> gifts = giftManager.filterByCategory(GiftCategory.ELECTRONICS);
        assertEquals(1, gifts.size());
        assertEquals("Laptop", gifts.get(0).getName());
        assertEquals(GiftCategory.ELECTRONICS, gifts.get(0).getCategory());
        assertEquals(GiftStatus.AVAILABLE, gifts.get(0).getStatus());
    }

    @Test
    public void filterByCategory_ShouldReturnCorrectGifts() {
        giftManager.addGift(new Gift("Laptop", GiftCategory.ELECTRONICS, GiftStatus.AVAILABLE));
        giftManager.addGift(new Gift("Doll", GiftCategory.TOYS, GiftStatus.RESERVED));

        List<Gift> electronics = giftManager.filterByCategory(GiftCategory.ELECTRONICS);
        assertEquals(1, electronics.size());
        assertEquals("Laptop", electronics.get(0).getName());

        List<Gift> toys = giftManager.filterByCategory(GiftCategory.TOYS);
        assertEquals(1, toys.size());
        assertEquals("Doll", toys.get(0).getName());
    }

    @Test
    public void filterByCategory_ShouldReturnEmptyListIfNoMatch() {
        giftManager.addGift(new Gift("Laptop", GiftCategory.ELECTRONICS, GiftStatus.AVAILABLE));

        List<Gift> books = giftManager.filterByCategory(GiftCategory.BOOKS);
        assertTrue(books.isEmpty());
    }

    @Test
    public void updateGiftStatus_ShouldUpdateStatusWhenGiftExists() {
        Gift gift = new Gift("Laptop", GiftCategory.ELECTRONICS, GiftStatus.AVAILABLE);
        giftManager.addGift(gift);

        boolean updated = giftManager.updateGiftStatus("Laptop", GiftStatus.DELIVERED);
        assertTrue(updated);
        assertEquals(GiftStatus.DELIVERED, gift.getStatus());
    }

    @Test
    public void updateGiftStatus_ShouldReturnFalseIfGiftNotFound() {
        boolean updated = giftManager.updateGiftStatus("NonExistentGift", GiftStatus.DELIVERED);
        assertFalse(updated);
    }
}
