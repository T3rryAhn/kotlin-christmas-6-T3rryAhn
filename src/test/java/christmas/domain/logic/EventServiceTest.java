package christmas.domain.logic;

import christmas.domain.model.EventResult;
import christmas.domain.type.Badge;
import christmas.domain.type.Menu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static christmas.TestConstants.*;
import static org.junit.jupiter.api.Assertions.*;

public class EventServiceTest {
    Map<Menu, Integer> order;

    @DisplayName("총구매 금액 10_000원 미만")
    @Test
    public void testMakeEventResult_만원미만() {
        order = ORDER_CORRECT_ORDER1;
        EventService eventService = new EventService(20, order);

        EventResult eventResult = eventService.makeEventResult();

        assertEquals(8_500, eventResult.getOrder().getTotalOrderPrice());
        assertEquals(0, eventResult.getTotalBenefitsPrice());
        assertEquals(8_500, eventResult.getFinalPrice());
        assertEquals(Badge.NONE, eventResult.getBadge());
    }

    @DisplayName("Case: 크리스마스 당일 order2 주문")
    @Test
    public void testMakeEventResult_case1() {
        order = ORDER_CORRECT_ORDER2;

        EventService eventService = new EventService(25, order);

        EventResult eventResult = eventService.makeEventResult();

        assertEquals(142_000, eventResult.getOrder().getTotalOrderPrice());
        assertEquals(33_446, eventResult.getTotalBenefitsPrice());
        assertEquals(133_554, eventResult.getFinalPrice());
        assertEquals(Badge.SANTA, eventResult.getBadge());
    }

    @DisplayName("Case: 3일, order2 주문")
    @Test
    public void testMakeEventResult_case2() {
        order = ORDER_CORRECT_ORDER2;

        EventService eventService = new EventService(3, order);

        EventResult eventResult = eventService.makeEventResult();

        assertEquals(142_000, eventResult.getOrder().getTotalOrderPrice());
        assertEquals(31_246, eventResult.getTotalBenefitsPrice());
        assertEquals(135_754, eventResult.getFinalPrice());
        assertEquals(Badge.SANTA, eventResult.getBadge());
    }

}
