package christmas.view;

import christmas.domain.model.DecemberEvent;
import christmas.domain.model.EventResult;
import christmas.domain.type.Badge;
import christmas.domain.type.Benefit;
import christmas.domain.type.Menu;
import christmas.util.MapToStringConverter;

import java.util.Map;

public class OutputView {
    private static final String INTRO_MESSAGE = "12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";
    private static final String EVENT_CAUTION = "이벤트 주의 사항! \n - 총주문 금액 10,000원 이상부터 이벤트가 적용됩니다.\n - 음료만 주문 시, 주문할 수 없습니다.\n - 메뉴는 한번에 최대 20개까지만 주문할 수 있습니다.\n";
    private static final String RESULT_HEAD_ORDERED_MENU = "\n<주문 메뉴>\n";
    private static final String RESULT_HEAD_TOTAL_PRICE = "\n<할인 전 총주문 금액>\n";
    private static final String RESULT_HEAD_GIVEAWAY_MENU = "\n<증정 메뉴>\n";
    private static final String RESULT_HEAD_BENEFIT_DETAILS = "\n<혜택 내역>\n";
    private static final String RESULT_HEAD_TOTAL_BENEFIT_PRICE = "\n<총혜택 금액>\n";
    private static final String RESULT_HEAD_DISCOUNTED_TOTAL_PRICE = "\n<할인 후 예상 결제 금액>\n";
    private static final String RESULT_HEAD_BADGE = "\n<12월 이벤트 배지>\n";
    private static final String PRICE = "%,d원";
    private static final String MENU_AND_QUANTITY = "%s %d개";
    private static final String NONE = "없음\n";

    public void printAll(EventResult eventResult) {
        printIntro(eventResult.getOrder().getDate());
        printOrder(eventResult.getOrder().getOrder());
        printTotalPrice(eventResult.getOrder().getTotalOrderPrice());
        printGiveawayMenu(eventResult.hasGiveawayBenefits());
        printBenefitDetails(eventResult.getBenefitHistory());
        printTotalBenefitPrice(eventResult.getTotalBenefitsPrice());
        printDiscountedPrice(eventResult.getFinalPrice());
        printBadge(eventResult.getBadge());
    }

    public void printIntro(int date) {
        System.out.printf("\n" + INTRO_MESSAGE + "\n", date);
    }

    public void printCaution() {
        System.out.println(EVENT_CAUTION);
    }

    public void printOrder(Map<Menu, Integer> order) {
        System.out.printf(RESULT_HEAD_ORDERED_MENU);
        String result = MapToStringConverter.orderToString(order);
        System.out.printf(result);
    }



    public void printTotalPrice(int totalOrderPrice) {
        System.out.printf(RESULT_HEAD_TOTAL_PRICE);

        int price = totalOrderPrice;
        System.out.printf(PRICE, price);
        System.out.println();
    }

    public void printGiveawayMenu(boolean hasGiveawayBenefits) {
        System.out.printf(RESULT_HEAD_GIVEAWAY_MENU);

        String result = NONE;

        if (hasGiveawayBenefits) {
            result = MapToStringConverter.orderToString(DecemberEvent.getGiveawayBenefits());
        }

        System.out.printf(result);
    }

    public void printBenefitDetails(Map<Benefit, Integer> benefitAndPrice) {
        System.out.printf(RESULT_HEAD_BENEFIT_DETAILS);
        String result = NONE;

        if (!benefitAndPrice.isEmpty()) {
            result = MapToStringConverter.benefitToString(benefitAndPrice);
        }
        System.out.printf(result);
    }

    public void printTotalBenefitPrice(int totalBenefitPrice) {
        System.out.printf(RESULT_HEAD_TOTAL_BENEFIT_PRICE);

        System.out.printf("-" +PRICE + "\n", totalBenefitPrice);
    }

    public void printDiscountedPrice(int finalPrice) {
        System.out.printf(RESULT_HEAD_DISCOUNTED_TOTAL_PRICE);

        System.out.printf(PRICE + "\n", finalPrice);
    }

    public void printBadge(Badge badge) {
        System.out.printf(RESULT_HEAD_BADGE);

        System.out.printf(badge.getName() + "\n");
    }
}
