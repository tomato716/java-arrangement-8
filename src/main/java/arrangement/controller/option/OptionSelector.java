package arrangement.controller.option;

import arrangement.model.GameState;
import arrangement.model.Income;
import arrangement.model.Inventory;
import arrangement.model.Mission;
import arrangement.model.MissionItem;
import arrangement.model.Shutdown;
import arrangement.model.Validator;
import arrangement.view.Input;
import arrangement.view.Output;
import java.util.ArrayList;
import java.util.List;

public class OptionSelector {
    private final List<Option> selector = new ArrayList<>();
    private final GameState gameState;
    private final Income income;
    private final Validator validator;
    private final MissionItem missionItem;
    private final Output output;

    public OptionSelector(GameState gameState, Income income, Validator validator, MissionItem missionItem,
                          Output output) {
        this.gameState = gameState;
        this.income = income;
        this.validator = validator;
        this.missionItem = missionItem;
        this.output = output;
        createOption();
    }

    private void createOption() {
        Inventory inventory = new Inventory();
        selector.add(new InventoryOption(inventory));
        selector.add(new MissionOption(new Mission(missionItem), inventory, income));
        selector.add(new IncomeOption(income));
        selector.add(new ShutdownOption(new Shutdown(income, gameState)));
    }

    private Option select(int number) {
        return selector.get(number - 1);
    }

    public Option askOption() {
        while (true) {
            try {
                output.printStart();
                String input = Input.console();
                int optionNumber = validator.selectNumber(input);
                return select(optionNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
