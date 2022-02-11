import java.time.LocalDate;
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
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private static int numberOfRoomsCreated = 0;

    public Room() {
        Random random = new Random();
        numberOfRoomsCreated++;
        roomNumber = numberOfRoomsCreated;
        numberOfPersons = random.nextInt(6) + 1;
        hasPrivateBathroom = random.nextBoolean();
        isAvailable = random.nextBoolean();
        if (!isAvailable) {
            checkInDate = LocalDate.now().minusDays(random.nextInt(10) - 1);
            checkOutDate = LocalDate.now().plusDays(random.nextInt(11));
        }
    }

    @Override
    public String toString() {
        String availability;
        if (isAvailable) {
            availability = "is available";
        } else {
            availability = "is occupied";
        }
        String cleanliness;
        if (isClean) {
            cleanliness = "is clean";
        } else {
            cleanliness = "needs cleaning";
        }
        if (isAvailable) {
            return "Room " + roomNumber + ": " + availability + ", " + cleanliness;
        } else {
            return "Room " + roomNumber + ": " + availability + ", " + cleanliness + ", date of check out: " + checkOutDate;
        }
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public boolean isClean() {
        return isClean;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setClean(boolean clean) {
        isClean = clean;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public int getNumberOfPersons() {
        return numberOfPersons;
    }

    public void addGuest(Guest guest) {
        guests.add(guest);
    }

    public boolean isAnyGuestOver18() {
        for (Guest guest : guests) {
            if (guest.getAge() > 18) {
                return true;
            }
        }
        return false;
    }

    public void clearGuests() {
        guests.clear();
    }

}