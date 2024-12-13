package oncall.model;

import java.util.Arrays;
import oncall.exception.Exceptions;

public enum DayOfWeek {

    SUNDAY("일"),
    MONDAY("월"),
    TUESDAY("화"),
    WEDNESDAY("수"),
    THURSDAY("목"),
    FRIDAY("금"),
    SATURDAY("토"),
    ;

    final String dayOfWeekInKorean;

    DayOfWeek(String dayOfWeekInKorean) {
        this.dayOfWeekInKorean = dayOfWeekInKorean;
    }

    public String getDayOfWeekInKorean() {
        return dayOfWeekInKorean;
    }

    public static DayOfWeek from(String dayOfWeekInKorean) {
        return Arrays.stream(DayOfWeek.values())
                .filter(dayOfWeek -> dayOfWeek.dayOfWeekInKorean.equals(dayOfWeekInKorean))
                .findFirst()
                .orElseThrow(Exceptions.INPUT_FORMAT_EXCEPTION::getException);
    }
}
