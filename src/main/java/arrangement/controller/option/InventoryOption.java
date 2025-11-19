package arrangement.controller.option;

import arrangement.model.Inventory;
import arrangement.view.Output;

public class InventoryOption implements Option {
    private final Inventory inventory;
    private final Output output;

    public InventoryOption(Inventory inventory, Output output) {
        this.inventory = inventory;
        this.output = output;
    }

    @Override
    public void play() {
        output.printInventory(inventory.getProducts());
    }
}
