package homework_35;

///Упражнение 2: Работа с массивом доступных рейсов и массивом пассажиров

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

class NoPassengerException extends Exception {
    public NoPassengerException(String message) {
        super(message);
    }
}

@Slf4j
public class FlightPassengerManagement {

    @Getter
    private String[] flights = {"SU100", "BA202", "LH300", "AF101", "AA777"};
    private String[] passengers = new String[flights.length];

    public void addPassenger(int flightIndex, String passengerName) {
        log.info("Attempting to add passenger. Flight index: {}, Passenger: {}", flightIndex, passengerName);
        if (flightIndex < 0 || flightIndex >= flights.length) {
            log.error("Invalid flight index: {}", flightIndex);
            throw new ArrayIndexOutOfBoundsException("Incorrect flight index: " + flightIndex);
        }
        if (passengerName == null || passengerName.trim().isEmpty()) {
            log.error("Invalid passenger name provided.");
            throw new IllegalArgumentException("Incorrect passenger name");
        }
        passengers[flightIndex] = passengerName;
        log.info("Passenger {} added to flight {}", passengerName, flights[flightIndex]);
    }

    public String getPassenger(int flightIndex) throws NoPassengerException {
        log.info("Attempting to get passenger for flight index: {}", flightIndex);
        if (flightIndex < 0 || flightIndex >= flights.length) {
            log.error("Invalid flight index: {}", flightIndex);
            throw new ArrayIndexOutOfBoundsException("Incorrect flight index: " + flightIndex);
        }
        if (passengers[flightIndex] == null) {
            log.error("No passenger found for flight {}", flights[flightIndex]);
            throw new NoPassengerException("For the flight " + flights[flightIndex] + " passenger was not found");
        }
        log.info("Passenger {} retrieved for flight {}", passengers[flightIndex], flights[flightIndex]);
        return passengers[flightIndex];
    }
}
