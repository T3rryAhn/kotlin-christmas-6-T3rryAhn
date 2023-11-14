package christmas.domain.logic;

import christmas.domain.type.Badge;
import christmas.domain.type.Menu;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class EventCalculatorTest {

    @Test
    void isEligibleForEvent() {
        assertTrue(EventCalculator.isEligibleForEvent(15000));
        assertFalse(EventCalculator.isEligibleForEvent(5000));
    }

    @Test
    void calculateWeekdayDiscount_주중_디저트() {
        Map<Menu, Integer> order = Map.of(Menu.CHOCOLATE_CAKE, 1);
        int discount = EventCalculator.calculateWeekdayDiscount(3, order);
        assertEquals(2023, discount);
    }

    @Test
    void calculateWeekdayDiscount_주중_디저트없음() {
        Map<Menu, Integer> order = Map.of(Menu.CAESAR_SALAD, 1, Menu.TAPAS, 1);
        int discount = EventCalculator.calculateWeekdayDiscount(3, order);
        assertEquals(0, discount);
    }

    @Test
    void calculateWeekendDiscount_주말_메인() {
        Map<Menu, Integer> order = Map.of(Menu.T_BONE_STEAK, 2, Menu.TAPAS, 1);
        int discount = EventCalculator.calculateWeekendDiscount(4, order);
        assertEquals(2023 * 2, discount);
    }

    @Test
    void calculateWeekendDiscount_주말_메인없음() {
        Map<Menu, Integer> order = Map.of(Menu.ICE_CREAM, 1);
        int discount = EventCalculator.calculateWeekendDiscount(4, order);
        assertEquals(0, discount);
    }

    @Test
    void calculateSpecialDiscount_별데이() {
        int discount = EventCalculator.calculateSpecialDiscount(25);
        assertEquals(1000, discount);
    }

    @Test
    void calculateSpecialDiscount_별데이_아님() {
        int discount = EventCalculator.calculateSpecialDiscount(26);
        assertEquals(0, discount);
    }

    @Test
    void calculateGiveawayEvent() {
        Map<Menu, Integer> giveaway = EventCalculator.calculateGiveawayEvent(120000);
        assertNotNull(giveaway);
        assertTrue(giveaway.containsKey(Menu.CHAMPAGNE));
        assertEquals(1, giveaway.get(Menu.CHAMPAGNE));
    }

    @Test
    void calculateBadge() {
        assertEquals(Badge.SANTA, EventCalculator.calculateBadge(20000));
        assertEquals(Badge.SANTA, EventCalculator.calculateBadge(30000));
        assertEquals(Badge.TREE, EventCalculator.calculateBadge(15000));
        assertEquals(Badge.TREE, EventCalculator.calculateBadge(19999));
        assertEquals(Badge.STAR, EventCalculator.calculateBadge(7000));
        assertEquals(Badge.NONE, EventCalculator.calculateBadge(4000));
    }
}
