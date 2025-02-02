package homework_35;


import lombok.extern.slf4j.Slf4j;

///Упражнение 1: Простая проверка данных о бронировании рейса

@Slf4j
public class FlightBooking {

    public void bookFlight(String flightNumber, String passengerName, int seatNumber) {
        if (flightNumber == null || flightNumber.trim().isEmpty()) {
            log.error("Invalid flight number provided.");
            throw new IllegalArgumentException("Incorrect flight number");
        }
        if (passengerName == null || passengerName.trim().isEmpty()) {
            log.error("Invalid passenger name provided.");
            throw new IllegalArgumentException("Incorrect passenger name");
        }
        if (seatNumber <= 0) {
            log.error("Invalid seat number provided.");
            throw new IllegalArgumentException("Incorrect seat number");
        }
        log.info("Flight {} successfully booked for {} at seat {}", flightNumber, passengerName, seatNumber);
    }
}
