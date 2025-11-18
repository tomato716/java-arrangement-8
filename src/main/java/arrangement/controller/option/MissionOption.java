package arrangement.controller.option;

import arrangement.model.Category;
import arrangement.model.Income;
import arrangement.model.Inventory;
import arrangement.model.Mission;
import arrangement.view.Input;
import java.util.Arrays;
import java.util.List;

public class MissionOption implements Option {
    private final Mission mission;
    private final Inventory inventory;
    private final Income income;

    public MissionOption(Mission mission, Inventory inventory, Income income) {
        this.mission = mission;
        this.inventory = inventory;
        this.income = income;
    }

    @Override
    public void play() {
        System.out.println("--- 미션 ---");
        mission.createMission();

        while (mission.itemCount() != 0) {
            try {
                mission.showMission();
                System.out.println("카테고리 별로 정리하세요.");
                System.out.println("입력은 {카테고리} - {정리할 물품},{정리할 물품}으로 입력해주세요.");
                String input = Input.console();
                tryRemoveMission(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        income.increase();
    }

    private void tryRemoveMission(String input) {
        List<String> categoryAndItems = splitCategoryItem(input);

        String inputCategory = StringUpperCase(categoryAndItems.getFirst());
        Category category = validateCategory(inputCategory);
        List<String> items = splitInput(categoryAndItems.getLast(), ",");
        validateRemoveItems(category, items);
    }

    private String StringUpperCase(String input) {
        return input.toUpperCase();
    }

    private void validateRemoveItems(Category category, List<String> inputItems) {
        for (String item : inputItems) {
            if (!category.includeItem(item)) {
                throw new IllegalArgumentException("[ERROR] 아이템을 잘못 입력했습니다.");
            }
            mission.removeMission(item);
            inventory.addItem(category, item);
        }
    }

    private List<String> splitInput(String input, String delimiter) {
        return Arrays.stream(input.split(delimiter, -1))
                .map(String::strip)
                .toList();
    }

    private Category validateCategory(String category) {
        Category name = Category.includeCategory(category);

        if (name == null) {
            throw new IllegalArgumentException("[ERROR] 카테고리는 MEAT, DRINK, VEGETABLE, FRUIT만 입력 가능합니다.");
        }

        return name;
    }

    private List<String> splitCategoryItem(String input) {
        isHaveDash(input);
        return splitInput(input, "-");
    }

    private void isHaveDash(String input) {
        if (!input.contains("-")) {
            throw new IllegalArgumentException("[ERROR] 잘못입력하셨습니다.");
        }
    }
}
