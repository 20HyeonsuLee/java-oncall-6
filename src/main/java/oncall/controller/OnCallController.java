package oncall.controller;

import java.util.function.Supplier;
import oncall.exception.IllegalArgumentBaseException;
import oncall.model.Month;
import oncall.model.OncallMembers;
import oncall.service.OncallService;
import oncall.view.InputView;
import oncall.view.OutputView;

public class OnCallController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final OncallService oncallService = new OncallService();

    public void run() {
        Month month = handleInput(this::inputMonth);
        OncallMembers oncallMembers = handleInput(this::inputOncallMembers);
        outputView.printOncalSchedule(oncallService.generateSchedule(month, oncallMembers));
    }

    private Month inputMonth() {
        String monthInfo = inputView.inputMonth();
        return Parser.parseMonth(monthInfo);
    }

    private OncallMembers inputOncallMembers() {
        String weekdayOncallMembers = inputView.inputWeekdayMember();
        String holidayOncallMembers = inputView.inputHolidayMember();
        return new OncallMembers(
                Parser.parseWeekdayOncallMembers(weekdayOncallMembers),
                Parser.parseHolidayOncallMembers(holidayOncallMembers)
        );
    }

    private <T> T handleInput(Supplier<T> inputSupplier) {
        while (true) {
            try {
                return inputSupplier.get();
            } catch (IllegalArgumentBaseException exception) {
                outputView.printErrorMessage(exception.getMessage());
            }
        }
    }

    private void handleInput(Runnable runnable) {
        while (true) {
            try {
                runnable.run();
                return;
            } catch (IllegalArgumentBaseException exception) {
                outputView.printErrorMessage(exception.getMessage());
            }
        }
    }
}
