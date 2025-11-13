package arrangement.controller.option;

import arrangement.model.GameState;
import arrangement.model.Income;
import arrangement.model.Inventory;
import arrangement.model.Mission;
import arrangement.model.MissionItem;
import arrangement.model.Shutdown;
import arrangement.model.Validator;
import java.util.ArrayList;
import java.util.List;

public class OptionSelector {
    private final List<Option> selector = new ArrayList<>();

    public OptionSelector(GameState gameState, Income income, Validator validator, MissionItem missionItem) {
        selector.add(new InventoryOption(new Inventory()));
        selector.add(new MissionOption(new Mission(missionItem), validator));
        selector.add(new IncomeOption(income));
        selector.add(new ShutdownOption(new Shutdown(income, gameState)));
    }

    public Option select(int number) {
        return selector.get(number - 1);
    }
}
