package arrangement.controller.option;

import arrangement.model.Income;

public class IncomeOption implements Option {
    private final Income income;

    public IncomeOption(Income income) {
        this.income = income;
    }

    @Override
    public void play() {
        System.out.println("--- 현재 수입 ---");
        System.out.println(String.format("%,d원", income.getIncome()));
    }
}
