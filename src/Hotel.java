import java.util.ArrayList;
import java.util.List;

public class Hotel {

    private List<Room> rooms = new ArrayList<>();

    public Hotel() {
        rooms.add(new Room(1));
        rooms.add(new Room(2));
        rooms.add(new Room(3));
        rooms.add(new Room(4));
        rooms.add(new Room(5));
        rooms.add(new Room(6));
        rooms.add(new Room(7));
        rooms.add(new Room(8));
        rooms.add(new Room(9));
        rooms.add(new Room(10));
        rooms.add(new Room(11));
        rooms.add(new Room(12));
    }

    public List<Room> getRooms() {
        return rooms;
    }

}