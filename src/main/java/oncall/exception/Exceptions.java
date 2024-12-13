package oncall.exception;

public enum Exceptions {

    PRICE_NUMBER_FORMAT_EXCEPTION(new IllegalArgumentBaseException("가격은 숫자여야 합니다.")),
    ;

    private final IllegalArgumentBaseException exception;

    Exceptions(IllegalArgumentBaseException exception) {
        this.exception = exception;
    }

    public IllegalArgumentBaseException getException() {
        return exception;
    }
}
