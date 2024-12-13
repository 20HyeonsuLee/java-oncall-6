package oncall.exception;

public enum Exceptions {

    INPUT_FORMAT_EXCEPTION(new IllegalArgumentBaseException("유효하지 않은 입력 값입니다. 다시 입력해 주세요.")),
    ;

    private final IllegalArgumentBaseException exception;

    Exceptions(IllegalArgumentBaseException exception) {
        this.exception = exception;
    }

    public IllegalArgumentBaseException getException() {
        return exception;
    }
}
