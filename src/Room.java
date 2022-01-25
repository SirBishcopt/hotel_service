import java.util.Random;

public class Room {

    private int roomNumber;
    private int numberOfPersons;
    private boolean hasPrivateBathroom;
    private boolean isAvailable;

    public Room(int roomNumber) {
        Random random = new Random();
        this.roomNumber = roomNumber;
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

}