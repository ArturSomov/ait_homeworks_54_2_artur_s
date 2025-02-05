package homework_36;

///Упражнение 2

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TimeUntilSurgery {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

        System.out.println("Date and time of operation (dd.MM.yyyy HH:mm): ");
        LocalDateTime surgeryTime = LocalDateTime.parse(scanner.nextLine(), formatter);
        LocalDateTime now = LocalDateTime.now();

        Duration duration = Duration.between(now, surgeryTime);
        long days = duration.toDays();
        long hours = duration.toHours() % 24;
        long minutes = duration.toMinutes() % 60;

        System.out.println("Time till operation remains: " + days + " days," + hours + " hours," + minutes + " minutes");
    }
}
