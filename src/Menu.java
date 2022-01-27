import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    private Scanner scanner = new Scanner(System.in);
    private UserService userService;

    public Menu(UserService userService) {
        this.userService = userService;
    }

    public boolean display() {
        System.out.println(
                "\nWelcome to Hotel Service. What would you like to do? \n" +
                        "  1) List all rooms (with status).\n" +
                        "  2) List available rooms.\n" +
                        "  3) Room check-in.\n" +
                        "  4) Room check-out.\n" +
                        "  5) Exit Hotel Service.\n"
        );

        String selection = scanner.nextLine();

        try {
            switch (selection) {
                case "1":
                    userService.listAllRoomsWithStatus();
                    return true;
                case "2":
                    userService.listAvailableRooms();
                    return true;
                case "3":
                    userService.checkIn();
                    return true;
                case "4":
                    userService.checkOut();
                    return true;
                case "5":
                    System.out.println("Thank you for using Hotel Service.");
                    return false;
                default:
                    System.out.println("Invalid selection.");
                    return true;
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid entry.");
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return true;
        }
    }

}
