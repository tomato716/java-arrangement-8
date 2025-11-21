package arrangement.model;

import java.util.List;

public class FixedMissionItem extends MissionItemRule {

    @Override
    public List<String> create() {

        return List.of("양고기", "돼지고기", "소고기", "사과", "키위");
    }
}
