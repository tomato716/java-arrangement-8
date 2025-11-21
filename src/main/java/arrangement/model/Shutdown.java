package arrangement.model;

import arrangement.constants.Constants;
import arrangement.constants.ErrorMessage;

public class Shutdown {
    private final Income income;
    private final GameState gameState;

    public Shutdown(Income income, GameState gameState) {
        this.income = income;
        this.gameState = gameState;
    }

    public void off() {
        validateOverIncomeRange(income);
        gameState.off();
    }

    private void validateOverIncomeRange(Income income) {
        if (income.getIncome() < Constants.TODAY_QUOTA) {
            throw new IllegalArgumentException(ErrorMessage.UNDER_INCOME.getMessage());
        }
    }
}
