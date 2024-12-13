package oncall.model;

import java.util.List;

public class Holiday {
    private final List<Date> holidays = List.of(
            new Date(new Month(1, null), 1),
            new Date(new Month(3, null), 1),
            new Date(new Month(5, null), 5),
            new Date(new Month(6, null), 6),
            new Date(new Month(8, null), 15),
            new Date(new Month(10, null), 3),
            new Date(new Month(10, null), 9),
            new Date(new Month(12, null), 5)
    );

    public boolean isHolidays(Date date) {
        if (date.getDayOfWeek() == DayOfWeek.SATURDAY ||
            date.getDayOfWeek() == DayOfWeek.SUNDAY
        ) {
            return true;
        }
        return holidays.stream().anyMatch(holiday -> {
            if (holiday.getMonth() != date.getMonth()) {
                return false;
            }
            return holiday.getDay() == date.getDay();
        });
    }
}
