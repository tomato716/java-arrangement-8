package arrangement.model.option;

import java.util.ArrayList;
import java.util.List;

public class OptionSelector {
    private final List<Option> selector = new ArrayList<>();

    public OptionSelector() {
        selector.add(new InventoryOption());
        selector.add(new MissionOption());
    }

    public Option select(int number) {
        return selector.get(number - 1);
    }
}
