package oncall.model;

import oncall.exception.Exceptions;

public class OncallMembers {
    private final WeekdayOncallMembers weekdayOncallMembers;
    private final HolidayOncallMembers holidayOncallMembers;

    public OncallMembers(
            WeekdayOncallMembers weekdayOncallMembers,
            HolidayOncallMembers holidayOncallMembers
    ) {
        validateOncallMembers(weekdayOncallMembers, holidayOncallMembers);
        this.weekdayOncallMembers = weekdayOncallMembers;
        this.holidayOncallMembers = holidayOncallMembers;
    }

    private void validateOncallMembers(
            WeekdayOncallMembers weekdayOncallMembers,
            HolidayOncallMembers holidayOncallMembers
    ) {
        if (weekdayOncallMembers.getMembersCount() < 5 || weekdayOncallMembers.getMembersCount() > 35) {
            throw Exceptions.INPUT_FORMAT_EXCEPTION.getException();
        }
        if (holidayOncallMembers.getMembersCount() < 5 || holidayOncallMembers.getMembersCount() > 35) {
            throw Exceptions.INPUT_FORMAT_EXCEPTION.getException();
        }
    }
}
