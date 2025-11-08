package arrangement.controller.option;

import arrangement.model.Income;
import arrangement.model.Inventory;
import arrangement.model.Mission;
import java.util.ArrayList;
import java.util.List;

public class OptionSelector {
    private final List<Option> selector = new ArrayList<>();

    public OptionSelector() {
        selector.add(new InventoryOption(new Inventory()));
        selector.add(new MissionOption(new Mission()));
        selector.add(new IncomeOption(new Income()));
    }

    public Option select(int number) {
        return selector.get(number - 1);
    }
}
