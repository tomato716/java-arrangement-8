package arrangement.model;

public class Shutdown {
    private final Income income;
    private final GameState gameState;
    private final Validator validator;

    public Shutdown(Income income, GameState gameState, Validator validator) {
        this.income = income;
        this.gameState = gameState;
        this.validator = validator;
    }

    public void off() {
        validator.isOverIncomeRange(income.getIncome());
        gameState.off();
    }
}
