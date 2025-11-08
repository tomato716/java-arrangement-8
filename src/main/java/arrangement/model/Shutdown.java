package arrangement.model;

public class Shutdown {
    private final Income income;
    private final GameState gameState;

    public Shutdown(Income income, GameState gameState) {
        this.income = income;
        this.gameState = gameState;
    }

    public void off() {
        if (income.getIncome() >= 20_000) {
            gameState.off();
        }
    }
}
