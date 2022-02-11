public class NoGuestOver18Exception extends RuntimeException {

    public NoGuestOver18Exception() {
        super("At least one of guests have to be over 18 years old.");
    }

}
