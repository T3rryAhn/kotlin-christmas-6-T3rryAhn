package christmas.domain.model;

import christmas.domain.type.Badge;
import christmas.domain.type.Benefit;

import java.util.Map;

public class EventResult {
    private final OrderInfo orderInfo;
    private final Map<Benefit, Integer> benefitHistory;
    private final int totalBenefitsPrice;
    private final int finalPrice;
    private final Badge badge;

    public EventResult(OrderInfo orderInfo, Map<Benefit, Integer> benefitHistory, int totalBenefitsPrice, Badge badge) {
        this.orderInfo = orderInfo;
        this.benefitHistory = benefitHistory;
        this.totalBenefitsPrice = totalBenefitsPrice;
        this.finalPrice = calculateFinalPrice();
        this.badge = badge;
    }

    // getter
    public OrderInfo getOrder() {
        return orderInfo;
    }

    public Map<Benefit, Integer> getBenefitHistory() {
        return benefitHistory;
    }

    public int getTotalBenefitsPrice() {
        return totalBenefitsPrice;
    }

    public int getFinalPrice() {
        return finalPrice;
    }

    public Badge getBadge() {
        return badge;
    }

    //private 헬퍼
    private int calculateFinalPrice() {
        int finalPrice = orderInfo.getTotalOrderPrice() - totalBenefitsPrice;

        if (benefitHistory.containsKey(Benefit.GIVEAWAY)) {
           finalPrice += benefitHistory.get(Benefit.GIVEAWAY);
        }

        return finalPrice;
    }
}
