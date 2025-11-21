package arrangement.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
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

    @DisplayName("재고를 생성하면 0으로 초기화되어 생성하는지 테스트")
    @ParameterizedTest
    @CsvSource(value = {
            "MEAT,양고기", "MEAT,소고기", "MEAT,돼지고기",
            "DRINK,삼다수", "DRINK,사이다", "DRINK,콜라",
            "FRUIT,파인애플", "FRUIT,사과", "FRUIT,키위",
            "VEGETABLE,배추", "VEGETABLE,상추", "VEGETABLE,깻잎"
    })
    void initialInventoryItems(Category category, String koreanName) {
        Map<Category, Map<String, Integer>> products = inventory.getProducts();

        assertThat(products.get(category))
                .containsOnlyKeys(category.getItems())
                .containsEntry(koreanName, 0);
    }

    @DisplayName("재고에 아이템이 넣어지는지 테스트")
    @Test
    void isCorrectAddItem() {
        for (int i = 0; i < 5; i++) {
            inventory.addItem(Category.MEAT, "소고기");
        }

        Map<Category, Map<String, Integer>> products = inventory.getProducts();

        assertThat(products.get(Category.MEAT))
                .containsEntry("소고기", 5);
    }
}
