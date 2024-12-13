package oncall.view;

import java.util.List;

public enum OutputMessage {

    OUTPUT_SCHEDULE("%d월 %d일 %s %s")
    ;

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void print(Object... values) {
        System.out.println(format(values));
    }

    public String format(Object... values) {
        return String.format(message, values);
    }

    public String format(List<String> values) {
        return String.format(message, values.toArray());
    }
}
