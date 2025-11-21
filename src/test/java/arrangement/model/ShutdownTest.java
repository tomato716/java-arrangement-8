package arrangement.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ShutdownTest {
    private Income income;
    private GameState gameState;
    private Validator validator;
    private Shutdown shutdown;

    @BeforeEach
    void reset() {
        income = new Income();
        gameState = new GameState();
        validator = new Validator();

        shutdown = new Shutdown(income, gameState, validator);
    }

    @DisplayName("소득이 20,000원 이상이면 종료되는지 테스트")
    @Test
    void isCorrectGameShutdown() {
        for (int i = 0; i < 2; i++) {
            income.increase();
        }

        shutdown.off();

        assertThat(gameState.getState()).isFalse();
    }
}
