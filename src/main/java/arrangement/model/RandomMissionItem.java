package arrangement.model;

import arrangement.constants.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomMissionItem extends MissionItem {
    @Override
    public List<String> create() {
        List<String> randomMissionItem = new ArrayList<>(missionItem);
        Collections.shuffle(randomMissionItem);

        return randomMissionItem.subList(0, Constants.NUMBER_OF_MISSION_ITEM);
    }
}
