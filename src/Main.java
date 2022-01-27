public class Main {

    public static void main(String[] args) {

        Hotel hotel = new Hotel(12);
        UserService userService = new UserService(hotel);
        Menu menu = new Menu(userService);

        boolean displayMenu = true;
        while (displayMenu) {
            displayMenu = menu.display();
        }

    }
}