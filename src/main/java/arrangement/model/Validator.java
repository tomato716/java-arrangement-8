package arrangement.model;

import arrangement.constants.Constants;
import arrangement.constants.ErrorMessage;
import java.util.List;

public class Validator {
    public int selectNumber(String input) {
        int number = isDigit(input);
        isCorrectNumberRange(number);

        return number;
    }

    private void isCorrectNumberRange(int number) {
        if (number < Constants.OPTION_NUMBER_MIN || number > Constants.OPTION_NUMBER_MAX) {
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

    public Category correctCategory(String inputCategory) {
        isNotBlank(inputCategory);
        Category categoryName = Category.includeCategory(inputCategory);

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
        String[] inputSplit = input.split(Constants.CATEGORY_ITEM_DELIMITER, -1);

        if (inputSplit.length != Constants.CATEGORY_ITEM_AREA) {
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
