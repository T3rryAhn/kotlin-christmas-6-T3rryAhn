package christmas.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DateValidatorTest {
    private static final String VALID_DATE = "31";
    private static final String INVALID_DATE = "32";
    private static final String NOT_NUMERIC = "ABC";
    private static final String ERROR_MESSAGE = "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.";

    @DisplayName("정상적인 날짜 입력")
    @Test
    void validateNumeric_withValidDateInput() {
        assertDoesNotThrow(() -> DateValidator.validateInput(VALID_DATE));
    }

    @DisplayName("비정상적인 날짜 입력")
    @Test
    void validateDate_withInvalidDate() {
        ValidationException exception = assertThrows(
                ValidationException.class,
                () -> DateValidator.validateInput(INVALID_DATE));
        assertEquals(ERROR_MESSAGE, exception.getMessage());
    }

    @DisplayName("null 입력")
    @Test
    void validateNumeric_withNullInput() {
        ValidationException exception = assertThrows(
                ValidationException.class,
                () -> DateValidator.validateInput(null));
        assertEquals(ERROR_MESSAGE, exception.getMessage());
    }

    @DisplayName("숫자 형식이 아닌 입력")
    @Test
    void validateDate_withNonNumericInput() {
        ValidationException exception = assertThrows(
                ValidationException.class,
                () -> DateValidator.validateInput(NOT_NUMERIC));
        assertEquals(ERROR_MESSAGE, exception.getMessage());
    }
}
