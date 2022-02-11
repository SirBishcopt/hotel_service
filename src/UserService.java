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

    public void listOccupiedRooms() {
        System.out.println("\nList of occupied rooms:\n");
        List<Room> occupiedRooms = hotel.getOccupiedRooms();
        for (Room room : occupiedRooms) {
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

    public void cleanRoom() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter room's number:");
            int selection = scanner.nextInt();
            scanner.nextLine();
            hotel.cleanRoom(selection);
            System.out.println(hotel.getRoomOfGivenNumber(selection));
        } catch (RoomDoesNotExistException e) {
            System.out.println(e.getMessage());
        }
    }

    public void checkIn() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter room's number:");
            int selection = scanner.nextInt();
            scanner.nextLine();
            hotel.initiateCheckIn(selection);
            addGuests(selection);
            hotel.validateCheckIn(selection);
            System.out.println(hotel.getRoomOfGivenNumber(selection));
        } catch (RoomDoesNotExistException | RoomNotReadyToCheckInException e) {
            System.out.println(e.getMessage());
        }
    }

    private void addGuests(int selection) {
        System.out.println("\nAdd first guest.");
        boolean addingAnotherGuests = true;
        int numberOfGuests = 0;
        int limitOfGuests = hotel.getLimitOfGuestsPerRoom(selection);
        while (addingAnotherGuests) {
            addGuestToRoom(selection);
            numberOfGuests++;
            if (numberOfGuests == limitOfGuests) {
                addingAnotherGuests = false;
                System.out.println("\nLimit of guests per room reached.");
            } else {
                addingAnotherGuests = askIfUserWantsToAddAnotherGuest();
            }
        }
    }

    private void addGuestToRoom(int selection) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Name:");
        String name = scanner.nextLine();
        System.out.println("Surname:");
        String surname = scanner.nextLine();
        LocalDate dateOfBirth = obtainDateOfBirth();
        hotel.addGuestToRoom(selection, name, surname, dateOfBirth);
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

    public void checkOut() {
        try {
            System.out.println("Enter room's number:");
            Scanner scanner = new Scanner(System.in);
            int selection = scanner.nextInt();
            scanner.nextLine();
            hotel.markRoomAsAvailable(selection);
            System.out.println(hotel.getRoomOfGivenNumber(selection));
        } catch (RoomDoesNotExistException e) {
            System.out.println(e.getMessage());
        }
    }

}