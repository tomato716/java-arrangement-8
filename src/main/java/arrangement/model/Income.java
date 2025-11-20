package arrangement.model;

import arrangement.constants.Constants;

public class Income {
    private int income;

    public void increase() {
        income += Constants.MISSION_INCOME;
    }

    public int getIncome() {
        return income;
    }
}
