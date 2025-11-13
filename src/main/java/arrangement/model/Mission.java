package arrangement.model;

import java.util.ArrayList;
import java.util.List;

public class Mission {
    private final List<String> mission = new ArrayList<>();

    public Mission() {
        mission.add("소고기");
        mission.add("콜라");
        mission.add("상추");
        mission.add("사이다");
        mission.add("사과");
        mission.add("돼지고기");
        mission.add("깻잎");
        mission.add("키위");
        mission.add("파인애플");
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
