package arrangement.model;

import arrangement.constant.ErrorMessage;
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
            throw new IllegalArgumentException(ErrorMessage.OPTION_RANGE.getMessage());
        }
    }

    private int isDigit(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER.getMessage());
        }
    }

    public void isOverIncomeRange(int currentIncome) {
        if (currentIncome < 20_000) {
            throw new IllegalArgumentException(ErrorMessage.UNDER_INCOME.getMessage());
        }
    }

    public Category correctCategory(String category) {
        isNotBlank(category);
        Category categoryName = Category.includeCategory(category);

        if (categoryName == null) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CATEGORY.getMessage());
        }

        return categoryName;
    }

    private void isNotBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.NOT_BLANK.getMessage());
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
            throw new IllegalArgumentException(ErrorMessage.DASH_ONLY_ONE.getMessage());
        }
    }

    public void NotTypoItems(Category category, List<String> items) {
        for (String item : items) {
            if (!category.includeItem(item)) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_ITEM.getMessage());
            }
        }
    }
}
