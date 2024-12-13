package oncall.view;

import static oncall.view.OutputMessage.OUTPUT_SCHEDULE;

import oncall.dto.OncallScheduleDto;

public class OutputView {

    public void printErrorMessage(String message) {
        System.out.println(message);
    }

    public void printOncalSchedule(OncallScheduleDto oncallScheduleDto) {
        StringBuilderPrinter stringBuilder = new StringBuilderPrinter();
        oncallScheduleDto.scheduleDtos().forEach(innerScheduleDto -> {
            stringBuilder.appendLine(OUTPUT_SCHEDULE.format(
                    innerScheduleDto.month(),
                    innerScheduleDto.day(),
                    innerScheduleDto.dayOfWeek(),
                    innerScheduleDto.memberName()
            ));
        });
        stringBuilder.print();
    }
}
