public class InvalidPackException extends Exception {
public class InvalidPackException extends Exception {

    public static final String DEFAULT_MESSAGE = "Invalid pack data provided.";
    public static final String INVALID_WEIGHT = "Weight must be greater than 0.";
    public static final String INVALID_VOLUME = "Volume must be greater than 0.";
    public static final String INVALID_ZONE = "Delivery zone must be a letter followed by a digit.";
    public static final String INVALID_DATE = "Delivery date cannot be null.";
    public static final String INVALID_COMP_NAME = "Company name cannot be null.";

    public InvalidPackException() {
        super(DEFAULT_MESSAGE);
    }

    public InvalidPackException(String message) {
        super(message);
    }

}
