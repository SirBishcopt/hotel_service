import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserService {

    private Hotel hotel;

    public UserService(Hotel hotel) {
        this.hotel = hotel;
    }

    public void listAllRoomsWithStatus() {
        System.out.println("\nList of all rooms:\n");
        List<Room> allRooms = hotel.getRooms();
        for (Room room : allRooms) {
            System.out.println(room);
        }
    }

    public void listAvailableRooms() {
        System.out.println("\nList of all rooms:\n");
        List<Room> availableRooms = hotel.getAvailableRooms();
        for (Room room : availableRooms) {
            System.out.println(room);
        }
    }

    public void checkIn() {
        System.out.println("Enter room's number:");
        Scanner scanner = new Scanner(System.in);
        int selection = scanner.nextInt();
        scanner.nextLine();
        markRoomAsOccupied(selection);
        System.out.println(hotel.getRoomOfGivenNumber(selection));
    }

    private void markRoomAsOccupied(int roomNumber) {
        Room selectedRoom = hotel.getRoomOfGivenNumber(roomNumber);
        if (selectedRoom.isAvailable()) {
            selectedRoom.setAvailable(false);
        } else {
            throw new RoomIsOccupiedException();
        }
    }

    public void checkOut() {
        System.out.println("Enter room's number:");
        Scanner scanner = new Scanner(System.in);
        int selection = scanner.nextInt();
        scanner.nextLine();
        markRoomAsAvailable(selection);
        System.out.println(hotel.getRoomOfGivenNumber(selection));
    }

    private void markRoomAsAvailable(int roomNumber) {
        Room selectedRoom = hotel.getRoomOfGivenNumber(roomNumber);
        selectedRoom.setAvailable(true);
    }

}