package oncall.model;

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
}
