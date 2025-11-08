package arrangement.model;

public enum Category {
    MEAT("고기 종류"),
    DRINK("음료 종류"),
    VEGETABLE("야채 종류"),
    FRUIT("과일 종류");

    private final String koreanName;

    Category(String koreanName) {
        this.koreanName = koreanName;
    }

    @Override
    public String toString() {
        return koreanName;
    }
}
