package arrangement.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InventoryTest {
    private Inventory inventory;

    @BeforeEach
    void reset() {
        inventory = new Inventory();
    }

    @DisplayName("재고를 생성하면 key로 카테고리를 생성하는지 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"MEAT", "DRINK", "VEGETABLE", "FRUIT"})
    void isHaveCategory(Category category) {
        Map<Category, Map<String, Integer>> products = inventory.getProducts();

        assertThat(products)
                .hasSize(4)
                .isNotEmpty()
                .containsKey(category);
    }
}
