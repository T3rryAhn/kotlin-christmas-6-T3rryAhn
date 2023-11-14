package christmas.domain.logic;

import christmas.domain.model.DecemberEvent;

public class ChristmasEventCalculator {
    public static int calculateChristmasDiscount(int date) {
        int startDay = DecemberEvent.getEventStartDate();
        int discountPricePerDay = DecemberEvent.getDayDiscountPrice();
        int discountPriceOfFirstDay = DecemberEvent.getStartDiscountPrice();

        if (date > DecemberEvent.CHRISTMAS_DAY) {
            return 0;
        }

        int daysUntilDate = date - startDay;
        int totalDiscount = discountPriceOfFirstDay + (daysUntilDate * discountPricePerDay);

        return totalDiscount;
    }
}
