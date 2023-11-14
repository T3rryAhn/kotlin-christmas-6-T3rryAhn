package christmas.domian.model;

import christmas.domian.type.Menu;

import java.util.*;

public class DecemberEvent {
    public static final int CHRISTMAS_DAY = 25;
    private static final int EVENT_START_DATE = 1;
    private static final int DAY_DISCOUNT_PRICE = 100;
    private static final int START_DISCOUNT_PRICE = 1_000;
    private static final int MIN_PRICE = 10_000;
    private static final int WEEKDAY_DISCOUNT_PRICE = 2_023;
    private static final int WEEKEND_DISCOUNT_PRICE = 2_023;
    private static final Map<Menu.Category, Integer> WEEKDAY_DISCOUNTS = Map.of(Menu.Category.DESSERT, WEEKDAY_DISCOUNT_PRICE);
    private static final Map<Menu.Category, Integer> WEEKEND_DISCOUNTS = Map.of(Menu.Category.MAIN, WEEKEND_DISCOUNT_PRICE);
    private static final List<Integer> WEEKEND_DATES = Arrays.asList(1, 2, 8, 9, 15, 16, 22, 23, 29, 30);
    private static final List<Integer> STAR_DATES = Arrays.asList(3, 10, 17, 24, 25, 31);
    private static final int SPECIAL_DISCOUNT_PRICE = 1_000;
    private static final int GIVEAWAY_CONDITION_PRICE = 120_000;
    private static final Map<Menu, Integer> GIVEAWAY_BENEFITS = Map.of(Menu.CHAMPAGNE, 1);


    public static boolean isOverThanMinPrice(int totalPrice) {
        return totalPrice >= MIN_PRICE;
    }

    public static boolean isStarDate(int date) {
        return STAR_DATES.contains(date);
    }

    public static boolean isWeekend(int date) {
        return WEEKEND_DATES.contains(date);
    }

    public static boolean isEligibleForGiveaway(int totalPrice) {
        return totalPrice >= GIVEAWAY_CONDITION_PRICE;
    }

    public static int getSpecialDiscountPrice() {
        return SPECIAL_DISCOUNT_PRICE;
    }

    public static Map<Menu.Category, Integer> getWeekdayDiscounts() {
        return WEEKDAY_DISCOUNTS;
    }

    public static Map<Menu.Category, Integer> getWeekendDiscounts() {
        return WEEKEND_DISCOUNTS;
    }

    public static Map<Menu, Integer> getGiveawayBenefits() {
        return GIVEAWAY_BENEFITS;
    }

    public static int getDayDiscountPrice() {
        return DAY_DISCOUNT_PRICE;
    }

    public static int getStartDiscountPrice() {
        return START_DISCOUNT_PRICE;
    }

    public static int getEventStartDate() {
        return EVENT_START_DATE;
    }
}
