package arrangement.model;

public class Income {
    private static final int DAILY_WAGE = 10_000;
    private int income;

    public void increase() {
        income += DAILY_WAGE;
    }

    public int getIncome() {
        return income;
    }
}
