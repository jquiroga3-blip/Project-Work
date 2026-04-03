public class InvalidSpecPackException extends Exception {
    public InvalidSpecPackException(int invalidTime) {
        super("Invalid Delivery Time(" + invalidTime + ")");
    }
}



