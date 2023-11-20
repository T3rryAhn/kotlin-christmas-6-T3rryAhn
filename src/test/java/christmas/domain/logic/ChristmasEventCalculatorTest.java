package christmas.domain.logic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChristmasEventCalculatorTest {
    @DisplayName("이벤트 첫날 구매")
    @Test
    void calculatorChristmasDiscount_첫날() {
        int discount = ChristmasEventCalculator.calculateChristmasDiscount(1);
        assertEquals(1000, discount);
    }

    @DisplayName("크리스마스날 구매")
    @Test
    void calculatorChristmasDiscount_크리스마스날() {
        int discount = ChristmasEventCalculator.calculateChristmasDiscount(25);
        assertEquals(3400, discount);
    }

    @DisplayName("이벤트 이후 구매")
    @Test
    void calculatorChristmasDiscount_correct() {
        int discount = ChristmasEventCalculator.calculateChristmasDiscount(26);
        assertEquals(0, discount);
    }
}
