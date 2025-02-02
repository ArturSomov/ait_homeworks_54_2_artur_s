package homework_34;

class NoGuestException extends Exception {
    public NoGuestException(String message) {
        super(message);
    }
}

class RoomUnavailableException extends Exception {
    public RoomUnavailableException(String message) {
        super(message);
    }
}

public class SimpleBooking {

    private static final int[] rooms = {100, 101, 102, 200, 201};
    private static final String[] guests = new String[5];
    private static final boolean[] roomStatus = new boolean[5];


    public void bookRoom(int roomNumber, String guestName) throws RoomUnavailableException {

        if (roomNumber <= 0) {
            throw new IllegalArgumentException("Incorrect room number: " + roomNumber);
        }
        if (guestName == null || guestName.trim().isEmpty()) {
            throw new IllegalArgumentException("Incorrect guest name");
        }
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i] == roomNumber) {
                if (roomStatus[i]) {
                    throw new RoomUnavailableException("Room " + roomNumber + " is already booked");
                }
                roomStatus[i] = true;
                guests[i] = guestName;
                System.out.println("Room " + roomNumber + " is successfully booked for " + guestName);
                return;
            }
        }
        throw new IllegalArgumentException("Room with number " + roomNumber + " is not exist");
    }

    public void cancelReservation(int roomNumber) throws RoomUnavailableException {
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i] == roomNumber) {
                if (!roomStatus[i]) {
                    throw new RoomUnavailableException("You cannot cancel a non-existent reservation for a room " + roomNumber);
                }
                roomStatus[i] = false;
                guests[i] = null;
                System.out.println("Booking for room " + roomNumber + " is cancelled");
                return;
            }
        }
        throw new IllegalArgumentException("Room with number " + roomNumber + " is not existed");
    }

    public void addGuest(int roomIndex, String guestName) {
        if (roomIndex < 0 || roomIndex >= rooms.length) {
            throw new ArrayIndexOutOfBoundsException("Incorrect room index");
        }
        if (guestName == null || guestName.trim().isEmpty()) {
            throw new IllegalArgumentException("Incorrect guest name");
        }
        guests[roomIndex] = guestName;
        System.out.println("Guest " + guestName + " added to room " + rooms[roomIndex]);
    }

    public String getGuest(int roomIndex) throws NoGuestException {
        if (roomIndex < 0 || roomIndex >= rooms.length) {
            throw new ArrayIndexOutOfBoundsException("Incorrect room index");
        }
        if (guests[roomIndex] == null) {
            throw new NoGuestException("There is no guests in room " + rooms[roomIndex]);
        }
        return guests[roomIndex];
    }


    public static void main(String[] args) {
        SimpleBooking booking = new SimpleBooking();

        try {
            booking.bookRoom(101, "Ivan Ivanov");
            booking.bookRoom(101, "Anna Hanna"); // Ошибка: комната уже занята
        } catch (Exception e) {
            System.out.println("Error by booking: " + e.getMessage());
        }

        try {
            booking.cancelReservation(101);
            booking.cancelReservation(101); // Ошибка: отмена несуществующего бронирования
        } catch (Exception e) {
            System.out.println("Error by cancelling booking: " + e.getMessage());
        }

        try {
            booking.cancelReservation(999); // Ошибка: комната не существует
        } catch (Exception e) {
            System.out.println("Error by cancelling booking: " + e.getMessage());
        }
    }
}
