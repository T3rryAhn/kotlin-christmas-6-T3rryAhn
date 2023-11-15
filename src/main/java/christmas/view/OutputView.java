package christmas.view;

import christmas.domain.model.DecemberEvent;
import christmas.domain.model.EventResult;
import christmas.domain.type.Badge;
import christmas.domain.type.Benefit;
import christmas.domain.type.Menu;
import christmas.util.MapToStringConverter;

import java.util.Map;

public class OutputView {
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String INTRO_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private static final String RESULT_INTRO_MESSAGE = "12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";
    private static final String EVENT_CAUTION = "이벤트 주의 사항!" + LINE_SEPARATOR +
            " - 총주문 금액 10,000원 이상부터 이벤트가 적용됩니다." + LINE_SEPARATOR +
            " - 음료만 주문 시, 주문할 수 없습니다." + LINE_SEPARATOR +
            " - 메뉴는 한번에 최대 20개까지만 주문할 수 있습니다." + LINE_SEPARATOR;
    private static final String RESULT_HEAD_ORDERED_MENU = "<주문 메뉴>";
    private static final String RESULT_HEAD_TOTAL_PRICE = "<할인 전 총주문 금액>";
    private static final String RESULT_HEAD_GIVEAWAY_MENU = "<증정 메뉴>";
    private static final String RESULT_HEAD_BENEFIT_DETAILS = "<혜택 내역>";
    private static final String RESULT_HEAD_TOTAL_BENEFIT_PRICE = "<총혜택 금액>";
    private static final String RESULT_HEAD_DISCOUNTED_TOTAL_PRICE = "<할인 후 예상 결제 금액>";
    private static final String RESULT_HEAD_BADGE = "<12월 이벤트 배지>";
    private static final String PRICE = "%,d원";
    private static final String NONE = "없음";

    public void printIntro() {
        System.out.printf(INTRO_MESSAGE + LINE_SEPARATOR);
    }

    public void printCaution() {
        System.out.printf(EVENT_CAUTION + LINE_SEPARATOR);
    }

    public void printResult(EventResult eventResult) {
        printResultIntro(eventResult.getOrder().getDate());
        printOrder(eventResult.getOrder().getOrder());
        printTotalPrice(eventResult.getOrder().getTotalOrderPrice());
        printGiveawayMenu(eventResult.hasGiveawayBenefits());
        printBenefitDetails(eventResult.getBenefitHistory());
        printTotalBenefitPrice(eventResult.getTotalBenefitsPrice());
        printDiscountedPrice(eventResult.getFinalPrice());
        printBadge(eventResult.getBadge());
    }

    public void printResultIntro(int date) {
        System.out.printf(LINE_SEPARATOR + RESULT_INTRO_MESSAGE + LINE_SEPARATOR, date);
    }

    public void printOrder(Map<Menu, Integer> order) {
        System.out.printf(LINE_SEPARATOR + RESULT_HEAD_ORDERED_MENU + LINE_SEPARATOR);
        String result = MapToStringConverter.orderToString(order);
        System.out.printf(result);
    }



    public void printTotalPrice(int totalOrderPrice) {
        System.out.printf(LINE_SEPARATOR + RESULT_HEAD_TOTAL_PRICE + LINE_SEPARATOR);

        int price = totalOrderPrice;
        System.out.printf(PRICE, price);
        System.out.println();
    }

    public void printGiveawayMenu(boolean hasGiveawayBenefits) {
        System.out.printf(LINE_SEPARATOR + RESULT_HEAD_GIVEAWAY_MENU + LINE_SEPARATOR);

        String result = NONE + LINE_SEPARATOR;

        if (hasGiveawayBenefits) {
            result = MapToStringConverter.orderToString(DecemberEvent.getGiveawayBenefits());
        }

        System.out.printf(result);
    }

    public void printBenefitDetails(Map<Benefit, Integer> benefitAndPrice) {
        System.out.printf(LINE_SEPARATOR + RESULT_HEAD_BENEFIT_DETAILS + LINE_SEPARATOR);
        String result = NONE + LINE_SEPARATOR;

        if (!benefitAndPrice.isEmpty()) {
            result = MapToStringConverter.benefitToString(benefitAndPrice);
        }

        System.out.printf(result);
    }

    public void printTotalBenefitPrice(int totalBenefitPrice) {
        System.out.printf(LINE_SEPARATOR + RESULT_HEAD_TOTAL_BENEFIT_PRICE + LINE_SEPARATOR);
        String result = "-" + PRICE + LINE_SEPARATOR;
        if (totalBenefitPrice == 0) {
            result = PRICE + "\n";
        }
        System.out.printf(result, totalBenefitPrice);
    }

    public void printDiscountedPrice(int finalPrice) {
        System.out.printf(LINE_SEPARATOR + RESULT_HEAD_DISCOUNTED_TOTAL_PRICE + LINE_SEPARATOR);

        System.out.printf(PRICE + LINE_SEPARATOR, finalPrice);
    }

    public void printBadge(Badge badge) {
        System.out.printf(LINE_SEPARATOR + RESULT_HEAD_BADGE + LINE_SEPARATOR);

        System.out.printf(badge.getName() + LINE_SEPARATOR);
    }
}
