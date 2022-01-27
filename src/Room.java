import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Room {

    private int roomNumber;
    private int numberOfPersons;
    private boolean hasPrivateBathroom;
    private boolean isAvailable;
    private List<Guest> guests = new ArrayList<>();
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
        return "Room " + roomNumber + ": " + availability;
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

}