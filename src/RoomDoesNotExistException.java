public class RoomDoesNotExistException extends RuntimeException {

    public RoomDoesNotExistException() {
        super("There is no such room. Check the given room number.");
    }

}
