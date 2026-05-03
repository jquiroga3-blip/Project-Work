public class InvalidTruckException extends Exception {

    public static final String DEFAULT_MESSAGE = "Invalid truck data provided.";
    public static final String INVALID_TRUCK_TYPE = "Truck type must be 1 (small), 2 (medium), or 3 (large).";
    public static final String INVALID_PACK = "Package cannot be null.";
    public static final String INVALID_CAPACITY = "Package exceeds truck's maximum weight and volume capacity.";
    //public static final String INVALID_VOLUME = "Package exceeds truck's maximum volume capacity.";

    public InvalidTruckException() {
        super(DEFAULT_MESSAGE);
    }

    public InvalidTruckException(String message) {
        super(message);
    }

    public InvalidTruckException(int invalidType) {
        super("Invalid Truck Type(" + invalidType + ")");
    }
}