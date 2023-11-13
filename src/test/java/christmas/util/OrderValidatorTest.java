package christmas.util;

import christmas.domian.type.Menu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Map;
import java.util.stream.Stream;

import static christmas.TestConstants.*;
import static org.junit.jupiter.api.Assertions.*;

public class OrderValidatorTest {
    private static final String ERROR = "[ERROR] ";
    private static final String INVALID_ORDER_MESSAGE = "유효하지 않은 주문입니다. 다시 입력해 주세요.";
    private static final String CORRECT_INPUT1 = "타파스-1,제로콜라-1";
    private static final String CORRECT_INPUT2 = "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1";
    private static final Map<Menu, Integer> CORRECT_ORDER = Map.of(Menu.TAPAS, 1, Menu.ZERO_COKE, 1);

    @DisplayName("파싱전 - 올바른 입력")
    @ValueSource(strings = {CORRECT_INPUT1, CORRECT_INPUT2})
    @ParameterizedTest
    void validateInput_CorrectFormat(String input) {
        assertDoesNotThrow(() -> OrderValidator.validateInput(input));
    }

    @DisplayName("파싱전 - 띄어쓰기만 틀린 입력")
    @ValueSource(strings = {"타파스 -1,제로콜라-1", "타파스-1,제로 콜라-1", "타파스- 1"})
    @ParameterizedTest
    void validateInput_InCorrectedSpaceFormat(String input) {
        assertThrows(ValidationException.class, () -> OrderValidator.validateInput(input));
    }

    @DisplayName("파싱전 - 잘못된 입력")
    @ValueSource(strings = {ORDER_DUPLICATED_INPUT1, ORDER_NON_EXISTS_MENU_INPUT1, ORDER_NON_EXISTS_MENU_INPUT2})
    @ParameterizedTest
    void validateInput_InCorrectedFormat(String input) {
        assertThrows(ValidationException.class, () -> OrderValidator.validateInput(input));
    }

    @DisplayName("올바른 주문")
    @MethodSource("provideCorrectOrders")
    @ParameterizedTest
    void validateOrder_CorrectOrder(Map<Menu, Integer> order) {
        assertDoesNotThrow(() -> OrderValidator.validateOrder(order));
    }

    private static Stream<Map<Menu, Integer>> provideCorrectOrders() {
        return Stream.of(
                ORDER_CORRECT_ORDER1, ORDER_CORRECT_ORDER2, ORDER_CORRECT_ORDER3
        );
    }

    @DisplayName("잘못된 주문")
    @MethodSource("provideInCorrectOrders")
    @ParameterizedTest
    void validateOrder_InCorrectOrder(Map<Menu, Integer> order) {
        assertThrows(ValidationException.class, () -> OrderValidator.validateOrder(order));
    }

    private static Stream<Map<Menu, Integer>> provideInCorrectOrders() {
        return Stream.of(
                ORDER_ONLY_BEVERAGE_ORDER1, ORDER_ONLY_BEVERAGE_ORDER2
                , ORDER_UNDER_MIN_AMOUNT_ORDER1, ORDER_UNDER_MIN_AMOUNT_ORDER2
                , ORDER_OVER_MAX_AMOUNT_ORDER1, ORDER_OVER_MAX_AMOUNT_ORDER2
        );
    }

}
