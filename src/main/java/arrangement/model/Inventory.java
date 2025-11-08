package arrangement.model;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private final Map<Category, Map<String, Integer>> inventory = new EnumMap<>(Category.class);

    public Inventory() {
        createInventory();
    }

    private void createInventory() {
        for (Category category : Category.values()) {
            inventory.put(category, new HashMap<>());
        }
    }

    public Map<Category, Map<String, Integer>> getInventory() {
        return inventory;
    }
}
