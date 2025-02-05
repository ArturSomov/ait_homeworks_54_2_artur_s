package homework_36;

///Упражнение 5

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MedicineExpiration {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        System.out.println("Enter the date of production (dd.MM.yyyy): ");
        LocalDate manufactureDate = LocalDate.parse(scanner.nextLine(), formatter);

        System.out.println("Enter the storage period (in months): ");
        int shelfLifeMonths = scanner.nextInt();

        LocalDate expirationDate = manufactureDate.plusMonths(shelfLifeMonths);
        LocalDate today = LocalDate.now();

        System.out.println("Date of manufacture: " + manufactureDate.format(formatter));
        System.out.println("Shelf-life: " + shelfLifeMonths + " months");
        System.out.println("The medication is good until: " + expirationDate.format(formatter));


        if (expirationDate.isBefore(today)) {
            System.out.println("Status: Outdated!");
        } else {
            System.out.println("Статус: Eligible!");
        }
    }
}
