package arrangement.controller.option;

import arrangement.constants.Constants;
import arrangement.model.Category;
import arrangement.model.Income;
import arrangement.model.Inventory;
import arrangement.model.MissionMachine;
import arrangement.model.Validator;
import arrangement.view.Input;
import arrangement.view.Output;
import java.util.Arrays;
import java.util.List;

public class MissionOption implements Option {
    private final MissionMachine mission;
    private final Inventory inventory;
    private final Income income;
    private final Validator validator;
    private final Output output;

    public MissionOption(MissionMachine mission, Inventory inventory, Income income, Validator validator,
                         Output output) {
        this.mission = mission;
        this.inventory = inventory;
        this.income = income;
        this.validator = validator;
        this.output = output;
    }

    @Override
    public void play() {
        mission.createMission();

        while (mission.itemCount() != 0) {
            try {
                output.printMission(mission.getMission());
                tryRemoveMission(Input.console());
            } catch (IllegalArgumentException e) {
                output.printError(e);
            }
        }
        income.increase();
        output.printMissionComplete();
    }

    private void tryRemoveMission(String input) {
        validator.doNotStartDash(input);
        List<String> categoryAndItems = splitCategoryAndItem(input);

        Category category = validator.correctCategory(categoryAndItems.getFirst());

        List<String> items = splitInput(categoryAndItems.getLast(), Constants.ITEM_DELIMITER);
        validator.itemsIsBlank(items);
        validator.NotTypoItems(category, items);

        removeAndSaveItems(category, items);
    }

    private void removeAndSaveItems(Category category, List<String> inputItems) {
        for (String item : inputItems) {
            mission.removeMissionItem(item);
            inventory.addItem(category, item);
        }
    }

    private List<String> splitInput(String input, String delimiter) {
        return Arrays.stream(input.split(delimiter, -1))
                .map(String::strip)
                .toList();
    }

    private List<String> splitCategoryAndItem(String input) {
        validator.dashOnlyOne(input);
        return splitInput(input, Constants.CATEGORY_ITEM_DELIMITER);
    }
}
