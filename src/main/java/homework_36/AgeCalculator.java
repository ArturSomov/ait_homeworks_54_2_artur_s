package homework_36;

///Упражнение 4

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class AgeCalculator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        System.out.println("Enter your date of birth (dd.MM.yyyy): ");
        LocalDate birthDate = LocalDate.parse(scanner.nextLine(), formatter);
        LocalDate today = LocalDate.now();

        Period age = Period.between(birthDate, today);

        System.out.println("Patient's age: " + age.getYears() + " years, " + age.getMonths() + " months, " + age.getDays() + " days.");
    }
}
