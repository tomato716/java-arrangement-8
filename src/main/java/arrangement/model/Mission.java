package arrangement.model;

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

    public void showMission() {
        System.out.println(mission);
    }

    public void removeMission(String input) {
        validate(input);
        mission.remove(input);
    }

    private void validate(String input) {
        if (!mission.contains(input)) {
            throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다.");
        }
    }

    public int itemCount() {
        return mission.size();
    }
}
