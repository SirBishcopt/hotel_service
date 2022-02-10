import java.time.LocalDate;
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
        System.out.println("\nList of available rooms:\n");
        List<Room> availableRooms = hotel.getAvailableRooms();
        for (Room room : availableRooms) {
            System.out.println(room);
        }
    }

    public void listOccupatedRooms() {
        System.out.println("\nList of occupated rooms:\n");
        List<Room> occupatedRooms = hotel.getOccupatedRooms();
        for (Room room : occupatedRooms) {
            System.out.println(room);
        }
    }

    public void listCleanRooms() {
        System.out.println("\nList of clean rooms:\n");
        List<Room> cleanRooms = hotel.getCleanRooms();
        for (Room room : cleanRooms) {
            System.out.println(room);
        }
    }

    public void cleanRoom(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter room's number:");
        int selection = scanner.nextInt();
        scanner.nextLine();
        Room selectedRoom = hotel.getRoomOfGivenNumber(selection);
        selectedRoom.setClean(true);
        System.out.println(selectedRoom);
    }

    public void checkIn() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter room's number:");
        int selection = scanner.nextInt();
        scanner.nextLine();
        Room selectedRoom = hotel.getRoomOfGivenNumber(selection);
        markRoomAsOccupied(selectedRoom);
        addGuests(selectedRoom);
        if (selectedRoom.isAnyGuestOver18()) {
            System.out.println(hotel.getRoomOfGivenNumber(selection));
        } else {
            System.out.println("At least one of guests have to be over 18 years old.");
            markRoomAsAvailable(selection);
            selectedRoom.setClean(true);
        }
    }

    private void addGuests(Room selectedRoom) {
        System.out.println("\nAdd first guest.");
        boolean addingAnotherGuests = true;
        int numberOfGuests = 0;
        while (addingAnotherGuests) {
            Guest guest = createGuest();
            selectedRoom.addGuest(guest);
            numberOfGuests++;
            if (numberOfGuests == selectedRoom.getNumberOfPersons()) {
                addingAnotherGuests = false;
                System.out.println("\nLimit of guests per room reached.");
            } else {
                addingAnotherGuests = askIfUserWantsToAddAnotherGuest();
            }
        }
    }

    private Guest createGuest() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Name:");
        String name = scanner.nextLine();
        System.out.println("Surname:");
        String surname = scanner.nextLine();
        LocalDate dateOfBirth = obtainDateOfBirth();
        return new Guest(name, surname, dateOfBirth);
    }

    private LocalDate obtainDateOfBirth() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Date of birth (yyyy-mm-dd):");
        String userInput = scanner.nextLine();
        try {
            LocalDate dateOfBirth = LocalDate.parse(userInput);
            if (dateOfBirth.isAfter(LocalDate.of(1910, 1, 1)) && dateOfBirth.isBefore(LocalDate.now())) {
                return dateOfBirth;
            } else {
                System.out.println("Insert correct date.");
                return obtainDateOfBirth();
            }
        } catch (Exception e) {
            System.out.println("Insert correct date.");
            return obtainDateOfBirth();
        }
    }

    private boolean askIfUserWantsToAddAnotherGuest() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to add another guest? (y/n)");
        String answer = scanner.nextLine();
        if (answer.equalsIgnoreCase("y")) {
            return true;
        } else if (answer.equalsIgnoreCase("n")) {
            return false;
        } else {
            return askIfUserWantsToAddAnotherGuest();
        }
    }

    private void markRoomAsOccupied(Room selectedRoom) {
        if (selectedRoom.isAvailable() && selectedRoom.isClean()) {
            selectedRoom.setAvailable(false);
        } else {
            throw new RoomNotReadyToCheckInException();
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
        selectedRoom.clearGuests();
        selectedRoom.setAvailable(true);
        selectedRoom.setClean(false);
    }

}