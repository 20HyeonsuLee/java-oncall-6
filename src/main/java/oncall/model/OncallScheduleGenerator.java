package oncall.model;

import java.util.ArrayList;
import java.util.List;

public class OncallScheduleGenerator {

    public List<Member> generateOncallSchedule(OncallMembers oncallMembers, Month month) {
        List<Member> schdule = new ArrayList<>();
        HolidayOncallMembers holidayOncallMembers = oncallMembers.getHolidayOncallMembers();
        WeekdayOncallMembers weekdayOncallMembers = oncallMembers.getWeekdayOncallMembers();
        for (int i = 1; i <= month.countDays(); ++i) {
            Date date = new Date(month, i);
            if (Holiday.isHolidays(date)) {
                addHolidaySchedule(schdule, holidayOncallMembers);
            } else {
                addWeekdaySchedule(schdule, weekdayOncallMembers);
            }
        }
        return schdule;
    }

    private void addHolidaySchedule(List<Member> schedule, HolidayOncallMembers holidayOncallMembers) {
        Member member = holidayOncallMembers.getCurrentTurnMember();
        if (isThirdOncall(schedule, member)) {
            holidayOncallMembers.forwardTurn();
            addHolidaySchedule(schedule, holidayOncallMembers);
            return;
        }
        if (schedule.get(schedule.size() - 1).equals(member)) {
            holidayOncallMembers.swap();
            addHolidaySchedule(schedule, holidayOncallMembers);
            return;
        }
        schedule.add(holidayOncallMembers.getCurrentTurnMember());
        holidayOncallMembers.forwardTurn();
    }

    private void addWeekdaySchedule(List<Member> schedule, WeekdayOncallMembers weekdayOncallMembers) {
        Member member = weekdayOncallMembers.getCurrentTurnMember();
        if (isThirdOncall(schedule, member)) {
            weekdayOncallMembers.forwardTurn();
            addWeekdaySchedule(schedule, weekdayOncallMembers);
            return;
        }
        if (schedule.get(schedule.size() - 1).equals(member)) {
            weekdayOncallMembers.swap();
            addWeekdaySchedule(schedule, weekdayOncallMembers);
            return;
        }
        schedule.add(weekdayOncallMembers.getCurrentTurnMember());
        weekdayOncallMembers.forwardTurn();
    }

    private boolean isThirdOncall(List<Member> schedule, Member member) {
        return schedule.stream().filter(scheduleMember -> scheduleMember.equals(member)).count() == 3;
    }
}
