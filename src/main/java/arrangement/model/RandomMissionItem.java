package arrangement.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomMissionItem extends MissionItem {
    @Override
    public List<String> create() {
        List<String> randomMissionItem = new ArrayList<>(missionItem);
        Collections.shuffle(randomMissionItem);

        return randomMissionItem.subList(0, 5);
    }
}
