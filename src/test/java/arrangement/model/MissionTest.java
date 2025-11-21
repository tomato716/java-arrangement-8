package arrangement.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MissionTest {
    private Mission mission;

    @BeforeEach
    void reset() {
        mission = new Mission(new FixedMissionItem());
        mission.createMission();
    }

    @DisplayName("미션을 깊은 복사로 수정할 수 없는지 테스트")
    @Test
    void isCorrectCreateMission() {
        List<String> fixedMission = mission.getMission();

        assertThatThrownBy(() -> fixedMission.add("콩나물"))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}
