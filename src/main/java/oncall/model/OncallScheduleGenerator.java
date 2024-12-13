package oncall.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class OncallScheduleGenerator {

    public Map<Date, Member> generateOncallSchedule(OncallMembers oncallMembers, Month month) {
        Map<Date, Member> schdule = new LinkedHashMap<>();
        HolidayOncallMembers holidayOncallMembers = oncallMembers.getHolidayOncallMembers();
        WeekdayOncallMembers weekdayOncallMembers = oncallMembers.getWeekdayOncallMembers();
        for (int i = 1; i <= month.countDays(); ++i) {
            Date date = new Date(month, i);
            if (Holiday.isHolidays(date)) {
                addHolidaySchedule(schdule, holidayOncallMembers, date);
            } else {
                addWeekdaySchedule(schdule, weekdayOncallMembers, date);
            }
        }
        return schdule;
    }

    private void addHolidaySchedule(Map<Date, Member> schedule, HolidayOncallMembers holidayOncallMembers, Date date) {
        Member member = holidayOncallMembers.getCurrentTurnMember();
        if (isThirdOncall(schedule, member)) {
            holidayOncallMembers.forwardTurn();
            addHolidaySchedule(schedule, holidayOncallMembers, date);
            return;
        }
        if (date.getDay() != 1 && schedule.get(date.prevDate()).equals(member)) {
            holidayOncallMembers.swap();
            addHolidaySchedule(schedule, holidayOncallMembers, date);
            return;
        }
        schedule.put(date, holidayOncallMembers.getCurrentTurnMember());
        holidayOncallMembers.forwardTurn();
    }

    private void addWeekdaySchedule(Map<Date, Member> schedule, WeekdayOncallMembers weekdayOncallMembers, Date date) {
        Member member = weekdayOncallMembers.getCurrentTurnMember();
        if (isThirdOncall(schedule, member)) {
            weekdayOncallMembers.forwardTurn();
            addWeekdaySchedule(schedule, weekdayOncallMembers, date);
            return;
        }
        if (date.getDay() != 1 && schedule.get(date.prevDate()).equals(member)) {
            weekdayOncallMembers.swap();
            addWeekdaySchedule(schedule, weekdayOncallMembers, date);
            return;
        }
        schedule.put(date, weekdayOncallMembers.getCurrentTurnMember());
        weekdayOncallMembers.forwardTurn();
    }

    private boolean isThirdOncall(Map<Date, Member> schedule, Member member) {
        return schedule.values()
                .stream()
                .filter(scheduleMember -> scheduleMember.equals(member)).count() == 3;
    }
}
