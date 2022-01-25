import java.util.ArrayList;
import java.util.List;

public class UserService {

    private Hotel hotel;

    public UserService(Hotel hotel) {
        this.hotel = hotel;
    }

    public List<Room> getListOfAllRooms() {
        return hotel.getRooms();
    }

    public List<Room> getListOfAvailableRooms() {
        List<Room> availableRooms = new ArrayList<>();
        List<Room> allRooms = hotel.getRooms();
        for (Room room : allRooms) {
            if (room.isAvailable()) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

    public void markRoomAsOccupied(int roomNumber) {
        List<Room> allRooms = hotel.getRooms();
        Room selectedRoom = null;
        for (Room room : allRooms) {
            if (room.getRoomNumber() == roomNumber) {
                selectedRoom = room;
            }
        }
        if (selectedRoom == null) {
            throw new RoomDoesNotExistException();
        } else {
            if (selectedRoom.isAvailable()) {
                selectedRoom.setAvailable(false);
            } else {
                throw new RoomIsOccupiedException();
            }
        }
    }

    public void markRoomAsAvailable(int roomNumber) {
        List<Room> allRooms = hotel.getRooms();
        Room selectedRoom = null;
        for (Room room : allRooms) {
            if (room.getRoomNumber() == roomNumber) {
                selectedRoom = room;
            }
        }
        if (selectedRoom == null) {
            throw new RoomDoesNotExistException();
        } else {
            if (!selectedRoom.isAvailable()) {
                selectedRoom.setAvailable(true);
            } else {
                throw new RoomIsOccupiedException();
            }
        }
    }

}