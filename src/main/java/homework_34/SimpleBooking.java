package homework_34;

class NoGuestException extends Exception {
    public NoGuestException(String message) {
        super(message);
    }
}

public class SimpleBooking {

    private static final int[] rooms = {100, 101, 102, 200, 201};
    private static final String[] guests = new String[5];

    public void bookRoom (int roomNumber, String guestName) {

        if (roomNumber <= 0) {
            throw new IllegalArgumentException("Incorrect room number: " + roomNumber);
        }
        if (guestName == null || guestName.trim().isEmpty()) {
            throw new IllegalArgumentException("Incorrect guest name");
        }
        System.out.println("Room " + roomNumber + " is successfully booked for " + guestName);
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

        int [] testRooms = {101, -1, 202, 0};
        String [] testGuests = {"Mr Freeman", "", null, "Ms Smith"};

        for (int i = 0; i < testRooms.length; i++) {
            try {
                booking.bookRoom(testRooms[i], testGuests[i]);
            } catch (IllegalArgumentException e) {
                System.out.println("Incorrect booking information: " + e.getMessage());
            }

            try {
                booking.addGuest(1, "John Snow");
                booking.addGuest(5, "Triss Merigold");
            } catch (Exception e) {
                System.out.println("Error by adding guest " + e.getMessage());
            }

            try {
                System.out.println("Guest in room 102: " + booking.getGuest(1));
                System.out.println("Guest in room 103: " + booking.getGuest(2));
                System.out.println("Guest in room 201: " + booking.getGuest(3));
            } catch (Exception e) {
                System.out.println("Error by adding guest: " + e.getMessage());
            }
        }
    }
}
