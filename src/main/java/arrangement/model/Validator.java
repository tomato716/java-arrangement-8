package arrangement.model;

import java.util.List;

public class Validator {
    private static final int NUMBER_START = 1;
    private static final int NUMBER_END = 4;

    public int selectNumber(String input) {
        int number = isDigit(input);
        isCorrectNumberRange(number);

        return number;
    }

    private void isCorrectNumberRange(int number) {
        if (number < NUMBER_START || number > NUMBER_END) {
            throw new IllegalArgumentException("[ERROR] 잘못된 번호입니다.");
        }
    }

    private int isDigit(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력하세요.");
        }
    }

    public void isOverIncomeRange(int currentIncome) {
        if (currentIncome < 20_000) {
            throw new IllegalArgumentException("[ERROR] 하루 일당은 총 20,000원을 채워야합니다.");
        }
    }

    public Category correctCategory(String category) {
        isNotBlank(category);
        Category name = Category.includeCategory(category);

        if (name == null) {
            throw new IllegalArgumentException("[ERROR] 카테고리는 MEAT, DRINK, VEGETABLE, FRUIT만 입력 가능합니다.");
        }

        return name;
    }

    private void isNotBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 공백이나 빈값은 입력할 수 없습니다.");
        }
    }

    public void isIncludeItem(Category category, String item) {
        if (!category.includeItem(item)) {
            throw new IllegalArgumentException("[ERROR] 아이템을 잘못 입력했습니다.");
        }
    }

    public void itemsIsBlank(List<String> inputItems) {
        for (String inputItem : inputItems) {
            isNotBlank(inputItem);
        }
    }

    public void dashOnlyOne(String input) {
        long count = input.chars()
                .filter(c -> c == '-')
                .count();

        if (count != 1) {
            throw new IllegalArgumentException("[ERROR] 카테고리와 아이템은 -(대쉬) 하나로 구분하여 입력하세요.");
        }
    }
}
