package christmas.domain.logic;

import christmas.domain.model.DecemberEvent;
import christmas.domain.model.OrderInfo;
import christmas.domain.model.EventResult;
import christmas.domain.type.Badge;
import christmas.domain.type.Benefit;
import christmas.domain.type.Menu;

import java.util.HashMap;
import java.util.Map;

public class EventService {
    private final OrderInfo orderInfo;
    private Map<Benefit, Integer> benefitHistory = new HashMap<>();

    public EventService(int date, Map<Menu, Integer> order) {
        this.orderInfo = new OrderInfo(date, order);
    }

    public EventResult makeEventResult() {
        int totalOrderPrice = orderInfo.getTotalOrderPrice();
        int date = orderInfo.getDate();
        int totalBenefitsPrice = 0;
        Badge badge = Badge.NONE;

        if (EventCalculator.isEligibleForEvent(totalOrderPrice)) {
            checkAll(totalOrderPrice, date);
            totalBenefitsPrice = calculateTotalBenefitsPrice();
            badge = checkBadge(totalBenefitsPrice);
        }

        EventResult eventResult = new EventResult(orderInfo, benefitHistory, totalBenefitsPrice, badge);
        return eventResult;
    }

    private void checkAll(int totalOrderPrice, int date) {
        checkChristmasEvent(date);
        checkWeekdayDiscount(date);
        checkWeekendDiscount(date);
        checkSpecialDiscount(date);
        checkGiveaway(totalOrderPrice);
    }

    private void updateBenefitHistory(Benefit benefit, int discount) {
        if (discount != 0) {
            benefitHistory.put(benefit, discount);
        }
    }

    private void checkGiveaway(int totalPrice) {
        Map<Menu, Integer> giveaway = EventCalculator.calculateGiveawayEvent(totalPrice);
        int discount = 0;

        for (Map.Entry<Menu, Integer> entry : giveaway.entrySet()) {
            Menu menu = entry.getKey();
            int quantity = entry.getValue();
            int menuPrice = menu.getPrice(); // 메뉴의 가격을 가져옵니다.

            discount += menuPrice * quantity;
        }

        if (discount != 0) {
            updateBenefitHistory(Benefit.GIVEAWAY, discount);
        }
    }

    private void checkWeekdayDiscount(int date) {
        int discount = 0;

        if (!DecemberEvent.isWeekend(date)) {
            discount = EventCalculator.calculateWeekdayDiscount(date, orderInfo.getOrder());
            updateBenefitHistory(Benefit.WEEKDAY, discount);
        }
    }

    private void checkWeekendDiscount(int date) {
        int discount = 0;

        if (DecemberEvent.isWeekend(date)) {
            discount = EventCalculator.calculateWeekendDiscount(date, orderInfo.getOrder());
            updateBenefitHistory(Benefit.WEEKEND, discount);
        }
    }

    private void checkChristmasEvent(int date) {
        int discount = ChristmasEventCalculator.calculateChristmasDiscount(date);

        if (discount != 0) {
            updateBenefitHistory(Benefit.CHRISTMAS_D_DAY, discount);
        }
    }

    private void checkSpecialDiscount(int date) {
        int discount = EventCalculator.calculateSpecialDiscount(date);

        if (discount != 0) {
            updateBenefitHistory(Benefit.SPECIAL, discount);
        }
    }

    private int calculateTotalBenefitsPrice() {
        int totalBenefitsPrice = benefitHistory
                .values()
                .stream()
                .mapToInt(Integer::intValue)
                .sum();

        return totalBenefitsPrice;
    }

    private Badge checkBadge(int totalBenefitsPrice) {
        return EventCalculator.calculateBadge(totalBenefitsPrice);
    }
}

