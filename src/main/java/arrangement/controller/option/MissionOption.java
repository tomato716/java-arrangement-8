package arrangement.controller.option;

import arrangement.model.Mission;
import arrangement.model.Validator;
import arrangement.view.Input;

public class MissionOption implements Option {
    private final Mission mission;
    private final Validator validator;

    public MissionOption(Mission mission, Validator validator) {
        this.mission = mission;
        this.validator = validator;
    }

    @Override
    public void play() {
        System.out.println("--- 미션 ---");

        removeMission();
    }

    private void removeMission() {
        while (mission.size() != 0) {
        while (mission.itemCount() != 0) {
            try {
                mission.showMission();
                System.out.println("카테고리 별로 정리하세요.");
                System.out.println("입력은 {카테고리} - {정리할 물품},{정리할 물품}으로 입력해주세요.");
                String input = Input.console();
                String[] strings = validator.splitCategoryItem(input);
                mission.removeMission(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
