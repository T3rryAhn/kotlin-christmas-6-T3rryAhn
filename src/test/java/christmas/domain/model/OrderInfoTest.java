package christmas.domain.model;

import christmas.domain.type.Menu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderInfoTest {
    private final static Map<Menu, Integer> ORDER = Map.of(Menu.T_BONE_STEAK, 2, Menu.CHAMPAGNE, 1);
    private final static int TOTAL_PRICE = Menu.T_BONE_STEAK.getPrice() * 2 + Menu.CHAMPAGNE.getPrice(); // 13_5000

    @DisplayName("총액계산확인")
    @Test
    public void testCalculateTotalOrderPrice() {
        OrderInfo orderInfo = new OrderInfo(15, ORDER);

        assertEquals(TOTAL_PRICE, orderInfo.getTotalOrderPrice());
    }

}

