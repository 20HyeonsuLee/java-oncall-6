package oncall.model;

import oncall.exception.Exceptions;

public class Month {
    private final int month;
    private final DayOfWeek firstDayOfWeek;

    public Month(int month, DayOfWeek firstDayOfWeek) {
        validateMonth(month);
        this.month = month;
        this.firstDayOfWeek = firstDayOfWeek;
    }

    public int countDays() {
        if (month == 2) {
            return 28;
        }
        if ((month <= 7 && month % 2 == 1) || (month >= 8 && month % 2 == 0)) {
            return 31;
        }
        return 30;
    }

    private void validateMonth(int month) {
        if (month < 0 || month > 12) {
            throw Exceptions.INPUT_FORMAT_EXCEPTION.getException();
        }
    }
}
