package arrangement.view;

public class Output {

    public void printMission() {
        System.out.println("--- 미션 ---");
        System.out.println("재고를 정리하세요.");
        System.out.println("소고기 2, 돼지고기 3, 물 2, 술 5");
    }

    public void requestMeat() {
        System.out.print("Meat: ");
    }

    public void printStart() {
        System.out.println("번호를 선택해주세요.");
        System.out.println("1. 재고 보기");
        System.out.println("2. 미션 보기");
        System.out.println("3. 현재 금액 보기");
        System.out.println("4. 오늘 일과 종료");

    }
}
