package homework_36;

///Упражнение 3

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TimeZoneConversion {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

        System.out.println("Enter the date and time of the consultation (dd.MM.yyyy HH:mm): ");
        LocalDateTime doctorTime = LocalDateTime.parse(scanner.nextLine(), formatter);

        ZoneId doctorZone = ZoneId.of("Europe/Berlin");
        ZoneId patientZone = ZoneId.of("America/New_York");

        ZonedDateTime doctorZoned = doctorTime.atZone(doctorZone);
        ZonedDateTime patientZoned = doctorZoned.withZoneSameInstant(patientZone);

        System.out.println("Consultation time for the doctor: " + doctorZoned.format(formatter) + " (Berlin)");
        System.out.println("Consultation time for the patient: " + patientZoned.format(formatter) + " (New York)");
    }
}
