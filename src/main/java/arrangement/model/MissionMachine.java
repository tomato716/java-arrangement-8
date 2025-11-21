package arrangement.model;

import arrangement.constants.ErrorMessage;
import java.util.ArrayList;
import java.util.List;

public class MissionMachine {
    private final MissionItemRule missionItemRule;
    private List<String> mission;


    public MissionMachine(MissionItemRule missionItem) {
        this.missionItemRule = missionItem;
    }

    public void createMission() {
        if (mission == null || mission.isEmpty()) {
            mission = new ArrayList<>(missionItemRule.create());
        }
    }

    public List<String> getMission() {
        return List.copyOf(mission);
    }

    public void removeMissionItem(String input) {
        validate(input);
        mission.remove(input);
    }

    private void validate(String input) {
        if (!mission.contains(input)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_INCLUDE_MISSION.getMessage());
        }
    }

    public int itemCount() {
        return mission.size();
    }
}
