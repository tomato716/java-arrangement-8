package arrangement.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameStateTest {
    private GameState gameState;

    @BeforeEach
    void resetObject() {
        gameState = new GameState();
    }

    @DisplayName("종료 메시지를 보내면 올바르게 종료하는지 테스트")
    @Test
    void isCorrectFinish() {
        gameState.off();

        assertThat(gameState.getState()).isFalse();
    }

    @DisplayName("게임 생명 주기가 생성되면 게임 진행 가능한 상태인지 테스트")
    @Test
    void isCorrectGameStart() {
        assertThat(gameState.getState()).isTrue();
    }
}
