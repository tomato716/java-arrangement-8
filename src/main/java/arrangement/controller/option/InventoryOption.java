package arrangement.controller.option;

import arrangement.model.Category;
import arrangement.model.Inventory;
import java.util.Map;

public class InventoryOption implements Option {
    private final Inventory inventory;

    public InventoryOption(Inventory inventory) {
        this.inventory = inventory;
    }

    @Override
    public void play() {
        System.out.println("재고 보기");
        showInventory();

    }

    private void showInventory() {
        Map<Category, Map<String, Integer>> myInventory = inventory.getInventory();

        for (Category category : myInventory.keySet()) {
            System.out.print(category + ": ");
            showCategoryItem(myInventory.get(category));
            System.out.println();
        }
    }

    private void showCategoryItem(Map<String, Integer> categoryItem) {
        for (String value : categoryItem.keySet()) {
            System.out.print(value + " - " + categoryItem.get(value) + "개");
        }
    }


}
