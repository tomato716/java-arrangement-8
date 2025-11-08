package arrangement.model.option;

import arrangement.model.Category;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class InventoryOption implements Option {
    private final Map<Category, Map<String, Integer>> inventory = new EnumMap<>(Category.class);

    public InventoryOption() {
        createInventory();
    }

    private void createInventory() {
        for (Category category : Category.values()) {
            inventory.put(category, new HashMap<>());
        }
    }

    @Override
    public void play() {
        System.out.println("재고 보기");
        showInventory();

    }

    private void showInventory() {
        for (Category category : inventory.keySet()) {
            System.out.print(category + ": ");
            showCategoryItem(inventory.get(category));
            System.out.println();
        }
    }

    private void showCategoryItem(Map<String, Integer> categoryItem) {
        for (String value : categoryItem.keySet()) {
            System.out.print(value + " - " + categoryItem.get(value) + "개");
        }
    }


}
