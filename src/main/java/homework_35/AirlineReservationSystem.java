package homework_35;

///Упражнение 3: Создание пользовательского исключения и реализация системы резервирования авиабилетов

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

class SeatUnavailableException extends Exception {
    public SeatUnavailableException(String message) {
        super(message);
    }
}

@Slf4j
public class AirlineReservationSystem {

    private Map<String, Map<Integer, Boolean>> flightData;

    public AirlineReservationSystem() {
        flightData = new HashMap<>();
    }

    // Method for adding a new flight
    public void addFlight(String flightNumber, Map<Integer, Boolean> seats) {
        log.info("Adding flight {} with seats: {}", flightNumber, seats);
        flightData.put(flightNumber, seats);
    }

    public void reserveSeat(String flightNumber, int seatNumber, String passengerName) throws SeatUnavailableException {
        log.info("Attempting to reserve seat. Flight: {}, Seat: {}, Passenger: {}", flightNumber, seatNumber, passengerName);

        // Input data verification
        if (flightNumber == null || flightNumber.trim().isEmpty()) {
            log.error("Invalid flight number provided.");
            throw new IllegalArgumentException("Incorrect flight number");
        }
        // Flight number format validation example (two capital letters and up to 4 digits)
        if (!flightNumber.matches("[A-Z]{2}\\d{1,4}")) {
            log.error("Invalid flight number format for flight: {}", flightNumber);
            throw new IllegalArgumentException("Incorrect flight number format. Two letters and up to four digits are expected.");
        }
        if (seatNumber <= 0) {
            log.error("Invalid seat number: {}", seatNumber);
            throw new IllegalArgumentException("Incorrect seat number");
        }
        if (passengerName == null || passengerName.trim().isEmpty()) {
            log.error("Invalid passenger name provided.");
            throw new IllegalArgumentException("Incorrect passenger name");
        }
        // Check flight availability
        if (!flightData.containsKey(flightNumber)) {
            log.error("Flight {} does not exist", flightNumber);
            throw new IllegalArgumentException("Flight " + flightNumber + " is not existing");
        }
        Map<Integer, Boolean> seats = flightData.get(flightNumber);
        // Checking the existence of a seat
        if (!seats.containsKey(seatNumber)) {
            log.error("Seat {} does not exist for flight {}", seatNumber, flightNumber);
            throw new IllegalArgumentException("Seat " + seatNumber + " is not existing for the flight " + flightNumber);
        }
        // Check if the seat is occupied
        if (seats.get(seatNumber)) {
            log.error("Seat {} is already booked on flight {}", seatNumber, flightNumber);
            throw new SeatUnavailableException("Seat " + seatNumber + " is already taken");
        }
        // Reserving a seat
        seats.put(seatNumber, true);
        log.info("Seat {} successfully reserved for {} on flight {}", seatNumber, passengerName, flightNumber);
    }

    public void cancelReservation(String flightNumber, int seatNumber) throws SeatUnavailableException {
        log.info("Attempting to cancel reservation. Flight: {}, Seat: {}", flightNumber, seatNumber);

        // Input data validation
        if (flightNumber == null || flightNumber.trim().isEmpty()) {
            log.error("Invalid flight number provided.");
            throw new IllegalArgumentException("Incorrect flight number");
        }
        if (seatNumber <= 0) {
            log.error("Invalid seat number: {}", seatNumber);
            throw new IllegalArgumentException("Incorrect seat number");
        }
        // Check flight availability
        if (!flightData.containsKey(flightNumber)) {
            log.error("Flight {} does not exist", flightNumber);
            throw new IllegalArgumentException("Flight " + flightNumber + " is not existing");
        }
        Map<Integer, Boolean> seats = flightData.get(flightNumber);
        // Checking the existence of a seat
        if (!seats.containsKey(seatNumber)) {
            log.error("Seat {} does not exist for flight {}", seatNumber, flightNumber);
            throw new IllegalArgumentException("Seat " + seatNumber + " is not existing for the flight " + flightNumber);
        }
        // If a place is already available, it is not possible to cancel
        if (!seats.get(seatNumber)) {
            log.error("Seat {} is not booked on flight {}. Cancellation failed.", seatNumber, flightNumber);
            throw new SeatUnavailableException("Seat " + seatNumber + " has not been booked, cancellation is not possible");
        }
        // Cancellation of booking
        seats.put(seatNumber, false);
        log.info("Reservation for seat {} on flight {} has been cancelled", seatNumber, flightNumber);
    }
}
