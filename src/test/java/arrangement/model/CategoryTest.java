package arrangement.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CategoryTest {

    @DisplayName("카테고리를 입력했을때 올바르게 값이 나오는지 테스트")
    @ParameterizedTest
    @CsvSource(value = {"MEAT,MEAT", "DRINK,DRINK", "VEGETABLE,VEGETABLE", "FRUIT,FRUIT"})
    void isCorrectCategoryNames(String inputCategory, Category result) {
        Category resultCategory = Category.includeCategory(inputCategory);

        assertThat(resultCategory).isEqualTo(result);
    }
}
