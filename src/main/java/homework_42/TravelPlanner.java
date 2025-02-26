package homework_42;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Scanner;

@Slf4j
public class TravelPlanner {

    public static void main(String[] args) {

        // Задание 1: Чтение маршрута путешествия
        Path travelRoutePath = Paths.get("src/main/resources/travel_route.txt");

        try {
            List<String> routeLines = Files.readAllLines(travelRoutePath);
            log.info("Successfully read travel route from file.");
            System.out.println("Travel Route:");
            for (int i = 0; i < routeLines.size(); i++) {
                System.out.println((i + 1) + ". " + routeLines.get(i));
            }
        } catch (IOException e) {
            log.error("Error reading travel route: {}", e.getMessage());
        }

        // Задание 2: Запись отзыва о путешествии
        Path reviewPath = Paths.get("src/main/resources/travel_review.txt");
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nWrite your travel review:");
        String review = scanner.nextLine();

        try {
            Files.writeString(reviewPath, review + System.lineSeparator(),
                    StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            log.info("Review successfully saved to file.");
            System.out.println("Your review has been saved!");
        } catch (IOException e) {
            log.error("Error saving review: {}", e.getMessage());
        }

        scanner.close();
    }
}
