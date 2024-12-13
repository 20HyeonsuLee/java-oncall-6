package oncall.service;

import java.util.Map;
import oncall.dto.OncallScheduleDto;
import oncall.model.Date;
import oncall.model.Member;
import oncall.model.Month;
import oncall.model.OncallMembers;
import oncall.model.OncallScheduleGenerator;

public class OncallService {

    private final OncallScheduleGenerator oncallScheduleGenerator = new OncallScheduleGenerator();

    public OncallScheduleDto generateSchedule(Month month, OncallMembers oncallMembers) {
        Map<Date, Member> schedule = oncallScheduleGenerator.generateOncallSchedule(oncallMembers, month);
        return OncallScheduleDto.from(schedule);
    }
}
