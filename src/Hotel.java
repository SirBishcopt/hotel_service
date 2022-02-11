import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Hotel {

    private List<Room> rooms = new ArrayList<>();

    public Hotel(int numberOfRooms) {
        for (int i = 0; i < numberOfRooms; i++) {
            rooms.add(new Room());
        }
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public List<Room> getAvailableRooms() {
        List<Room> availableRooms = new ArrayList<>();
        for (Room room : rooms) {
            if (room.isAvailable()) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

    public List<Room> getOccupiedRooms() {
        List<Room> occupiedRooms = new ArrayList<>();
        for (Room room : rooms) {
            if (!room.isAvailable()) {
                occupiedRooms.add(room);
            }
        }
        return occupiedRooms;
    }

    public List<Room> getCleanRooms() {
        List<Room> cleanRooms = new ArrayList<>();
        for (Room room : rooms) {
            if (room.isClean()) {
                cleanRooms.add(room);
            }
        }
        return cleanRooms;
    }

    public Room getRoomOfGivenNumber(int roomNumber) {
        Room selectedRoom = null;
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                selectedRoom = room;
            }
        }
        if (selectedRoom == null) {
            throw new RoomDoesNotExistException();
        }
        return selectedRoom;
    }


    public void cleanRoom(int roomNumber) {
        Room selectedRoom = getRoomOfGivenNumber(roomNumber);
        selectedRoom.setClean(true);
    }

    public void initiateCheckIn(int roomNumber) {
        Room selectedRoom = getRoomOfGivenNumber(roomNumber);
        if (selectedRoom.isAvailable() && selectedRoom.isClean()) {
            selectedRoom.setAvailable(false);
            selectedRoom.setClean(false);
        } else {
            throw new RoomNotReadyToCheckInException();
        }
    }

    public void validateCheckIn(int roomNumber) {
        Room selectedRoom = getRoomOfGivenNumber(roomNumber);
        if (!selectedRoom.isAnyGuestOver18()) {
            selectedRoom.setAvailable(true);
            selectedRoom.setClean(true);
            throw new NoGuestOver18Exception();
        }
    }

    public int getLimitOfGuestsPerRoom(int roomNumber) {
        Room selectedRoom = getRoomOfGivenNumber(roomNumber);
        return selectedRoom.getNumberOfPersons();
    }

    public void addGuestToRoom(int roomNumber, String name, String surname, LocalDate dateOfBirth) {
        Room selectedRoom = getRoomOfGivenNumber(roomNumber);
        selectedRoom.addGuest(new Guest(name, surname, dateOfBirth));
    }

    public void markRoomAsAvailable(int roomNumber) {
        Room selectedRoom = getRoomOfGivenNumber(roomNumber);
        selectedRoom.clearGuests();
        selectedRoom.setAvailable(true);
        selectedRoom.setClean(false);
    }

}