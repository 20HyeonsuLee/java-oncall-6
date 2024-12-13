package oncall.view;

public enum InputMessage {
    INPUT_MONTH("비상 근무를 배정할 월과 시작 요일을 입력하세요> "),
    INPUT_WEEKDAY_MEMBER("평일 비상 근무 순번대로 사원 닉네임을 입력하세요> "),
    INPUT_HOLIDAY_MEMBER("휴일 비상 근무 순번대로 사원 닉네임을 입력하세요> ")
    ;

    private final String message;

    InputMessage(String message) {
        this.message = message;
    }

    public void print(Object... values) {
        System.out.println(format(values));
    }

    public String format(Object... values) {
        return String.format(message, values);
    }
}
