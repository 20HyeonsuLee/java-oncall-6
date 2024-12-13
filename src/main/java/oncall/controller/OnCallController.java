package oncall.controller;

import java.util.function.Supplier;
import oncall.exception.IllegalArgumentBaseException;
import oncall.view.InputView;
import oncall.view.OutputView;

public class OnCallController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {

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
