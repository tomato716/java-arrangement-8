package arrangement.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CategoryTest {

    @DisplayName("카테고리를 입력했을때 올바르게 값이 나오는지 테스트")
    @ParameterizedTest
    @CsvSource(value = {"MEAT,MEAT", "DRINK,DRINK", "VEGETABLE,VEGETABLE", "FRUIT,FRUIT"})
    void isCorrectCategoryNames(String inputCategory, Category result) {
        Category resultCategory = Category.includeCategory(inputCategory);

        assertThat(resultCategory).isEqualTo(result);
    }

    @DisplayName("카테고리에 없는 값을 입력하면 null이 나오는지 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"MMM", "EEE", "AAA", "TTT"})
    void isNotCorrectCategoryNames(String inputCategory) {
        Category resultCategory = Category.includeCategory(inputCategory);

        assertThat(resultCategory).isNull();
    }

    @DisplayName("카테고리에 존재하는 아이템을 입력했을때 true가 나오는지 테스트")
    @ParameterizedTest
    @CsvSource(value = {
            "MEAT, 소고기", "MEAT, 양고기", "MEAT, 돼지고기",
            "DRINK, 삼다수", "DRINK, 사이다", "DRINK, 콜라",
            "VEGETABLE, 깻잎", "VEGETABLE, 상추", "VEGETABLE, 배추",
            "FRUIT, 파인애플", "FRUIT, 사과", "FRUIT, 키위"
    })
    void isCorrectItemsToCategory(Category category, String inputItem) {
        boolean itemResult = category.includeItem(inputItem);

        assertThat(itemResult).isTrue();
    }

    @DisplayName("카테고리에 존재하지 않는 아이템을 입력했을때 false가 나오는지 테스트")
    @ParameterizedTest
    @CsvSource(value = {
            "MEAT, 삼다수", "MEAT, 사이다", "MEAT, abc",
            "DRINK, 깻잎", "DRINK, 상추", "DRINK, def",
            "VEGETABLE, 사과", "VEGETABLE, 키위", "VEGETABLE, ghi",
            "FRUIT, 소고기", "FRUIT, 양고기", "FRUIT, jkl"
    })
    void isNotCorrectItemsToCategory(Category category, String inputItem) {
        boolean itemResult = category.includeItem(inputItem);

        assertThat(itemResult).isFalse();
    }
}
