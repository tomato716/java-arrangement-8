package arrangement.view;

import arrangement.model.Category;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Output {
    public void printStart() {
        System.out.println("번호를 선택해주세요.");
        System.out.println("1. 재고 보기");
        System.out.println("2. 미션 보기");
        System.out.println("3. 현재 금액 보기");
        System.out.println("4. 오늘 일과 종료");

    }

    public void printMission(List<String> mission) {
        System.out.println("--- 미션 ---");
        System.out.println(mission);
        System.out.println("카테고리 별로 정리하세요.");
        System.out.println("입력은 {카테고리} - {아이템},{아이템}으로 입력해주세요.");
    }

    public void printError(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }

    public void printInventory(Map<Category, Map<String, Integer>> products) {
        System.out.println("--- 현재 재고 ---");

        for (Category category : products.keySet()) {
            System.out.print(category.getKoreanName() + " : ");
            System.out.println(printCategoryItems(products.get(category)));
        }
        System.out.println();
    }

    private String printCategoryItems(Map<String, Integer> categoryItems) {
        List<String> items = new ArrayList<>();

        for (String itemName : categoryItems.keySet()) {
            items.add(itemName + "-" + categoryItems.get(itemName) + "개");
        }

        return String.join(", ", items);
    }

    public void printCurrentIncome(int currentIncome) {
        System.out.println("--- 현재 수입 ---");
        System.out.printf("%,d원\n", currentIncome);
    }
}
