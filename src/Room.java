import java.util.Random;

public class Room {

    private int roomNumber;
    private int numberOfPersons;
    private boolean hasPrivateBathroom;
    private boolean isAvailable;
    private static int numberOfRoomsCreated = 0;

    public Room() {
        Random random = new Random();
        numberOfRoomsCreated++;
        roomNumber = numberOfRoomsCreated;
        numberOfPersons = random.nextInt(6)+1;
        hasPrivateBathroom = random.nextBoolean();
        isAvailable = random.nextBoolean();
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    @Override
    public String toString() {
        String availability;
        if (isAvailable){
            availability = "is available";
        } else {
            availability = "is occupied";
        }
        return "Room " + roomNumber + ": " + availability;
    }
}