package homework_33;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GiftManager {


    private final List<Gift> gifts;

    public GiftManager() {
        this.gifts = new ArrayList<>();
        log.info("GiftManager initialized.");
    }

    public void addGift(Gift gift) {
        gifts.add(gift);
        log.info("Gift added: {}", gift);
    }

    public void printAllGifts() {
        if (gifts.isEmpty()) {
            log.warn("The list of gifts is empty.");
            System.out.println("List of gifts is empty.");
        } else {
            log.info("Printing all gifts.");
            System.out.println("List of gifts:");
            for (Gift gift : gifts) {
                System.out.println(gift);
            }
        }
    }

    public List<Gift> filterByCategory(GiftCategory category) {
        log.info("Filtering gifts by category: {}", category);
        List<Gift> filteredGifts = new ArrayList<>();
        for (Gift gift : gifts) {
            if (gift.getCategory() == category) {
                filteredGifts.add(gift);
            }
        }
        log.debug("Filtered gifts: {}", filteredGifts);
        return filteredGifts;
    }

    public boolean updateGiftStatus(String giftName, GiftStatus newStatus) {
        log.info("Updating status of gift '{}' to {}", giftName, newStatus);
        for (Gift gift : gifts) {
            if (gift.getName().equalsIgnoreCase(giftName)) {
                gift.setStatus(newStatus);
                log.info("Gift status updated: {}", gift);
                return true;
            }
        }
        log.error("Gift with name '{}' not found.", giftName);
        return false;
    }
}
