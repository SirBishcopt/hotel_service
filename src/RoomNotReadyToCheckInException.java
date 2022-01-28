public class RoomNotReadyToCheckInException extends RuntimeException {

    public RoomNotReadyToCheckInException() {
        super("Room is occupied.");
    }

}
