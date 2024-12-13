package oncall.model;

public class OncallMembers {
    private final WeekdayOncallMembers weekdayOncallMembers;
    private final HolidayOncallMembers holidayOncallMembers;

    public OncallMembers(WeekdayOncallMembers weekdayOncallMembers, HolidayOncallMembers holidayOncallMembers) {
        this.weekdayOncallMembers = weekdayOncallMembers;
        this.holidayOncallMembers = holidayOncallMembers;
    }
}
