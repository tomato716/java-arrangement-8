package arrangement.model;

import arrangement.constants.Constants;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private final Map<Category, Map<String, Integer>> products = new EnumMap<>(Category.class);

    public Inventory() {
        createProducts();
    }

    private void createProducts() {
        for (Category category : Category.values()) {
            products.put(category, createItem(category));
        }
    }

    private Map<String, Integer> createItem(Category category) {
        Map<String, Integer> items = new HashMap<>();

        for (String item : category.getItems()) {
            items.put(item, Constants.ITEM_COUNT_INITIAL);
        }

        return items;
    }


    public Map<Category, Map<String, Integer>> getProducts() {
        Map<Category, Map<String, Integer>> copyInventory = new EnumMap<>(Category.class);

        for (Category category : products.keySet()) {
            copyInventory.put(category, getItems(category));
        }

        return Map.copyOf(copyInventory);
    }

    private Map<String, Integer> getItems(Category category) {
        return Map.copyOf(products.get(category));
    }

    public void addItem(Category category, String item) {
        Map<String, Integer> categoryItems = products.get(category);
        categoryItems.merge(item, Constants.ITEM_COUNT_INCREASE, Integer::sum);
    }
}
