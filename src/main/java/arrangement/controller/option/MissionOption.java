package arrangement.controller.option;

import arrangement.model.Mission;
import arrangement.view.Input;

public class MissionOption implements Option {
    private final Mission mission;

    public MissionOption(Mission mission) {
        this.mission = mission;
    }

    @Override
    public void play() {
        System.out.println("--- 미션 ---");

        removeMission();
    }

    private void removeMission() {
        while (mission.size() != 0) {
            try {
                mission.showMission();
                System.out.println("카테고리 별로 정리하세요.");
                String input = Input.console();
                mission.removeMission(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
