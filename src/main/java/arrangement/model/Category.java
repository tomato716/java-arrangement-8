package arrangement.model;

import java.util.List;

public enum Category {
    MEAT("🥩 고기 종류", List.of("소고기", "돼지고기", "양고기")),
    DRINK("🥤 음료 종류", List.of("콜라", "사이다", "삼다수")),
    VEGETABLE("🥬 야채 종류", List.of("상추", "깻잎", "배추")),
    FRUIT("🍎 과일 종류", List.of("사과", "키위", "파인애플"));

    private final String koreanName;
    private final List<String> items;

    Category(String koreanName, List<String> items) {
        this.koreanName = koreanName;
        this.items = items;
    }

    public static Category includeCategory(String category) {
        for (Category value : Category.values()) {
            if (category.equals(value.name())) {
                return value;
            }
        }
        return null;
    }

    public String getKoreanName() {
        return koreanName;
    }

    public List<String> getItems() {
        return items;
    }

    public boolean includeItem(String inputItem) {
        return items.contains(inputItem);
    }
}
