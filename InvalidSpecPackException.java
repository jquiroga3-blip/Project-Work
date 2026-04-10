public class InvalidSpecPackException extends Exception {
    public static final String DEFAULT_MESSAGE = "Invalid spec pack data provided.";
    public static final String INVALID_TIME = "Time deadline must be between 9 and 16 inclusive.";

    public InvalidSpecPackException() {
        super(DEFAULT_MESSAGE);
    }

    public InvalidSpecPackException(String message) {
        super(message);
    }

    public InvalidSpecPackException(int invalidTime) {
        super("Invalid Delivery Time(" + invalidTime + ")");
    }
}



