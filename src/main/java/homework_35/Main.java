package homework_35;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class Main {

    public static void main(String[] args) {

        FlightBooking booking = new FlightBooking();

        ///Упражнение 1.
        // Correct booking
        try {
            booking.bookFlight("SU100", "Ivan Markov", 1);
        } catch (IllegalArgumentException e) {
            log.error("Booking failed: {}", e.getMessage());
        }

        // Incorrect flight number (empty string)
        try {
            booking.bookFlight("", "Ivan Markov", 1);
        } catch (IllegalArgumentException e) {
            log.error("Booking failed: {}", e.getMessage());
        }

        // Incorrect passenger name (empty string)
        try {
            booking.bookFlight("SU100", "", 1);
        } catch (IllegalArgumentException e) {
            log.error("Booking failed: {}", e.getMessage());
        }

        // Incorrect seat number (<= 0)
        try {
            booking.bookFlight("SU100", "Ivan Markov", 0);
        } catch (IllegalArgumentException e) {
            log.error("Booking failed: {}", e.getMessage());
        }
        System.out.println("-----------------------------------------------------------------");

        ///Упражнение 2.
        FlightPassengerManagement management = new FlightPassengerManagement();

        // Adding a passenger with correct data
        try {
            management.addPassenger(1, "Peter Parker");
        } catch (Exception e) {
            log.error("Error adding passenger: {}", e.getMessage());
        }

        // Attempting to add a passenger with an incorrect index
        try {
            management.addPassenger(5, "Max Maxi");
        } catch (Exception e) {
            log.error("Error adding passenger: {}", e.getMessage());
        }

        // Attempting to add a passenger with an incorrect name
        try {
            management.addPassenger(2, "");
        } catch (Exception e) {
            log.error("Error adding passenger: {}", e.getMessage());
        }

        // Retrieving a passenger by correct index
        try {
            String passenger = management.getPassenger(1);
            log.info("Passenger on flight {}: {}", management.getFlights()[1], passenger);
        } catch (Exception e) {
            log.error("Error retrieving passenger: {}", e.getMessage());
        }

        // Attempting to get a passenger where one is not specified
        try {
            String passenger = management.getPassenger(3);
            log.info("Passenger on flight {}: {}", management.getFlights()[3], passenger);
        } catch (Exception e) {
            log.error("Error retrieving passenger: {}", e.getMessage());
        }
        System.out.println("-----------------------------------------------------------------");

        ///Упражнение 3.
        AirlineReservationSystem system = new AirlineReservationSystem();

        // Initialization of data for multiple flights
        Map<Integer, Boolean> su100Seats = new HashMap<>();
        su100Seats.put(1, false);
        su100Seats.put(2, false);
        su100Seats.put(3, false);

        Map<Integer, Boolean> ba202Seats = new HashMap<>();
        ba202Seats.put(10, false);
        ba202Seats.put(11, false);

        system.addFlight("SU100", su100Seats);
        system.addFlight("BA202", ba202Seats);

        // Examples of booking and cancellation scenarios
        try {
            system.reserveSeat("SU100", 1, "Ivan Ivanov");
        } catch (Exception e) {
            log.error("Error reserving seat: {}", e.getMessage());
        }

        try {
            // Attempting to book a seat already occupied by a passenger
            system.reserveSeat("SU100", 1, "Peter Parker");
        } catch (Exception e) {
            log.error("Error reserving seat: {}", e.getMessage());
        }

        try {
            // Attempting to book a non-existent seat
            system.reserveSeat("SU100", 5, "Max Maxi");
        } catch (Exception e) {
            log.error("Error reserving seat: {}", e.getMessage());
        }

        try {
            // Attempted booking for a non-existent flight
            system.reserveSeat("XX999", 1, "Mary May");
        } catch (Exception e) {
            log.error("Error reserving seat: {}", e.getMessage());
        }

        try {
            // Successful cancellation of reservation
            system.cancelReservation("SU100", 1);
        } catch (Exception e) {
            log.error("Error cancelling reservation: {}", e.getMessage());
        }

        try {
            // Attempting to cancel a reservation for a seat that has not been booked
            system.cancelReservation("SU100", 2);
        } catch (Exception e) {
            log.error("Error cancelling reservation: {}", e.getMessage());
        }
        System.out.println("-----------------------------------------------------------------");
    }
}