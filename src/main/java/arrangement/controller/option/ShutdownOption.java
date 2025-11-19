package arrangement.controller.option;

import arrangement.model.Income;
import arrangement.model.Shutdown;
import arrangement.view.Output;

public class ShutdownOption implements Option {
    private final Shutdown shutdown;
    private final Output output;
    private final Income income;

    public ShutdownOption(Shutdown shutdown, Output output, Income income) {
        this.shutdown = shutdown;
        this.output = output;
        this.income = income;
    }

    @Override
    public void play() {
        try {
            shutdown.off();
            output.printShutdown(income);
        } catch (IllegalArgumentException e) {
            output.printError(e);
        }
    }
}
