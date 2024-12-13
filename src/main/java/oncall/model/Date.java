package oncall.model;

import java.util.Objects;
import oncall.exception.Exceptions;

public class Date {
    private final Month month;
    private final int day;

    public Date(Month month, int day) {
        validateDay(month, day);
        this.month = month;
        this.day = day;
    }

    public Date prevDate() {
        return new Date(month, day - 1);
    }

    public Month getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public DayOfWeek getDayOfWeek() {
        return DayOfWeek.values()[(day - 1 + month.getFirstDayOfWeek().ordinal()) % 7];
    }

    private void validateDay(Month month, int day) {
        if (day < 0 || day > month.countDays()) {
            throw Exceptions.INPUT_FORMAT_EXCEPTION.getException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Date date)) {
            return false;
        }
        return getDay() == date.getDay() && Objects.equals(getMonth(), date.getMonth());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMonth(), getDay());
    }
}
