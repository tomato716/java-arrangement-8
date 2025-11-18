package arrangement.model;

public class Shutdown {
    private final Income income;
    private final GameState gameState;

    public Shutdown(Income income, GameState gameState) {
        this.income = income;
        this.gameState = gameState;
    }

    public void off() {
        if (income.getIncome() < 20_000) {
            throw new IllegalArgumentException("[ERROR] 하루 일당은 총 20,000원을 채워야합니다.");
        }

        gameState.off();
    }
}
