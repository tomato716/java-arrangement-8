package arrangement.model;

import arrangement.constant.ErrorMessage;
import java.util.ArrayList;
import java.util.List;

public class Mission {
    private final MissionItem missionItem;
    private List<String> mission;


    public Mission(MissionItem missionItem) {
        this.missionItem = missionItem;
    }

    public void createMission() {
        if (mission == null || mission.isEmpty()) {
            mission = new ArrayList<>(missionItem.create());
        }
    }

    public List<String> getMission() {
        return List.copyOf(mission);
    }

    public void removeMission(String input) {
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
