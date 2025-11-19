package arrangement.controller.option;

import arrangement.model.Category;
import arrangement.model.Income;
import arrangement.model.Inventory;
import arrangement.model.Mission;
import arrangement.model.Validator;
import arrangement.view.Input;
import arrangement.view.Output;
import java.util.Arrays;
import java.util.List;

public class MissionOption implements Option {
    private final Mission mission;
    private final Inventory inventory;
    private final Income income;
    private final Validator validator;
    private final Output output;

    public MissionOption(Mission mission, Inventory inventory, Income income, Validator validator, Output output) {
        this.mission = mission;
        this.inventory = inventory;
        this.income = income;
        this.validator = validator;
        this.output = output;
    }

    @Override
    public void play() {
        output.printMissionHeader();
        mission.createMission();

        while (mission.itemCount() != 0) {
            try {
                output.printMission(mission.getMission());
                String input = Input.console();
                tryRemoveMission(input);
            } catch (IllegalArgumentException e) {
                output.printError(e);
            }
        }

        income.increase();
    }

    private void tryRemoveMission(String input) {
        List<String> categoryAndItems = splitCategoryAndItem(input);

        String inputCategory = StringUpperCase(categoryAndItems.getFirst());
        Category category = validator.correctCategory(inputCategory);

        List<String> items = splitInput(categoryAndItems.getLast(), ",");
        validator.itemsIsBlank(items);

        removeAndSaveItems(category, items);
    }

    private String StringUpperCase(String input) {
        return input.toUpperCase();
    }

    private void removeAndSaveItems(Category category, List<String> inputItems) {
        for (String item : inputItems) {
            validator.isIncludeItem(category, item);
            mission.removeMission(item);
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
        return splitInput(input, "-");
    }
}
