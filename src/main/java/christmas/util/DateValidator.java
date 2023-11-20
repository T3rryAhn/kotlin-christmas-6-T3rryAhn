package christmas.util;

public class DateValidator {
    private static final String INVALID_DATE_MESSAGE = "유효하지 않은 날짜입니다. 다시 입력해 주세요.";

    public static void validateInput(String input) {
        validateNumeric(input);
        int date = Integer.parseInt(input);
        validateDate(date);
    }

    private static void validateNumeric(String input) {
        if (input == null) {
            throw new ValidationException(INVALID_DATE_MESSAGE);
        }
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new ValidationException(INVALID_DATE_MESSAGE);
        }
    }

    private static void validateDate(int date) {
        if (date < 1 || date > 31) {
            throw new ValidationException(INVALID_DATE_MESSAGE);
        }
    }
}
