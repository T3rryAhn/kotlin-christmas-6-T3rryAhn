package christmas.domain.logic;

import christmas.domain.model.DecemberEvent;
import christmas.domain.type.Badge;
import christmas.domain.type.Menu;

import java.util.Collections;
import java.util.Map;

public class EventCalculator {
    public static boolean isEligibleForEvent(int totalPrice) {
        return DecemberEvent.isOverThanMinPrice(totalPrice);
    }

    public static int calculateWeekdayDiscount(int date, Map<Menu, Integer> order) {
        int totalDiscount = 0;
        Menu.Category category = DecemberEvent.getWeekdayDiscountCategory();
        int discountPrice = DecemberEvent.getWeekdayDiscountPrice();

        for (Map.Entry<Menu, Integer> entry : order.entrySet()) {
            Menu menu = entry.getKey();
            int quantity = entry.getValue();

            totalDiscount += calculateDiscountByCategory(menu, quantity, category, discountPrice);
        }

        return totalDiscount;
    }

    public static int calculateWeekendDiscount(int date, Map<Menu, Integer> order) {
        int totalDiscount = 0;
        Menu.Category category = DecemberEvent.getWeekendDiscountCategory();
        int discountPrice = DecemberEvent.getWeekendDiscountPrice();

        for (Map.Entry<Menu, Integer> entry : order.entrySet()) {
            Menu menu = entry.getKey();
            int quantity = entry.getValue();

            totalDiscount += calculateDiscountByCategory(menu, quantity, category, discountPrice);
        }

        return totalDiscount;
    }

    public static int calculateSpecialDiscount(int date) {
        if (DecemberEvent.isStarDate(date)) {
            return DecemberEvent.getSpecialDiscountPrice();
        }
        return 0;
    }

    public static Map<Menu, Integer> calculateGiveawayEvent(int totalPrice) {
        if (DecemberEvent.isEligibleForGiveaway(totalPrice)) {
            return DecemberEvent.getGiveawayBenefits();
        }
        return Collections.emptyMap();
    }

    public static Badge calculateBadge(int totalDiscount) {
        Badge badge = Badge.findByTotalDiscount(totalDiscount);
        return badge;
    }

    private static int calculateDiscountByCategory(Menu menu, int quantity, Menu.Category category, int discountPrice) {
        if (menu.getCategory().equals(category)) {
            return quantity * discountPrice;
        }
        return 0;
    }
}
