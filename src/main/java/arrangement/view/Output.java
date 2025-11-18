package arrangement.view;

import java.util.List;

public class Output {
    public void printStart() {
        System.out.println("번호를 선택해주세요.");
        System.out.println("1. 재고 보기");
        System.out.println("2. 미션 보기");
        System.out.println("3. 현재 금액 보기");
        System.out.println("4. 오늘 일과 종료");

    }

    public void missionHeader() {
        System.out.println("--- 미션 ---");
    }

    public void printMission(List<String> mission) {
        System.out.println(mission);
        System.out.println("카테고리 별로 정리하세요.");
        System.out.println("입력은 {카테고리} - {아이템},{아이템}으로 입력해주세요.");
    }

    public void printError(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
}
