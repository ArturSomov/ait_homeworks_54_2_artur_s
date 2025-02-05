package homework_36;

///Упражнение 1

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class NextAppointment {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");

        System.out.println("Type the date of your last visit (dd.MM.yyyy): ");
        LocalDate lastVisit = LocalDate.parse(scanner.nextLine(), inputFormatter);

        LocalDate nextVisit = lastVisit.plusMonths(6);

        if (nextVisit.getDayOfWeek() == DayOfWeek.SATURDAY) {
            nextVisit = nextVisit.plusDays(2);
        } else if (nextVisit.getDayOfWeek() == DayOfWeek.SUNDAY) {
            nextVisit = nextVisit.plusDays(1);
        }

        System.out.println("Your next visit: " + nextVisit.format(outputFormatter) + " (перенесено с выходного)");
    }
}
