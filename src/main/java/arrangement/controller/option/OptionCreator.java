package arrangement.controller.option;

import arrangement.model.GameState;
import arrangement.model.Income;
import arrangement.model.Inventory;
import arrangement.model.MissionItemRule;
import arrangement.model.MissionMachine;
import arrangement.model.Shutdown;
import arrangement.model.Validator;
import arrangement.view.Output;
import java.util.List;

public class OptionCreator {
    private final GameState gameState;
    private final Income income;
    private final Validator validator;
    private final MissionItemRule missionItem;
    private final Output output;

    public OptionCreator(
            GameState gameState,
            Income income,
            Validator validator,
            MissionItemRule missionItem,
            Output output) {
        this.gameState = gameState;
        this.income = income;
        this.validator = validator;
        this.missionItem = missionItem;
        this.output = output;
    }

    public List<Option> createOptions() {
        Inventory inventory = new Inventory();

        return List.of(
                new InventoryOption(inventory, output),
                new MissionOption(new MissionMachine(missionItem), inventory, income, validator, output),
                new IncomeOption(income, output),
                new ShutdownOption(new Shutdown(income, gameState, validator), output, income)
        );
    }
}
