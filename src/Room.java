import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Room {

    private int roomNumber;
    private int numberOfPersons;
    private boolean hasPrivateBathroom;
    private boolean isAvailable;
    private List<Guest> guests = new ArrayList<>();
    private boolean isClean = true;
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

    public int getNumberOfPersons() {
        return numberOfPersons;
    }

    @Override
    public String toString() {
        String availability;
        if (isAvailable){
            availability = "is available";
        } else {
            availability = "is occupied";
        }
        String cleanliness;
        if (isClean){
            cleanliness = "is clean";
        } else {
            cleanliness = "needs cleaning";
        }
        return "Room " + roomNumber + ": " + availability + ", " + cleanliness;
    }

    public void addGuest (Guest guest){
        guests.add(guest);
    }

    public void clearGuests(){
        guests.clear();
    }

    public boolean isAnyGuestOver18() {
        for (Guest guest : guests) {
            if (guest.getAge() > 18){
                return true;
            }
        }
        return false;
    }

    public void setClean(boolean clean) {
        isClean = clean;
    }

    public boolean isClean() {
        return isClean;
    }

}