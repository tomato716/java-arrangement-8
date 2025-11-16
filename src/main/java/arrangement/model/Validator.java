package arrangement.model;

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
}
