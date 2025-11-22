package arrangement.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
}
