package arrangement.controller.option;

import arrangement.model.Income;
import arrangement.view.Output;

public class IncomeOption implements Option {
    private final Income income;
    private final Output output;

    public IncomeOption(Income income, Output output) {
        this.income = income;
        this.output = output;
    }

    @Override
    public void play() {
        output.printCurrentIncome(income);
    }
}
