package homework_33;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Scanner;

@Slf4j
public class GiftApp {

    private static final GiftManager giftManager = new GiftManager();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        log.info("GiftApp started.");
        System.out.println("Welcome to the gift management system!");

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1 - Add gift");
            System.out.println("2 - Show all gifts");
            System.out.println("3 - Filter all gifts by category");
            System.out.println("4 - Update gift status");
            System.out.println("5 - Exit");
            System.out.println("Your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();
            log.info("User selected option: {}", choice);

            switch (choice) {
                case 1:
                    addGift();
                    break;
                case 2:
                    showAllGifts();
                    break;
                case 3:
                    filterGiftsByCategory();
                    break;
                case 4:
                    updateGiftStatus();
                    break;
                case 5:
                    log.info("User exited the application.");
                    System.out.println("Exiting app. Thanks for using our gift management system5!");
                    return;
                default:
                    log.warn("Invalid menu option selected: {}", choice);
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addGift() {
        System.out.println("Type the name of the gift: ");
        String name = scanner.nextLine();

        System.out.print("Select category (ELECTRONICS, TOYS, BOOKS, CLOTHING, HOME_APPLIANCES): ");
        GiftCategory category = GiftCategory.valueOf(scanner.nextLine().toUpperCase());

        System.out.print("Choose status (AVAILABLE, OUT_OF_STOCK, RESERVED, DELIVERED): ");
        GiftStatus status = GiftStatus.valueOf(scanner.nextLine().toUpperCase());

        Gift gift = new Gift(name, category, status);
        giftManager.addGift(gift);
        log.info("Gift added successfully: {}", gift);
    }

    private static void showAllGifts() {
        log.info("User requested to view all gifts.");
        giftManager.printAllGifts();
    }

    private static void filterGiftsByCategory() {
        System.out.print("Choose category to filter (ELECTRONICS, TOYS, BOOKS, CLOTHING, HOME_APPLIANCES): ");
        GiftCategory category = GiftCategory.valueOf(scanner.nextLine().toUpperCase());

        log.info("User selected category for filtering: {}", category);
        List<Gift> filteredGifts = giftManager.filterByCategory(category);
        if (filteredGifts.isEmpty()) {
            System.out.println("There is no gifts in chosen category.");
        } else {
            System.out.println("Results of filter:");
            for (Gift gift : filteredGifts) {
                System.out.println(gift);
            }
        }
    }

    private static void updateGiftStatus() {
        System.out.print("Type the name of gift to update its status: ");
        String giftName = scanner.nextLine();

        System.out.print("Choose new status (AVAILABLE, OUT_OF_STOCK, RESERVED, DELIVERED): ");
        GiftStatus newStatus = GiftStatus.valueOf(scanner.nextLine().toUpperCase());

        boolean success = giftManager.updateGiftStatus(giftName, newStatus);
        if (!success) {
            log.error("Gift not found: {}", giftName);
            System.err.println("Error: Gift with such name is not found.");
        }
    }
}
