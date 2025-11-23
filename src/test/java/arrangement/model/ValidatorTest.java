package arrangement.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import arrangement.constants.ErrorMessage;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class ValidatorTest {
    private Validator validator;

    @BeforeEach
    void reset() {
        validator = new Validator();
    }

    @DisplayName("옵션으로 1~4범위의 숫자 문자열을 입력했을때 숫자로 바뀌는지 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1,1", "2,2", "3,3", "4,4"})
    void isCorrectStringToInteger(String inputOptionNumber, int expectResult) {
        int optionNumberResult = validator.selectNumber(inputOptionNumber);

        assertThat(optionNumberResult).isEqualTo(expectResult);
    }

    @DisplayName("옵션으로 숫자가 아닌 값을 입력했을 때 예외 발생 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"a", "as", "bfd", "banana"})
    void isNotInteger(String inputOptionNumber) {
        assertThatThrownBy(() -> validator.selectNumber(inputOptionNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_NUMBER.getMessage());
    }

    @DisplayName("옵션으로 숫자가 아닌 값을 입력했을 때 예외 발생 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "5", "6"})
    void isOverOptionNumberRange(String inputOptionNumber) {
        assertThatThrownBy(() -> validator.selectNumber(inputOptionNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.OPTION_RANGE.getMessage());
    }

    @DisplayName("입력값이 카테고리가 아닐 경우 예외 발생 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"AAA", "123", "ccc", "가나다"})
    void isNotInputCategory(String inputCategory) {
        assertThatThrownBy(() -> validator.correctCategory(inputCategory))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_CATEGORY.getMessage());
    }

    @DisplayName("올바른 카테고리를 입력할 경우 동작하는지 테스트")
    @ParameterizedTest
    @CsvSource(value = {"MEAT,MEAT", "VEGETABLE,VEGETABLE", "FRUIT,FRUIT", "DRINK,DRINK"})
    void isCorrectInputCategoryName(String inputCategory, Category category) {
        Category categoryResult = validator.correctCategory(inputCategory);

        assertThat(categoryResult).isEqualTo(category);
    }

    @DisplayName("카테고리 입력값이 소문자일 경우 올바르게 동작하는지 테스트")
    @ParameterizedTest
    @CsvSource(value = {"meat,MEAT", "vegetable,VEGETABLE", "fruit,FRUIT", "drink,DRINK"})
    void ChangeUpperCase(String inputCategory, Category category) {
        Category categoryResult = validator.correctCategory(inputCategory);

        assertThat(categoryResult).isEqualTo(category);
    }

    @DisplayName("빈값이나 공백을 입력 할 경우 예외 발생 테스트")
    @ParameterizedTest
    @ValueSource(strings = {" ", ""})
    void canNotBlankInputCategory(String inputCategory) {
        assertThatThrownBy(() -> validator.correctCategory(inputCategory))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_BLANK.getMessage());
    }

    @DisplayName("아이템 목록 중 공백이나 빈값을 넣을 경우 예외 발생 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "        "})
    void canNotBlankInputItems(String inputItems) {

        assertThatThrownBy(() -> validator.itemsIsBlank(List.of(inputItems)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_BLANK.getMessage());
    }

    @DisplayName("카테고리와 아이템들을 입력할 때 -(대쉬)가 하나가 아니라면 예외 발생 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"MEAT -- 소고기", "MEAT : 소고기", "MEAT - 소고기 - 돼지고기"})
    void mustOnlyDashOne(String inputCategoryAndItems) {
        assertThatThrownBy(() -> validator.dashOnlyOne(inputCategoryAndItems))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.DASH_ONLY_ONE.getMessage());
    }

    @DisplayName("카테고리에 없는 아이템을 입력하면 예외 발생 테스트")
    @ParameterizedTest
    @CsvSource(value = {"MEAT,상추", "VEGETABLE,돼지고기", "DRINK,사과", "FRUIT,콜라", "MEAT,가나다"})
    void isNotIncludeItemsInCategory(Category category, String items) {

        assertThatThrownBy(() -> validator.NotTypoItems(category, List.of(items)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("미션 입력 형식이 -(대쉬)로 시작할 경우 예외 발생 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"-MEAT", "-VEGETABLE", "-FRUIT", "-DRINK"})
    void mustNotStartMissionInputFormDash(String input) {
        assertThatThrownBy(() -> validator.doNotStartDash(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_FORM.getMessage());
    }
}
