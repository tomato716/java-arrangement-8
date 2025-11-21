package arrangement.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import arrangement.constants.Constants;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MissionMachineTest {
    private MissionMachine missionMachine;

    @BeforeEach
    void reset() {
        missionMachine = new MissionMachine(new FixedMissionItem());
        missionMachine.createMission();
    }

    @DisplayName("미션을 깊은 복사로 수정할 수 없는지 테스트")
    @Test
    void isCorrectCreateMission() {
        List<String> fixedMission = missionMachine.getMission();

        assertThatThrownBy(() -> fixedMission.add("콩나물"))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @DisplayName("미션이 다 해결되면 다시 생성되는지 테스트")
    @Test
    void createAgainMissionItems() {
        FixedMissionItem fixedMissionItem = new FixedMissionItem();
        List<String> ToBeRemovedItems = fixedMissionItem.create();

        for (String item : ToBeRemovedItems) {
            missionMachine.removeMissionItem(item);
        }

        assertThat(missionMachine.getMission()).hasSize(0);

        missionMachine.createMission();

        assertThat(missionMachine.getMission()).hasSize(Constants.MISSION_ITEM_SIZE);
    }

    @DisplayName("미션이 다 해결안되면  다시 생성 안되는지 테스트")
    @Test
    void ifNotSolvedDoNotCreate() {
        missionMachine.removeMissionItem("양고기");

        missionMachine.createMission();

        assertThat(missionMachine.getMission())
                .size()
                .isNotEqualTo(Constants.MISSION_ITEM_SIZE);
    }
}
