package oncall.exception;

public class IllegalArgumentBaseException extends IllegalArgumentException {

    public IllegalArgumentBaseException(String message) {
        super(String.format("[ERROR] %s", message));
    }
}
