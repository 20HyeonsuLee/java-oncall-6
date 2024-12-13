package oncall.model;

import oncall.exception.Exceptions;

public class Date {
    private final Month month;
    private final int day;

    public Date(Month month, int day) {
        validateDay(month, day);
        this.month = month;
        this.day = day;
    }

    public Month getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public DayOfWeek getDayOfWeek() {
        return DayOfWeek.values()[(day + month.getFirstDayOfWeek().ordinal()) % 7];
    }

    private void validateDay(Month month, int day) {
        if (day < 0 || day > month.countDays()) {
            throw Exceptions.INPUT_FORMAT_EXCEPTION.getException();
        }
    }
}
