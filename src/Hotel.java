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

    public List<Room> getOccupatedRooms() {
        List<Room> occupatedRooms = new ArrayList<>();
        for (Room room : rooms) {
            if (!room.isAvailable()) {
                occupatedRooms.add(room);
            }
        }
        return occupatedRooms;
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

    public void cleanRoom (int roomNumber){
        Room selectedRoom = getRoomOfGivenNumber(roomNumber);
        selectedRoom.setClean(true);
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

}