package arrangement.model;

import java.util.List;

public abstract class MissionItem {
    protected final List<String> missionItem = List.of(
            "소고기", "돼지고기", "양고기", "콜라", "사이다",
            "삼다수", "상추", "깻잎", "배추", "사과", "키위", "파인애플");

    public abstract List<String> create();
}
