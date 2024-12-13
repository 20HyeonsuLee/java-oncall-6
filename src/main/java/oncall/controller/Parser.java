package oncall.controller;

import java.util.Arrays;
import oncall.exception.Exceptions;
import oncall.model.DayOfWeek;
import oncall.model.HolidayOncallMembers;
import oncall.model.Member;
import oncall.model.Month;
import oncall.model.WeekdayOncallMembers;

public class Parser {

    private Parser() {
    }

    public static WeekdayOncallMembers parseWeekdayOncallMembers(String member) {
        String[] members = member.split(",");
        return new WeekdayOncallMembers(Arrays.stream(members)
                .map(Member::new)
                .toList());
    }

    public static HolidayOncallMembers parseHolidayOncallMembers(String member) {
        String[] members = member.split(",");
        return new HolidayOncallMembers(Arrays.stream(members)
                .map(Member::new)
                .toList());
    }

    public static Month parseMonth(String monthInfo) {
        String[] monthInfos = monthInfo.split(",");
        int month = parseInt(monthInfos[0]);
        DayOfWeek dayOfWeek = DayOfWeek.from(monthInfos[1]);
        return new Month(month, dayOfWeek);
    }

    public static int parseInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException exception) {
          throw Exceptions.INPUT_FORMAT_EXCEPTION.getException();
        }
    }
}
