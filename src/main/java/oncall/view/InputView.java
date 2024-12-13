package oncall.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String inputMonth() {
        InputMessage.INPUT_MONTH.print();
        return Console.readLine();
    }

    public String inputWeekdayMember() {
        InputMessage.INPUT_WEEKDAY_MEMBER.print();
        return Console.readLine();
    }

    public String inputHolidayMember() {
        InputMessage.INPUT_HOLIDAY_MEMBER.print();
        return Console.readLine();
    }
}
