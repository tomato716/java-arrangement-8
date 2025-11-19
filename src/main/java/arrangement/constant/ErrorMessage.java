package arrangement.constant;

public enum ErrorMessage {
    OPTION_RANGE("옵션은 1~4까지만 입력할 수 있습니다."),
    NOT_NUMBER("숫자만 입력 가능합니다."),
    UNDER_INCOME("종료하기 위한 소득이 부족합니다."),
    INVALID_CATEGORY("카테고리는 MEAT, DRINK, VEGETABLE, FRUIT만 입력 가능합니다."),
    NOT_BLANK("공백이나 빈값은 입력할 수 없습니다."),
    INVALID_ITEM("아이템을 잘못 입력했습니다."),
    DASH_ONLY_ONE("카테고리와 아이템은 -(대쉬) 하나로 구분하여 입력하세요."),
    NOT_INCLUDE_MISSION("미션에 존재하지 않는 아이템을 입력했습니다.");

    private static final String PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX + message;
    }
}
