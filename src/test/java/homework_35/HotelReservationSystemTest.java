package homework_35;

///Упражнение 4: Написание JUnit-тестов для HotelReservationSystem.java

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HotelReservationSystemTest {

    private HotelReservationSystem hotel;

    @BeforeEach
    public void setup() {
        // Create a new instance of HotelReservationSystem before each test
        hotel = new HotelReservationSystem();
    }

    /**
     * Тест успешного бронирования.
     * Комната 101 в исходной конфигурации не занята, поэтому метод reserveRoom не должен выбрасывать исключений.
     */
    @Test
    public void testSuccessfulReservation() {
        try {
            hotel.reserveRoom(101, "John Doe");
        } catch (Exception e) {
            // If any exception occurs, the test crashes with an error message
            fail("No exception expected, but got: " + e.getMessage());
        }
    }

    /**
     * Тест попытки бронирования уже забронированной комнаты.
     * В конструкторе комнаты 201 уже помечена как забронированная.
     */
    @Test
    public void testReserveRoomWhenRoomIsUnavailable() {
        try {
            hotel.reserveRoom(201, "Jane Doe");
            // If the method did not throw an exception, the test is considered to have failed
            fail("Expected RoomUnavailableException to be thrown");
        } catch (HotelReservationSystem.RoomUnavailableException e) {
            // Verify that the exception message is as expected
            assertEquals("Room 201 is unavailable", e.getMessage());
        } catch (Exception e) {
            // If another exception was thrown, the test also crashes
            fail("Unexpected exception thrown: " + e.getMessage());
        }
    }

    /**
     * Тест бронирования комнаты, которой не существует.
     * Комнаты с номером 999 нет в roomsInfo, поэтому метод должен выбросить RoomUnavailableException.
     */
    @Test
    public void testReserveRoomNonExistent() {
        try {
            hotel.reserveRoom(999, "Someone");
            fail("Expected RoomUnavailableException to be thrown");
        } catch (HotelReservationSystem.RoomUnavailableException e) {
            assertEquals("Room 999 is unavailable", e.getMessage());
        } catch (Exception e) {
            fail("Unexpected exception thrown: " + e.getMessage());
        }
    }

    /**
     * Тест успешной отмены бронирования.
     * Комната 201 изначально забронирована, поэтому отмена бронирования должна пройти без всяких исключений.
     */
    @Test
    public void testSuccessfulCancellation() {
        try {
            hotel.cancelReservation(201);
        } catch (Exception e) {
            fail("No exception expected, but got: " + e.getMessage());
        }
    }

    /**
     * Тест отмены бронирования для комнаты, которая еще не забронирована.
     * Комната 101 свободна, поэтому попытка отмены бронирования должна выбросить NoActiveReservationException.
     */
    @Test
    public void testCancelReservationWhenNoActiveReservation() {
        try {
            hotel.cancelReservation(101);
            fail("Expected NoActiveReservationException to be thrown");
        } catch (HotelReservationSystem.NoActiveReservationException e) {
            assertEquals("No active reservation for room 101", e.getMessage());
        } catch (Exception e) {
            fail("Unexpected exception thrown: " + e.getMessage());
        }
    }

    /**
     * Тест отмены бронирования для комнаты, которой не существует.
     * Комнаты 999 нет, поэтому метод cancelReservation должен выбросить NoActiveReservationException.
     */
    @Test
    public void testCancelReservationNonExistentRoom() {
        try {
            hotel.cancelReservation(999);
            fail("Expected NoActiveReservationException to be thrown");
        } catch (HotelReservationSystem.NoActiveReservationException e) {
            assertEquals("No active reservation for room 999", e.getMessage());
        } catch (Exception e) {
            fail("Unexpected exception thrown: " + e.getMessage());
        }
    }
}
