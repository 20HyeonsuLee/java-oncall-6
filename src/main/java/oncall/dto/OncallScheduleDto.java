package oncall.dto;

import java.util.List;
import java.util.Map;
import oncall.model.Date;
import oncall.model.Holiday;
import oncall.model.Member;

public record OncallScheduleDto(
        List<InnerScheduleDto> scheduleDtos
) {
    public static OncallScheduleDto from(Map<Date, Member> schedule) {
        return new OncallScheduleDto(schedule.entrySet().stream()
                        .map(dateMemberEntry -> InnerScheduleDto.from(dateMemberEntry.getKey(), dateMemberEntry.getValue()))
                        .toList()
        );
    }

    public record InnerScheduleDto(
            int month,
            int day,
            String dayOfWeek,
            String memberName
    ) {
        public static InnerScheduleDto from(Date date, Member member) {
            String dayOfWeek = date.getDayOfWeek().getDayOfWeekInKorean();
            if (Holiday.isPublicHolidays(date)) {
                dayOfWeek += "(휴일)";
            }
            return new InnerScheduleDto(
                    date.getMonth().getMonth(),
                    date.getDay(),
                    dayOfWeek,
                    member.getName()
            );
        }
    }
}
