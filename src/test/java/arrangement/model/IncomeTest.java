package arrangement.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class IncomeTest {
    private Income income;

    @BeforeEach
    void reset() {
        income = new Income();
    }

    @DisplayName("소득이 10,000원 단위로 잘 증가하는지 테스트")
    @Test
    void isCorrectIncomeIncrease() {
        income.increase();

        assertThat(income.getIncome()).isEqualTo(10_000);
    }
}
